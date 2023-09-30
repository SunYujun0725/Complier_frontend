README

姓名: 孫渝鈞
學號: 409510049
e-mail: yujun91725@gmail.com

完成項目:
1.subset_description.docx: 一個描述我完成哪些subset產生出來的LLVM IR，除了本身老師給的基本要求，我還另外加了一些額外subset
2.myCompiler.g:一個描述我myCompiler.g怎麼建的檔案
3.myCompiler_test.java: 一個呼叫我的myCompiler的java檔
4.test1.c,test2.c, test3.c, test4.c:四個測試檔
(test1.c主要測試int,float assignment跟arithmetic computation)
(test2.c主要測試comparison expression跟if-then/if-then-else)
5.Makefile
6.README.txt:文字檔描述整個作業內容
7.test1.ll, test2.ll, test3.ll, test4.ll:產生出來的LLVM IR都放在這裡面

我完成的subset轉換LLVM IR有以下幾個：
(1) Integer data types: int, const_int
(2) Statements for arithmetic computation. (e.g., a=b+2*(100-1);) [+,-,*,/]
(3) Comparison expression. (e.g., a > b)，comparison operation: >、>=、<、<=、==、!= 
(4) if-then / if-then-else program constructs. 
(5) printf function with one/two parameters. (support types: %d) 
For example: 
	printf("Number is %d\n", var);
	printf("Hello\n");
----------------------------------------------------------------------------------------------------------------------------------
(1) Float data types: float, const_cloat
	包含：宣告變數、assignment、printf、arith_expression、cond_expression
(2) unary operator(單負運算子)
	Ex:
		a = -a;
		a = -5;
(3) for迴圈
(4) while迴圈
(5) 所有型別檢查，但是因為印出Error:行數出來會導致.ll檔無法成功執行所以我的範例程式就沒寫到。


在myChecker.g內我選擇用grammar表示裡面可以寫parser, lexer,也可以在裡面傳attributes產生出LLVM IR。我在opions內language選擇java。
1.Integer data types: int, const_int
2.float data types: float, const_int
因為在LLVM IR內int a跟5是不同的表示方式，a可以表示成%t1，而5是直接表示5所以要分開討論
在LLVM IR內float c跟2.34是不同的表示方式，c可以表示成%t2，而2.34要表示成IEEE754的16-digit form=>0x4002b851e0000000，所以這兩個也要分開討論

3.相關數學運算子四則運算：arith_expression
除了+, -, *, /，我還額外增加unary operator(-)，並且依照他們的優先級來寫parser並產生LLVM IR。
優先級：
	1. ()
	2. - 單負號(ex:-a,-b...)
	3. /,*,%
	4. +,-
產生相對應的LLVM IR：int就有4種可能，float也有4種可能，我以“+”為例子說明
	ex: 
		int a;
		int b;
		float c;
		float d;
		a+b;----------->%t8 = add nsw i32 %t6, %t7
		a+5;----------->%t8 = add nsw i32 %t6, 5
		5+a;----------->%t8 = add nsw i32 5, %t6	
		5+5;----------->%t8 = add nsw i32 5, 5
		c+d;----------->%t8 = fadd float %t8, %t9
		c+1.2;-------->%t8 = fadd float %t8, 0x3ff3333340000000
		1.2+c;-------->%t8 = fadd float 0x3ff3333340000000, %t8
		1.2+2.34;----->%t8 = fadd float 0x3ff3333340000000, 0x4002b851e0000000
所以每個operator都有8個可能要考慮
其他運算子邏輯差不多就只是把add nsw i32改成(sub nsw i32/ mul nsw i32/ sdiv i32)
		       fadd float改成(fsub float/ fmul float/ fdiv float)
*有一個變數varCount是來控制%t的數子

4.Comparison expression. (e.g., a > b)，comparison operation: >、>=、<、<=、==、!=
比較運算子也是一樣每一種都有8種可能，比較不一樣的是我把所以operator寫在RelationOP: '>' |'>=' | '<' | '<=' | '==' | '!=';
所以一樣用if-else列出8種可能後，在去switch case判斷是哪一種operator，然後再把相對應的LLVM IR放入字串llvmOP中，等之後一起放入TextCode.add
ex:
	switch ($RelationOP.getText()){
		case "<":
			llvmOP = "icmp slt";  //fcmp olt
			break;
		case ">":
			llvmOP = "icmp sgt";  //fcmp ogt
			break;
		case ">=":
			llvmOP = "icmp sge";  //fcmp oge
			break;
		case "<=":
			llvmOP = "icmp sle";  //fcmp ole
			break;
		case "==":
			llvmOP = "icmp eq";   //fcmp oeq
			break;
		case "!=":
			llvmOP = "icmp ne";   //fcmp une
			break;
		default:
			$theInfo.theType = Type.ERR;
			break;
	}

5.if-then/if-then-else:
一樣先檢查cond_expression是不是BOOL型態，如果不是就是錯誤
我有寫三個String分別是ifLabel, thenLabel, elseLabel跟一個int is_else記錄是否有else，is_else=0代表沒有，is_else=1代表有，用完後要回歸0。
接著先產生ifLabel(L1)跟thenLable(L2)，因為不知道有沒有else就先不產生elseLabel
接著產生評估運算式：br i1 %cond_expression, label %L1, lebel %L2 (cond_expression為真就跳到L1否則跳到L2)
產生L1:以及if_block的statements的LLVM IR

(1)如果有進入else就產生elseLabel(L3)
	然後產生br label %L3以及L2:  (跳到L3離開，這時候L2對他來說是else會執行的地方)
	接著產生else_block的statements的LLVM IR
	產生br label %L3 (這時候L3對於他來說是離開要去的label)
	產生L3:
	然後把is_else改成1
(2)如果沒有進入else，is_else就會是0
	所以就可以寫一個if(is_else==0)就要產生br label %L2 (這時候L2對於他來說是離開要去的label)、產生L2:
------------------------------------------------------------------------------------------------------------------------------
pesudo code:
(1)沒有進入else:
	br i1 %cond_expression, label %L1, label %L2 (if成立就做L1內事情，沒有就跳到L2離開)
	L1:
	if_block_statement(ex:a=a+1;...)
	br label %L2
	L2:
(2)有進入else:
	br i1 %cond_expression, label %L1, label %L2 (if成立就做L1內事情，沒有就跳到L2的else)
	L1:
	if_block_statement(ex:a=a+1;...)
	br label %L3 (L1做完，就跳到L3離開)
	L2:
	else_block_statement(ex:b=b+1;...)
	br label %L3 (L2做完，就跳到L3離開)
	L3:

6. printf function with one/two parameters. (support types: %d) 
首先要先將字串的結尾\n換成\0A\00，ex: "Hello world" => "Hello world\0A\00"
如果字串結尾沒有\n就換成\00，ex:"%d" => "%d\00"
然後計算字串長度(\0A與\00算一個字元)
(1)有一參數%d
接著直接印出System.out.println("@.str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + 替換\n後的字串);因為這一行要放在
TextCode.add("define dso_local i32 @main()");外面，所以我用直接印出的方式，他就會在上面了不會寫入@main裡面
p.s.
System.out.println("; === prologue ====");
System.out.println("declare dso_local i32 @printf(i8*, ...)\n");這兩行我也直接先印出確保@.str .....在這兩行與@main之間
接著就是TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + 字串長度 + " x i8], [" + 字串長度 + " x i8]* @.str" + var_str_Count + ", i64 0, i64 0), i32 \%t" + $a.theInfo.theVar.varIndex + ")" );
(2)有一參數%f
跟一個參數%d類似，只是float要讓function call時要轉成double型態
TextCode.add("\%t" + varCount + " = fpext float \%t" + $b.theInfo.theVar.varIndex + " to double");
其餘實現概念差不多
(3)純文字
System.out.println("@str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + 替換\n後的字串);
TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + 字串長度 + " x i8], [" + 字串長度 + " x i8]* @str" + var_str_Count + ", i64 0, i64 0))");
也是跟一個參數%d作法差不多，只是加到TextCode形式有變，因為沒有參數。

7.unary operator(單負運算子)
總共有4種可能，並且以0-number的概念去實現
	ex:
		int a;
		float b;
		a = -a;------------> %t5 = sub nsw i32 0, %t4
		a = -5;------------> %t5 = sub nsw i32 0, 5
		b = -b;------------> %t7 = fsub float 0x0000000000000000, %t6
		b = -2.34----------> %t7 = fsub float 0x0000000000000000, 0x4002b851e0000000
一樣比較特別的是float要轉成IEEE754的16-digit form

8.for_loop
for(a=assign_stmt;cond_expression;b=assign_stmt_templlvmIR){for_block_stmt}
跟if-else一樣，我先宣告loop, loop_body, loop_end三個全域變數String
但是一開始我就直接產生這三個的label(loop(L1), loop_body(L2), loop_end(L3))
一開始產生br label L1以及L1: (讓他進入L1)
接著在L1內產生br i1 %tcond_expression, label %loop_body , label %loop_end 判斷條件是否成立，成立的話就進入loop_body，沒成立就跳到loop_end離開
藉著產生loop_body:裡面放for_block_stmt的LLVM IR，比較需要注意的是因為規則的寫法會先到b=assign_stmt_templlvmIR，所以我額外寫了一個assign_stmt_templlvmIR先把b產生的LLVM IR暫存起來先不要放到TextCode
等到for_block_stmt的LLVM IR放完後再把剛暫存的加到TeextCode。
然後br label %L1回到loop判斷是否要繼續迴圈
最後產生L3:離開
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
pesudo code:
	br label L1
	L1:
	br i1 %tcond_expression, label %L2 , label %L3 (判斷條件是否成立，成立就進入L2，不成立就跳到L3離開)
	L2:
	for_block的statements LLVM IR (ex: a=a+1;....)
	assign_stmt_templlvmIR的LLVM IR (ex: i=i+1;)
	br label %L1 (回到L1判斷是否要繼續loop)
	L3:  (離開loop)

9.while
跟for差不多，只差在沒有for的b=assign_stmt_templlvmIR(while會把離開這部分寫在while_block_stmt內)，所以就不用暫存，其餘的就跟for概念一樣。


宣告
int: %t1 = alloca i32, align 4"
float: %t2 = alloca float, align 4")

assignment給值
有四種可能：int給int, const_int給int, float給float, const_float給float
	ex:
		int a,b;
		float c,d;
		a = b;------------>store i32 %t3, i32* %t2
		a = 5;------------>store i32 5, i32* %t2
		c = d;------------>store float %t5, float* %t4
		c = 2.34;--------->store float 0x4002b851e0000000, float* %t4
一樣遇到const_float要轉換成IEEE754的16-digit form

所有Type checker:跟project3一樣，只是範例測試檔沒有錯誤，因為產生錯誤訊息會導致.ll無法正確運作

接著我需要寫一個myCompiler_test.java來呼叫我的myCompiler，跟測試檔來測試我的語法
上面檔案都完成，我要先執行java -cp antlr-3.5.3-complete-no-st3.jar org.antlr.Tool myCompiler.g
來產生myCompilerlexer.java它主要包含lexical analyzer的sourse code跟myCompilerlexer.token裏面包含每個token type每個token type會給一個id
，還有myCompilerParser.java然後在編譯javac -cp antlr-3.5.3-complete-no-st3.jar:. *java完成.class的byte code檔案
最後才是執行input file:java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test1.c > test1.ll
比較不一樣的是我將結果寫到.ll的檔案，然後在執行gcc test1.ll將.ll轉成.s，最後再用gcc -no-pie test1.s產生test1.out執行檔(投影片指令是gcc test1.s但是如果我沒下-no-pie的話我的電腦會出現錯誤)，最後執行./test1.out就有程式碼結果產生了。


