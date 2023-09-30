all:
	java -cp antlr-3.5.3-complete-no-st3.jar org.antlr.Tool myCompiler.g
	javac -cp antlr-3.5.3-complete-no-st3.jar:. *java
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test1.c > test1.ll
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test2.c > test2.ll
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test3.c > test3.ll
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test4.c > test4.ll
	llc test1.ll
	llc test2.ll
	llc test3.ll
	llc test4.ll
	gcc -no-pie test1.s -o test1.out
	gcc -no-pie test2.s -o test2.out
	gcc -no-pie test3.s -o test3.out
	gcc -no-pie test4.s -o test4.out

myCompiler:
	java -cp antlr-3.5.3-complete-no-st3.jar org.antlr.Tool myCompiler.g
	javac -cp antlr-3.5.3-complete-no-st3.jar:. *java
test1:
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test1.c > test1.ll
test2:
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test2.c > test2.ll
test3:
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test3.c > test3.ll
test4:
	java -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test4.c > test4.ll
gen_s:
	llc test1.ll
	llc test2.ll
	llc test3.ll
	llc test4.ll
gen_out:
	gcc -no-pie test1.s -o test1.out
	gcc -no-pie test2.s -o test2.out
	gcc -no-pie test3.s -o test3.out
	gcc -no-pie test4.s -o test4.out
clean:
	rm -rf *.class *.ll *.s *.out myCompiler.tokens myCompilerParser.java myCompilerLexer.java
