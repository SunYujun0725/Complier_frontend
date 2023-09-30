grammar myCompiler;

options {
   language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    
}

@members {
    boolean TRACEON = false;

    // Type information.
    public enum Type{
       ERR, BOOL, INT, FLOAT, CHAR, CONST_INT, CONST_FLOAT;
    }

    // This structure is used to record the information of a variable or a constant.
    class tVar {
	   int   varIndex; // temporary variable's index. Ex: t1, t2, ..., etc.
	   int   iValue;   // value of constant integer. Ex: 123.
	   float fValue;   // value of constant floating point. Ex: 2.314.
	};

    class Info {
       Type theType;  // type information.
       tVar theVar;
	   
	   Info() {
          theType = Type.ERR;
		  theVar = new tVar();
	   }
    };

	
    // ============================================
    // Create a symbol table.
	// ArrayList is easy to extend to add more info. into symbol table.
	//
	// The structure of symbol table:
	// <variable ID, [Type, [varIndex or iValue, or fValue]]>
	//    - type: the variable type   (please check "enum Type")
	//    - varIndex: the variable's index, ex: t1, t2, ...
	//    - iValue: value of integer constant.
	//    - fValue: value of floating-point constant.
    // ============================================

    HashMap<String, Info> symtab = new HashMap<String, Info>();

    // labelCount is used to represent temporary label.
    // The first index is 0.
    int labelCount = 0;
	
    // varCount is used to represent temporary variables.
    // The first index is 0.
    int varCount = 0;

	//The first printf @str is 0.
	int var_str_Count = 0;

    // Record all assembly instructions.
    List<String> TextCode = new ArrayList<String>();


    /*
     * Output prologue.
     */
    void prologue()
    {
		/*
       TextCode.add("; === prologue ====");
       TextCode.add("declare dso_local i32 @printf(i8*, ...)\n");
	   */
	   System.out.println("; === prologue ====");
	   System.out.println("declare dso_local i32 @printf(i8*, ...)\n");
       TextCode.add("define dso_local i32 @main()");
       TextCode.add("{");
    }
    
	
    /*
     * Output epilogue.
     */
    void epilogue()
    {
       /* handle epilogue */
       TextCode.add("\n; === epilogue ===");
       TextCode.add("ret i32 0");
       TextCode.add("}");
    }
    
    
    /* Generate a new label */
    String newLabel()
    {
       labelCount ++;
       return (new String("L")) + Integer.toString(labelCount);
    } 
    
    
    public List<String> getTextCode()
    {
       return TextCode;
    }

	// if-else
	String ifLabel;
    String thenLabel;
    String elseLabel;
	int is_else=0;   //用來判斷if有沒有else

	//for-loop
	String loop;
	String loop_body;
	String loop_end;
	String templlvmIR;
}

program: VOID MAIN '(' ')'
        {
           /* Output function prologue */
           prologue();
        }

        '{' 
           declarations
           statements
        '}'
        {
	   	if (TRACEON)
	      	System.out.println("VOID MAIN () {declarations statements}");

           	/* output function epilogue */	  
           	epilogue();
        }
        ;


declarations: type Identifier ';' declarations    //宣告
        {
        	if (TRACEON)
            	System.out.println("declarations: type Identifier : declarations");

           	if (symtab.containsKey($Identifier.text)) {
              	// variable re-declared.重複宣告
              	System.out.println("Error! " + $Identifier.getLine() + " : Redeclared identifier.");
              	System.exit(0);
           	}
                 
           	/* Add ID and its info into the symbol table. */
	   	   	Info the_entry = new Info();
           	the_entry.theType = $type.attr_type;
           	the_entry.theVar.varIndex = varCount;
	       	varCount ++;
	       	symtab.put($Identifier.text, the_entry);

           	// issue the instruction.
	   		// Ex: \%a = alloca i32, align 4
           	if ($type.attr_type == Type.INT) { 
              	TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
           	}
           	else if ($type.attr_type == Type.FLOAT) {
    	      	TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
	   		}
	   		else if ($type.attr_type == Type.CHAR) {
    	     	TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i8, align 1");
	   		}
			else{
				//宣告了不存在的datatype或未支援
				System.out.println ("Error!" + $Identifier.getLine() + " : This datatype is not supported or wrong");
				System.exit(0);
			}
        }
        | 
        {
           	if (TRACEON)
              	System.out.println("declarations: ");
        }
        ;


type
returns [Type attr_type]
    : INT { if (TRACEON) System.out.println("type: INT"); $attr_type=Type.INT; }
    | CHAR { if (TRACEON) System.out.println("type: CHAR"); $attr_type=Type.CHAR; }
    | FLOAT { if (TRACEON) System.out.println("type: FLOAT"); $attr_type=Type.FLOAT; }
	;


statements:statement statements
          |
          ;


statement: assign_stmt ';'
         | if_stmt
         | func_no_return_stmt ';'
         | for_stmt
		 | while_stmt
		 | PRINTF '(' printf_expression ')' ';' 
		 | COMMENT
         ;

for_stmt: FOR   '(' 
				a=assign_stmt ';'
					{
						loop = newLabel();
						loop_body = newLabel();
						loop_end = newLabel();
						TextCode.add("br label \%" + loop);
						TextCode.add(loop + ":");
					}
                cond_expression ';'
					{
						if($cond_expression.theInfo.theType != Type.BOOL){
							System.out.println("Error! " + $FOR.getLine() + ": The type of condition is not BOOL.");
							System.exit(0);
						}
						// 評估條件運算式
      					TextCode.add("br i1 \%t" + $cond_expression.theInfo.theVar.varIndex + ", label \%" + loop_body + ", label \%" + loop_end);
						TextCode.add(loop_body + ":");
					}
                b=assign_stmt_templlvmIR
              	')'
                for_block_stmt
					{
						TextCode.add(templlvmIR);     //做完for_block_stmt後把剛剛暫存的llvmIR放進來
						TextCode.add("br label \%" + loop);
						TextCode.add(loop_end + ":");
					}
        		;

for_block_stmt:
			'{' statements '}'
			;

while_stmt: WHILE '(' 
				{
	 				loop = newLabel();
					loop_body = newLabel();
					loop_end = newLabel();
					TextCode.add("br label \%" + loop);
					TextCode.add(loop + ":");
	 			}
			cond_expression 
				{
					if($cond_expression.theInfo.theType != Type.BOOL){
						System.out.println("Error! " + $WHILE.getLine() + ": The type of condition is not BOOL.");
						System.exit(0);
					}
					TextCode.add("br i1 \%t" + $cond_expression.theInfo.theVar.varIndex + ", label \%" + loop_body + ", label \%" + loop_end);
					TextCode.add(loop_body + ":");
				}
			')' while_block_stmt
	 			{
					TextCode.add("br label \%" + loop);
					TextCode.add(loop_end + ":");

	 			}
			;

while_block_stmt:
				'{' statements '}'
				;

if_stmt
            : IF '(' a=cond_expression ')' 
			{
				//檢查condition是不是BOOL
				if($a.theInfo.theType != Type.BOOL){
					System.out.println("Error! " + $IF.getLine() + ": The type of condition is not BOOL.");
					System.exit(0);
				}
				// 產生 if-else 陳述式的 LLVM IR 程式碼
      			ifLabel = newLabel();
      			thenLabel = newLabel();
				

				// 評估條件運算式
      			TextCode.add("br i1 \%t" + $a.theInfo.theVar.varIndex + ", label \%" + ifLabel + ", label \%" + thenLabel);
		
				// 產生 "if" 區塊
      			TextCode.add(ifLabel + ":");
			}
			if_block_stmt
			(ELSE else_block_stmt)?
			{
				// 產生結束標籤
				if(is_else==0){    //如果沒有else
					TextCode.add("br label \%" + thenLabel);
					TextCode.add(thenLabel + ":");
				}

				//is_else歸零
				is_else = 0;
			}
			;
				  
if_block_stmt
		: '{' statements '}'
	  	;
else_block_stmt
		: 	'{' 
				{
					elseLabel = newLabel();
					TextCode.add("br label \%" + elseLabel);
					TextCode.add(thenLabel + ":");

			  	} 
			statements '}'
		{
			TextCode.add("br label \%" + elseLabel);
			TextCode.add(elseLabel + ":");
			is_else = 1;

		}
		;

printf_expression: TEXT1 ',' a=arith_expression 
				{
					//先檢查type是否符合
					if($a.theInfo.theType != Type.INT){
						System.out.println("Error! " + $TEXT1.getLine() + ": Type mismatch for the printf function.");
						System.exit(0);
					}

					int Text_length;
					String replacedText="";
					String newstr="";
					if(($TEXT1.text.contains("\\n"))||($TEXT1.text.contains("\\r"))||($TEXT1.text.contains("\\t"))){
						Text_length = $TEXT1.text.length() - 2 ; //要扣掉前後兩個""
						//將\n換成\0A\00等
						replacedText = $TEXT1.text.replaceAll("\\\\n", "\\\\0A\\\\00");
						replacedText = replacedText.replaceAll("\\\\r", "\\\\0D\\\\00");
						replacedText = replacedText.replaceAll("\\\\t", "\\\\09\\\\00");
					}
					else{
						Text_length = $TEXT1.text.length() - 1 ; //要扣掉前後兩個""
						//將最後面結束字串改成\00
						newstr = "\\00";
						int lastIndex = $TEXT1.text.length() - 1;
						replacedText = $TEXT1.text.substring(0, lastIndex) + newstr + $TEXT1.text.substring(lastIndex);
					}

					System.out.println("@.str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + replacedText);
					TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + Text_length + " x i8], [" + Text_length + " x i8]* @.str" + var_str_Count + ", i64 0, i64 0), i32 \%t" + $a.theInfo.theVar.varIndex + ")" );
					varCount++;
					var_str_Count++;
					
				}
		  		| TEXT2 
		  		{
					int Text_length;
					String replacedText="";
					String newstr="";
					if(($TEXT2.text.contains("\\n"))||($TEXT2.text.contains("\\r"))||($TEXT2.text.contains("\\t"))){
						Text_length = $TEXT2.text.length() - 2 ; //要扣掉前後兩個""
						//將\n換成\0A\00等
						replacedText = $TEXT2.text.replaceAll("\\\\n", "\\\\0A\\\\00");
						replacedText = replacedText.replaceAll("\\\\r", "\\\\0D\\\\00");
						replacedText = replacedText.replaceAll("\\\\t", "\\\\09\\\\00");
					}
					else{
						Text_length = $TEXT2.text.length() - 1 ; //要扣掉前後兩個""
						//將最後面結束字串改成\00
						newstr = "\\00";
						int lastIndex = $TEXT2.text.length() - 1;
						replacedText = $TEXT2.text.substring(0, lastIndex) + newstr + $TEXT2.text.substring(lastIndex);
					}

					System.out.println("@str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + replacedText);
					TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + Text_length + " x i8], [" + Text_length + " x i8]* @str" + var_str_Count + ", i64 0, i64 0))");
					varCount++;
					var_str_Count++;
					
		  		}
				| TEXT3 ',' b=arith_expression 
				{
					//先檢查type是否符合
					if($b.theInfo.theType != Type.FLOAT){
						System.out.println("Error! " + $TEXT3.getLine() + ": Type mismatch for the printf function.");
						System.exit(0);
					}
					int Text_length;
					String replacedText="";
					String newstr="";
					if(($TEXT3.text.contains("\\n"))||($TEXT3.text.contains("\\r"))||($TEXT3.text.contains("\\t"))){
						Text_length = $TEXT3.text.length() - 2 ; //要扣掉前後兩個""
						//將\n換成\0A\00等
						replacedText = $TEXT3.text.replaceAll("\\\\n", "\\\\0A\\\\00");
						replacedText = replacedText.replaceAll("\\\\r", "\\\\0D\\\\00");
						replacedText = replacedText.replaceAll("\\\\t", "\\\\09\\\\00");
					}
					else{
						Text_length = $TEXT3.text.length() - 1 ; //要扣掉前後兩個""
						//將最後面結束字串改成\00
						newstr = "\\00";
						int lastIndex = $TEXT3.text.length() - 1;
						replacedText = $TEXT3.text.substring(0, lastIndex) + newstr + $TEXT3.text.substring(lastIndex);
					}

        			System.out.println("@str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + replacedText);
					//when float need to call function, it need to converted to double
					TextCode.add("\%t" + varCount + " = fpext float \%t" + $b.theInfo.theVar.varIndex + " to double");
					int float_varCount = varCount;
					varCount++;
        			TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + Text_length + " x i8], [" + Text_length + " x i8]* @str" + var_str_Count + ", i64 0, i64 0), double \%t" + float_varCount + ")");
        			varCount++;
        			var_str_Count++;
				}
		  		;
		  
TEXT1: '"' ( '%%'| '""' | ~('"'|'%') )* '%d' ( '%%'| '""' | ~('"'|'%') )* '"';
TEXT2: '"'( '%%'| '""' | ~('"'|'%') )* '"';
TEXT3: '"' ( '%%'| '""' | ~('"'|'%') )* '%f' ( '%%'| '""' | ~('"'|'%') )* '"';


assign_stmt: Identifier '=' arith_expression     //賦值
            {
				if(symtab.containsKey($Identifier.text)){
	      		}
				else{ 											 //如果沒有宣告就給值
					System.out.println("Error! " + $Identifier.getLine() + ": Undeclared identifier.");
					System.exit(0);
				}
	      		
            	Info theRHS = $arith_expression.theInfo;
		 		Info theLHS = symtab.get($Identifier.text); 
		   
                if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.INT)) {		   
                	// issue store insruction.
                	// Ex: store i32 \%tx, i32* \%ty
                   	TextCode.add("store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex);
		 		} 
		 		else if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.CONST_INT)) {
                   	// issue store insruction.
                   	// Ex: store i32 value, i32* \%ty
                   	TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex);				
		 		}
		 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.FLOAT)) {
		    		// issue store insruction.
                   	// Ex: store float \%tx , float* \%ty
                   	TextCode.add("store float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex);	
		 		}
		 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.CONST_FLOAT)) {
		    		// Convert the floating-point constant to its hexadecimal representation
    		    	double val = theRHS.theVar.fValue;
    		    	long bits = Double.doubleToLongBits(val);
    		    	String hexValue = Long.toHexString(bits);

    		    	// Issue store instruction
    		    	TextCode.add("store float 0x" + hexValue + ", float* \%t" + theLHS.theVar.varIndex);
		 		}
				else{
					// = 兩邊的datatype不一樣或不支援
					System.out.println("Error! " + $Identifier.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
					System.exit(0);
				}
	      	}
            ;

assign_stmt_templlvmIR: Identifier '=' arith_expression     //賦值 暫存結果先不放到TextCode
            {
				if(symtab.containsKey($Identifier.text)){
	      		}
				else{ 											 //如果沒有宣告就給值
					System.out.println("Error! " + $Identifier.getLine() + ": Undeclared identifier.");
					System.exit(0);
				}
	      		
            	Info theRHS = $arith_expression.theInfo;
		 		Info theLHS = symtab.get($Identifier.text); 
		   
                if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.INT)) {		   
                	// issue store insruction.
                	// Ex: store i32 \%tx, i32* \%ty
                   	templlvmIR = "store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex;
		 		} 
		 		else if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.CONST_INT)) {
                   	// issue store insruction.
                   	// Ex: store i32 value, i32* \%ty
                   	templlvmIR = "store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex;			
		 		}
		 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.FLOAT)) {
		    		// issue store insruction.
                   	// Ex: store float \%tx , float* \%ty
                   	templlvmIR = "store float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex;
		 		}
		 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.CONST_FLOAT)) {
		    		// Convert the floating-point constant to its hexadecimal representation
    		    	double val = theRHS.theVar.fValue;
    		    	long bits = Double.doubleToLongBits(val);
    		    	String hexValue = Long.toHexString(bits);

    		    	// Issue store instruction
    		    	templlvmIR = "store float 0x" + hexValue + ", float* \%t" + theLHS.theVar.varIndex;
		 		}
				else{
					// = 兩邊的datatype不一樣或不支援
					System.out.println("Error! " + $Identifier.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
					System.exit(0);
				}
	      	}
            ;
		   
func_no_return_stmt: Identifier '(' argument ')'
                   ;

argument: arg (',' arg)*
        ;

arg: arith_expression
   | STRING_LITERAL
   ;
		   
cond_expression
returns [Info theInfo]
@init {theInfo = new Info();} 
               : a=arith_expression{ $theInfo=$a.theInfo;}
			    (RelationOP b=arith_expression
				{
					// 生成對應的LLVM IR代碼
					String llvmOP = "";
					//int
					if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "icmp slt";
								break;
							case ">":
								llvmOP = "icmp sgt";
								break;
							case ">=":
								llvmOP = "icmp sge";
								break;
							case "<=":
								llvmOP = "icmp sle";
								break;
							case "==":
								llvmOP = "icmp eq";
								break;
							case "!=":
								llvmOP = "icmp ne";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
						// 更新變量信息
          				$theInfo.theType = Type.BOOL; // 假設結果是布爾類型
          				$theInfo.theVar.varIndex = varCount;
          				varCount++;
					}
					else if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "icmp slt";
								break;
							case ">":
								llvmOP = "icmp sgt";
								break;
							case ">=":
								llvmOP = "icmp sge";
								break;
							case "<=":
								llvmOP = "icmp sle";
								break;
							case "==":
								llvmOP = "icmp eq";
								break;
							case "!=":
								llvmOP = "icmp ne";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;	
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
						// 更新變量信息
          				$theInfo.theType = Type.BOOL; // 假設結果是布爾類型
          				$theInfo.theVar.varIndex = varCount;
          				varCount++;
					}
					else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "icmp slt";
								break;
							case ">":
								llvmOP = "icmp sgt";
								break;
							case ">=":
								llvmOP = "icmp sge";
								break;
							case "<=":
								llvmOP = "icmp sle";
								break;
							case "==":
								llvmOP = "icmp eq";
								break;
							case "!=":
								llvmOP = "icmp ne";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
						// 更新變量信息
          				$theInfo.theType = Type.BOOL; // 假設結果是布爾類型
          				$theInfo.theVar.varIndex = varCount;
          				varCount++;
					}
					else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "icmp slt";
								break;
							case ">":
								llvmOP = "icmp sgt";
								break;
							case ">=":
								llvmOP = "icmp sge";
								break;
							case "<=":
								llvmOP = "icmp sle";
								break;
							case "==":
								llvmOP = "icmp eq";
								break;
							case "!=":
								llvmOP = "icmp ne";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " i32 " + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
					   
			    		// Update arith_expression's theInfo.
			    		$theInfo.theType = Type.BOOL;
			    		$theInfo.theVar.varIndex = varCount;
			    		varCount ++;
					}

					//float
					else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "fcmp olt";
								break;
							case ">":
								llvmOP = "fcmp ogt";
								break;
							case ">=":
								llvmOP = "fcmp oge";
								break;
							case "<=":
								llvmOP = "fcmp ole";
								break;
							case "==":
								llvmOP = "fcmp oeq";
								break;
							case "!=":
								llvmOP = "fcmp une";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
	   
			    		// Update arith_expression's theInfo.
			    		$theInfo.theType = Type.BOOL;
			    		$theInfo.theVar.varIndex = varCount;
			    		varCount ++;
					}
					else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "fcmp olt";
								break;
							case ">":
								llvmOP = "fcmp ogt";
								break;
							case ">=":
								llvmOP = "fcmp oge";
								break;
							case "<=":
								llvmOP = "fcmp ole";
								break;
							case "==":
								llvmOP = "fcmp oeq";
								break;
							case "!=":
								llvmOP = "fcmp une";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " float \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
	   					// Update arith_expression's theInfo.
			    		$theInfo.theType = Type.BOOL;
			    		$theInfo.theVar.varIndex = varCount;
			    		varCount ++;
					}
					else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "fcmp olt";
								break;
							case ">":
								llvmOP = "fcmp ogt";
								break;
							case ">=":
								llvmOP = "fcmp oge";
								break;
							case "<=":
								llvmOP = "fcmp ole";
								break;
							case "==":
								llvmOP = "fcmp oeq";
								break;
							case "!=":
								llvmOP = "fcmp une";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " float " + $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
	   					// Update arith_expression's theInfo.
			    		$theInfo.theType = Type.BOOL;
			    		$theInfo.theVar.varIndex = varCount;
			    		varCount ++;
					}
					else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
						switch ($RelationOP.getText()){
							case "<":
								llvmOP = "fcmp olt";
								break;
							case ">":
								llvmOP = "fcmp ogt";
								break;
							case ">=":
								llvmOP = "fcmp oge";
								break;
							case "<=":
								llvmOP = "fcmp ole";
								break;
							case "==":
								llvmOP = "fcmp oeq";
								break;
							case "!=":
								llvmOP = "fcmp une";
								break;
							default:
								$theInfo.theType = Type.ERR;
								break;
						}
						TextCode.add("\%t" + varCount + " = " + llvmOP + " float " + $a.theInfo.theVar.fValue + ", " + $b.theInfo.theVar.fValue);
	   					// Update arith_expression's theInfo.
			    		$theInfo.theType = Type.BOOL;
			    		$theInfo.theVar.varIndex = varCount;
			    		varCount ++;
					}

					//error
					else{
						System.out.println("Error! " + $RelationOP.getLine() + ": Type mismatch for the condition operator in an expression.");
						$theInfo.theType = Type.ERR;
						System.exit(0);
					}
				}	
				)*
               ;
			   
arith_expression
returns [Info theInfo]
@init {theInfo = new Info();}
                : a=multExpr { $theInfo=$a.theInfo; }
                 ( ADD b=multExpr
                    {
                    	// We need to do type checking first.
                       	// ...
					  
                       	// code generation.
                       
                       	//int					   
                    	if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
                    		TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	} 
                       	else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                    	else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                    		TextCode.add("\%t" + varCount + " = add nsw i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = add nsw i32 " + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       
                       	//float
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           	TextCode.add("\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                       
                        	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $b.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", 0x" + hexValue);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       		}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $a.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fadd float 0x" + hexValue + ", \%t" + $b.theInfo.theVar.varIndex);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val_L = $a.theInfo.theVar.fValue;
    		   	    		long bits_L = Double.doubleToLongBits(val_L);
    		   	    		String hexValue_L = Long.toHexString(bits_L);
    		   	    		double val_R = $b.theInfo.theVar.fValue;
    		   	    		long bits_R = Double.doubleToLongBits(val_R);
    		   	    		String hexValue_R = Long.toHexString(bits_R);

                           	TextCode.add("\%t" + varCount + " = fadd float 0x" + hexValue_L + ", 0x" + hexValue_R);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++; 
                       	}

						//error
						else{
							System.out.println("Error! " + $ADD.getLine() + ": Type mismatch for the operator + in an expression.");
							$theInfo.theType = Type.ERR;
							System.exit(0);
						}
                    }

                 | SUB_OR_UNARY c=multExpr
                    {
                    	// We need to do type checking first.
                       	// ...
					  
                       	// code generation.	
                       	// int				   
                       	if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.INT)) {
                           	TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	} 
                       	else if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $c.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if (($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.INT)) {
                           	TextCode.add("\%t" + varCount + " = sub nsw i32 " + $a.theInfo.theVar.iValue + ", \%t" + $c.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if (($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = sub nsw i32 " + $a.theInfo.theVar.iValue + ", " + $c.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       
                       	// float
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.FLOAT)) {
                           	TextCode.add("\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
	   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $c.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", 0x" + hexValue);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $a.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fsub float 0x" + hexValue + ", \%t" + $c.theInfo.theVar.varIndex);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val_L = $a.theInfo.theVar.fValue;
    		   	    		long bits_L = Double.doubleToLongBits(val_L);
    		   	    		String hexValue_L = Long.toHexString(bits_L);
    		   	    		double val_R = $c.theInfo.theVar.fValue;
    		   	    		long bits_R = Double.doubleToLongBits(val_R);
    		   	    		String hexValue_R = Long.toHexString(bits_R);

                           	TextCode.add("\%t" + varCount + " = fsub float 0x" + hexValue_L + ", 0x" + hexValue_R);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++; 
                       	}

						//error
						else{
							System.out.println("Error! " + $SUB_OR_UNARY.getLine() +": Type mismatch for the operator - in an expression.");
							$theInfo.theType = Type.ERR;
							System.exit(0);
						}

                    }
                 )*
                 ;

multExpr
returns [Info theInfo]
@init {theInfo = new Info();}
          	: a=signExpr { $theInfo=$a.theInfo; }
          	( MUL b=signExpr
          		{
                    	// We need to do type checking first.
                       	// ...
					  
                       	// code generation.
                       	// int	
                       		   
                       	if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
                           	TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	} 
                       	else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                           	TextCode.add("\%t" + varCount + " = mul nsw i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = mul nsw i32 " + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       
                       	// float
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           	TextCode.add("\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
	   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $b.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", 0x" + hexValue);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $a.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fmul float 0x" + hexValue + ", \%t" + $b.theInfo.theVar.varIndex);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val_L = $a.theInfo.theVar.fValue;
    		   	    		long bits_L = Double.doubleToLongBits(val_L);
    		   	    		String hexValue_L = Long.toHexString(bits_L);
    		   	    		double val_R = $b.theInfo.theVar.fValue;
    		   	    		long bits_R = Double.doubleToLongBits(val_R);
    		   	    		String hexValue_R = Long.toHexString(bits_R);

                           	TextCode.add("\%t" + varCount + " = fmul float 0x" + hexValue_L + ", 0x" + hexValue_R);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++; 
                       	}

						//error
						else{
							System.out.println("Error! " + $MUL.getLine() +": Type mismatch for the operator * in an expression.");
							$theInfo.theType = Type.ERR;
							System.exit(0);
						}
                 }
          	| DIV c=signExpr
          		{
                       	// We need to do type checking first.
                       	// ...
					  
                       	// code generation.
                       	// int					   
                       	if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.INT)) {
                           	TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	} 
                       	else if (($a.theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + $theInfo.theVar.varIndex + ", " + $c.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if (($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.INT)) {
                           	TextCode.add("\%t" + varCount + " = sdiv i32 " + $a.theInfo.theVar.iValue + ", \%t" + $c.theInfo.theVar.varIndex);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if (($a.theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.CONST_INT)) {
                           	TextCode.add("\%t" + varCount + " = sdiv i32 " + $a.theInfo.theVar.iValue + ", " + $c.theInfo.theVar.iValue);
					   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.INT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}

                       	// float
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.FLOAT)) {
                           	TextCode.add("\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);

			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $c.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", 0x" + hexValue);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val = $a.theInfo.theVar.fValue;
    		   	    		long bits = Double.doubleToLongBits(val);
    		   	    		String hexValue = Long.toHexString(bits);
    		   	    
                           	TextCode.add("\%t" + varCount + " = fdiv float 0x" + hexValue + ", \%t" + $c.theInfo.theVar.varIndex);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++;
                       	}
                       	else if(($a.theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT)) {
                       
                           	// Convert the floating-point constant to its hexadecimal representation
    		    	    	double val_L = $a.theInfo.theVar.fValue;
    		   	    		long bits_L = Double.doubleToLongBits(val_L);
    		   	    		String hexValue_L = Long.toHexString(bits_L);
    		   	    		double val_R = $c.theInfo.theVar.fValue;
    		   	    		long bits_R = Double.doubleToLongBits(val_R);
    		   	    		String hexValue_R = Long.toHexString(bits_R);

                           	TextCode.add("\%t" + varCount + " = fdiv float 0x" + hexValue_L + ", 0x" + hexValue_R);
   
			    			// Update arith_expression's theInfo.
			    			$theInfo.theType = Type.FLOAT;
			    			$theInfo.theVar.varIndex = varCount;
			    			varCount ++; 
                       	}

						//error
						else{
							System.out.println("Error! " + $DIV.getLine() +": Type mismatch for the operator / in an expression.");
							$theInfo.theType = Type.ERR;
							System.exit(0);
						}
                }
	  		)*
	  		;

signExpr
returns [Info theInfo]
@init {theInfo = new Info();}
        	: a=primaryExpr { $theInfo=$a.theInfo; } 
        	| SUB_OR_UNARY a=primaryExpr
        	   	{
        	   		if ($a.theInfo.theType == Type.INT) {
    					TextCode.add("\%t" + varCount + " = sub nsw i32 0, \%t" + $a.theInfo.theVar.varIndex);
    					// Update theInfo.
    					$theInfo.theType = Type.INT;
    					$theInfo.theVar.varIndex = varCount;
    					varCount++;
					}
					else if ($a.theInfo.theType == Type.CONST_INT) {
						TextCode.add("\%t" + varCount + " = sub nsw i32 0, " + $a.theInfo.theVar.iValue);
    					// Update theInfo.
    				
    					$theInfo.theType = Type.INT;
    					$theInfo.theVar.varIndex = varCount;
    					varCount++;
					}
					else if ($a.theInfo.theType == Type.FLOAT) {

    					TextCode.add("\%t" + varCount + " = fsub float 0x0000000000000000, \%t" + $a.theInfo.theVar.varIndex);
    					// Update theInfo.
    					$theInfo.theType = Type.FLOAT;
    					$theInfo.theVar.varIndex = varCount;
    					varCount++;
					}
					else if ($a.theInfo.theType == Type.CONST_FLOAT) {

						
						// Convert the floating-point constant to its hexadecimal representation
    		    	    double val = $a.theInfo.theVar.fValue;
    		   	    	long bits = Double.doubleToLongBits(val);
    		   	    	String hexValue = Long.toHexString(bits);

						TextCode.add("\%t" + varCount + " = fsub float 0x0000000000000000, 0x" + hexValue);
    					// Update theInfo.
    				
    					$theInfo.theType = Type.FLOAT;
    					$theInfo.theVar.varIndex = varCount;
    					varCount++;
					}
					else{
						System.out.println("Error! " + $SUB_OR_UNARY.getLine() +": Type mismatch for the unary operator - in an expression.");
						$theInfo.theType = Type.ERR;
						System.exit(0);
					}
					
        	   	}
			;
		  
primaryExpr
returns [Info theInfo]
@init {theInfo = new Info();}
           : Integer_constant
	    	{
            	$theInfo.theType = Type.CONST_INT;
				$theInfo.theVar.iValue = Integer.parseInt($Integer_constant.text);
            }
           	| Floating_point_constant
           	{
           		$theInfo.theType = Type.CONST_FLOAT;
				$theInfo.theVar.fValue = Float.parseFloat($Floating_point_constant.text);
			}
           	| Identifier
            {
                // get type information from symtab.
                Type the_type = symtab.get($Identifier.text).theType;
				$theInfo.theType = the_type;

                // get variable index from symtab.
                int vIndex = symtab.get($Identifier.text).theVar.varIndex;
				
                switch (the_type) {
                	case INT: 
                        // get a new temporary variable and
						// load the variable into the temporary variable.
                         
						// Ex: \%tx = load i32, i32* \%ty.
						TextCode.add("\%t" + varCount + " = load i32, i32* \%t" + vIndex);
				         
						// Now, Identifier's value is at the temporary variable \%t[varCount].
						// Therefore, update it.
						$theInfo.theVar.varIndex = varCount;
						varCount ++;
                        break;
                	case FLOAT:
                		// get a new temporary variable and load the variable into the temporary variable.
    					// Ex: \%tx = load float, float* \%ty.
    					TextCode.add("\%t" + varCount + " = load float, float* \%t" + vIndex);

    					// Now, Identifier's value is at the temporary variable \%t[varCount].
    					// Therefore, update it.
    					
    					$theInfo.theVar.varIndex = varCount;
    					varCount++;
                        break;
                	case CHAR:
                		// get a new temporary variable and load the variable into the temporary variable.
    					// Ex: \%tx = load i8, i8* \%ty.
    					TextCode.add("\%t" + varCount + " = load i8, i8* \%t" + vIndex);

    					// Now, Identifier's value is at the temporary variable \%t[varCount].
    					// Therefore, update it.
    					$theInfo.theVar.varIndex = varCount;
    					varCount++;
                        break;
					default:
						System.out.println("Error! " + $Identifier.getLine() + " :　This datatype is not supported or wrong");
						$theInfo.theType = Type.ERR;
						System.exit(0);
						
			
                }
            }
	      	| '&' Identifier   
	      	| '(' arith_expression ')'
	      	{
    			// 直接传递子表达式的 $theInfo 值给父表达式的 $theInfo
       			$theInfo=$arith_expression.theInfo;
	       	}
            ;

		   
/* description of the tokens */
FLOAT:'float';
INT:'int';
CHAR: 'char';
ADD: '+';
SUB_OR_UNARY: '-';
MUL: '*';
DIV: '/';
PRINTF: 'printf';
WHILE: 'while';


MAIN: 'main';
VOID: 'void';
IF: 'if';
ELSE: 'else';
FOR: 'for';

RelationOP: '>' |'>=' | '<' | '<=' | '==' | '!=';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};

//PRINTF_PARAMETER: ('%d'|'%f'|'%c'|'%s');
COMMENT:'/*' .* '*/' {$channel=HIDDEN;}
	| '//'(.)*'\n'
	;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;
    
