// $ANTLR 3.5.3 myCompiler.g 2023-05-30 23:40:53

    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCompilerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "CHAR", "COMMENT", "DIV", 
		"ELSE", "EscapeSequence", "FLOAT", "FOR", "Floating_point_constant", "IF", 
		"INT", "Identifier", "Integer_constant", "MAIN", "MUL", "PRINTF", "RelationOP", 
		"STRING_LITERAL", "SUB_OR_UNARY", "TEXT1", "TEXT2", "TEXT3", "VOID", "WHILE", 
		"WS", "'&'", "'('", "')'", "','", "';'", "'='", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int ADD=4;
	public static final int CHAR=5;
	public static final int COMMENT=6;
	public static final int DIV=7;
	public static final int ELSE=8;
	public static final int EscapeSequence=9;
	public static final int FLOAT=10;
	public static final int FOR=11;
	public static final int Floating_point_constant=12;
	public static final int IF=13;
	public static final int INT=14;
	public static final int Identifier=15;
	public static final int Integer_constant=16;
	public static final int MAIN=17;
	public static final int MUL=18;
	public static final int PRINTF=19;
	public static final int RelationOP=20;
	public static final int STRING_LITERAL=21;
	public static final int SUB_OR_UNARY=22;
	public static final int TEXT1=23;
	public static final int TEXT2=24;
	public static final int TEXT3=25;
	public static final int VOID=26;
	public static final int WHILE=27;
	public static final int WS=28;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myCompilerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myCompilerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myCompiler.g"; }


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



	// $ANTLR start "program"
	// myCompiler.g:123:1: program : VOID MAIN '(' ')' '{' declarations statements '}' ;
	public final void program() throws RecognitionException {
		try {
			// myCompiler.g:123:8: ( VOID MAIN '(' ')' '{' declarations statements '}' )
			// myCompiler.g:123:10: VOID MAIN '(' ')' '{' declarations statements '}'
			{
			match(input,VOID,FOLLOW_VOID_in_program36); 
			match(input,MAIN,FOLLOW_MAIN_in_program38); 
			match(input,30,FOLLOW_30_in_program40); 
			match(input,31,FOLLOW_31_in_program42); 

			           /* Output function prologue */
			           prologue();
			        
			match(input,35,FOLLOW_35_in_program63); 
			pushFollow(FOLLOW_declarations_in_program77);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_statements_in_program90);
			statements();
			state._fsp--;

			match(input,36,FOLLOW_36_in_program100); 

				   	if (TRACEON)
				      	System.out.println("VOID MAIN () {declarations statements}");

			           	/* output function epilogue */	  
			           	epilogue();
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "declarations"
	// myCompiler.g:143:1: declarations : ( type Identifier ';' declarations |);
	public final void declarations() throws RecognitionException {
		Token Identifier1=null;
		Type type2 =null;

		try {
			// myCompiler.g:143:13: ( type Identifier ';' declarations |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==CHAR||LA1_0==FLOAT||LA1_0==INT) ) {
				alt1=1;
			}
			else if ( (LA1_0==COMMENT||LA1_0==FOR||LA1_0==IF||LA1_0==Identifier||LA1_0==PRINTF||LA1_0==WHILE||LA1_0==36) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// myCompiler.g:143:15: type Identifier ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations127);
					type2=type();
					state._fsp--;

					Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_declarations129); 
					match(input,33,FOLLOW_33_in_declarations131); 
					pushFollow(FOLLOW_declarations_in_declarations133);
					declarations();
					state._fsp--;


					        	if (TRACEON)
					            	System.out.println("declarations: type Identifier : declarations");

					           	if (symtab.containsKey((Identifier1!=null?Identifier1.getText():null))) {
					              	// variable re-declared.重複宣告
					              	System.out.println("Error! " + Identifier1.getLine() + " : Redeclared identifier.");
					              	System.exit(0);
					           	}
					                 
					           	/* Add ID and its info into the symbol table. */
						   	   	Info the_entry = new Info();
					           	the_entry.theType = type2;
					           	the_entry.theVar.varIndex = varCount;
						       	varCount ++;
						       	symtab.put((Identifier1!=null?Identifier1.getText():null), the_entry);

					           	// issue the instruction.
						   		// Ex: %a = alloca i32, align 4
					           	if (type2 == Type.INT) { 
					              	TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
					           	}
					           	else if (type2 == Type.FLOAT) {
					    	      	TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
						   		}
						   		else if (type2 == Type.CHAR) {
					    	     	TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca i8, align 1");
						   		}
								else{
									//宣告了不存在的datatype或未支援
									System.out.println ("Error!" + Identifier1.getLine() + " : This datatype is not supported or wrong");
									System.exit(0);
								}
					        
					}
					break;
				case 2 :
					// myCompiler.g:179:9: 
					{

					           	if (TRACEON)
					              	System.out.println("declarations: ");
					        
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "type"
	// myCompiler.g:186:1: type returns [Type attr_type] : ( INT | CHAR | FLOAT );
	public final Type type() throws RecognitionException {
		Type attr_type = null;


		try {
			// myCompiler.g:188:5: ( INT | CHAR | FLOAT )
			int alt2=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt2=1;
				}
				break;
			case CHAR:
				{
				alt2=2;
				}
				break;
			case FLOAT:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// myCompiler.g:188:7: INT
					{
					match(input,INT,FOLLOW_INT_in_type194); 
					 if (TRACEON) System.out.println("type: INT"); attr_type =Type.INT; 
					}
					break;
				case 2 :
					// myCompiler.g:189:7: CHAR
					{
					match(input,CHAR,FOLLOW_CHAR_in_type204); 
					 if (TRACEON) System.out.println("type: CHAR"); attr_type =Type.CHAR; 
					}
					break;
				case 3 :
					// myCompiler.g:190:7: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_type214); 
					 if (TRACEON) System.out.println("type: FLOAT"); attr_type =Type.FLOAT; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myCompiler.g:194:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myCompiler.g:194:11: ( statement statements |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==COMMENT||LA3_0==FOR||LA3_0==IF||LA3_0==Identifier||LA3_0==PRINTF||LA3_0==WHILE) ) {
				alt3=1;
			}
			else if ( (LA3_0==36) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// myCompiler.g:194:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements225);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements227);
					statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:196:11: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// myCompiler.g:199:1: statement : ( assign_stmt ';' | if_stmt | func_no_return_stmt ';' | for_stmt | while_stmt | PRINTF '(' printf_expression ')' ';' | COMMENT );
	public final void statement() throws RecognitionException {
		try {
			// myCompiler.g:199:10: ( assign_stmt ';' | if_stmt | func_no_return_stmt ';' | for_stmt | while_stmt | PRINTF '(' printf_expression ')' ';' | COMMENT )
			int alt4=7;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				int LA4_1 = input.LA(2);
				if ( (LA4_1==34) ) {
					alt4=1;
				}
				else if ( (LA4_1==30) ) {
					alt4=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IF:
				{
				alt4=2;
				}
				break;
			case FOR:
				{
				alt4=4;
				}
				break;
			case WHILE:
				{
				alt4=5;
				}
				break;
			case PRINTF:
				{
				alt4=6;
				}
				break;
			case COMMENT:
				{
				alt4=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// myCompiler.g:199:12: assign_stmt ';'
					{
					pushFollow(FOLLOW_assign_stmt_in_statement258);
					assign_stmt();
					state._fsp--;

					match(input,33,FOLLOW_33_in_statement260); 
					}
					break;
				case 2 :
					// myCompiler.g:200:12: if_stmt
					{
					pushFollow(FOLLOW_if_stmt_in_statement273);
					if_stmt();
					state._fsp--;

					}
					break;
				case 3 :
					// myCompiler.g:201:12: func_no_return_stmt ';'
					{
					pushFollow(FOLLOW_func_no_return_stmt_in_statement286);
					func_no_return_stmt();
					state._fsp--;

					match(input,33,FOLLOW_33_in_statement288); 
					}
					break;
				case 4 :
					// myCompiler.g:202:12: for_stmt
					{
					pushFollow(FOLLOW_for_stmt_in_statement301);
					for_stmt();
					state._fsp--;

					}
					break;
				case 5 :
					// myCompiler.g:203:6: while_stmt
					{
					pushFollow(FOLLOW_while_stmt_in_statement308);
					while_stmt();
					state._fsp--;

					}
					break;
				case 6 :
					// myCompiler.g:204:6: PRINTF '(' printf_expression ')' ';'
					{
					match(input,PRINTF,FOLLOW_PRINTF_in_statement315); 
					match(input,30,FOLLOW_30_in_statement317); 
					pushFollow(FOLLOW_printf_expression_in_statement319);
					printf_expression();
					state._fsp--;

					match(input,31,FOLLOW_31_in_statement321); 
					match(input,33,FOLLOW_33_in_statement323); 
					}
					break;
				case 7 :
					// myCompiler.g:205:6: COMMENT
					{
					match(input,COMMENT,FOLLOW_COMMENT_in_statement331); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "for_stmt"
	// myCompiler.g:208:1: for_stmt : FOR '(' a= assign_stmt ';' cond_expression ';' b= assign_stmt_templlvmIR ')' for_block_stmt ;
	public final void for_stmt() throws RecognitionException {
		Token FOR4=null;
		Info cond_expression3 =null;

		try {
			// myCompiler.g:208:9: ( FOR '(' a= assign_stmt ';' cond_expression ';' b= assign_stmt_templlvmIR ')' for_block_stmt )
			// myCompiler.g:208:11: FOR '(' a= assign_stmt ';' cond_expression ';' b= assign_stmt_templlvmIR ')' for_block_stmt
			{
			FOR4=(Token)match(input,FOR,FOLLOW_FOR_in_for_stmt348); 
			match(input,30,FOLLOW_30_in_for_stmt352); 
			pushFollow(FOLLOW_assign_stmt_in_for_stmt361);
			assign_stmt();
			state._fsp--;

			match(input,33,FOLLOW_33_in_for_stmt363); 

									loop = newLabel();
									loop_body = newLabel();
									loop_end = newLabel();
									TextCode.add("br label %" + loop);
									TextCode.add(loop + ":");
								
			pushFollow(FOLLOW_cond_expression_in_for_stmt388);
			cond_expression3=cond_expression();
			state._fsp--;

			match(input,33,FOLLOW_33_in_for_stmt390); 

									if(cond_expression3.theType != Type.BOOL){
										System.out.println("Error! " + FOR4.getLine() + ": The type of condition is not BOOL.");
										System.exit(0);
									}
									// 評估條件運算式
			      					TextCode.add("br i1 %t" + cond_expression3.theVar.varIndex + ", label %" + loop_body + ", label %" + loop_end);
									TextCode.add(loop_body + ":");
								
			pushFollow(FOLLOW_assign_stmt_templlvmIR_in_for_stmt417);
			assign_stmt_templlvmIR();
			state._fsp--;

			match(input,31,FOLLOW_31_in_for_stmt434); 
			pushFollow(FOLLOW_for_block_stmt_in_for_stmt452);
			for_block_stmt();
			state._fsp--;


									TextCode.add(templlvmIR);     //做完for_block_stmt後把剛剛暫存的llvmIR放進來
									TextCode.add("br label %" + loop);
									TextCode.add(loop_end + ":");
								
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "for_stmt"



	// $ANTLR start "for_block_stmt"
	// myCompiler.g:237:1: for_block_stmt : '{' statements '}' ;
	public final void for_block_stmt() throws RecognitionException {
		try {
			// myCompiler.g:237:15: ( '{' statements '}' )
			// myCompiler.g:238:4: '{' statements '}'
			{
			match(input,35,FOLLOW_35_in_for_block_stmt480); 
			pushFollow(FOLLOW_statements_in_for_block_stmt482);
			statements();
			state._fsp--;

			match(input,36,FOLLOW_36_in_for_block_stmt484); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "for_block_stmt"



	// $ANTLR start "while_stmt"
	// myCompiler.g:241:1: while_stmt : WHILE '(' cond_expression ')' while_block_stmt ;
	public final void while_stmt() throws RecognitionException {
		Token WHILE6=null;
		Info cond_expression5 =null;

		try {
			// myCompiler.g:241:11: ( WHILE '(' cond_expression ')' while_block_stmt )
			// myCompiler.g:241:13: WHILE '(' cond_expression ')' while_block_stmt
			{
			WHILE6=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_stmt495); 
			match(input,30,FOLLOW_30_in_while_stmt497); 

				 				loop = newLabel();
								loop_body = newLabel();
								loop_end = newLabel();
								TextCode.add("br label %" + loop);
								TextCode.add(loop + ":");
				 			
			pushFollow(FOLLOW_cond_expression_in_while_stmt509);
			cond_expression5=cond_expression();
			state._fsp--;


								if(cond_expression5.theType != Type.BOOL){
									System.out.println("Error! " + WHILE6.getLine() + ": The type of condition is not BOOL.");
									System.exit(0);
								}
								TextCode.add("br i1 %t" + cond_expression5.theVar.varIndex + ", label %" + loop_body + ", label %" + loop_end);
								TextCode.add(loop_body + ":");
							
			match(input,31,FOLLOW_31_in_while_stmt521); 
			pushFollow(FOLLOW_while_block_stmt_in_while_stmt523);
			while_block_stmt();
			state._fsp--;


								TextCode.add("br label %" + loop);
								TextCode.add(loop_end + ":");

				 			
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_stmt"



	// $ANTLR start "while_block_stmt"
	// myCompiler.g:266:1: while_block_stmt : '{' statements '}' ;
	public final void while_block_stmt() throws RecognitionException {
		try {
			// myCompiler.g:266:17: ( '{' statements '}' )
			// myCompiler.g:267:5: '{' statements '}'
			{
			match(input,35,FOLLOW_35_in_while_block_stmt545); 
			pushFollow(FOLLOW_statements_in_while_block_stmt547);
			statements();
			state._fsp--;

			match(input,36,FOLLOW_36_in_while_block_stmt549); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_block_stmt"



	// $ANTLR start "if_stmt"
	// myCompiler.g:270:1: if_stmt : IF '(' a= cond_expression ')' if_block_stmt ( ELSE else_block_stmt )? ;
	public final void if_stmt() throws RecognitionException {
		Token IF7=null;
		Info a =null;

		try {
			// myCompiler.g:271:13: ( IF '(' a= cond_expression ')' if_block_stmt ( ELSE else_block_stmt )? )
			// myCompiler.g:271:15: IF '(' a= cond_expression ')' if_block_stmt ( ELSE else_block_stmt )?
			{
			IF7=(Token)match(input,IF,FOLLOW_IF_in_if_stmt574); 
			match(input,30,FOLLOW_30_in_if_stmt576); 
			pushFollow(FOLLOW_cond_expression_in_if_stmt580);
			a=cond_expression();
			state._fsp--;

			match(input,31,FOLLOW_31_in_if_stmt582); 

							//檢查condition是不是BOOL
							if(a.theType != Type.BOOL){
								System.out.println("Error! " + IF7.getLine() + ": The type of condition is not BOOL.");
								System.exit(0);
							}
							// 產生 if-else 陳述式的 LLVM IR 程式碼
			      			ifLabel = newLabel();
			      			thenLabel = newLabel();
							

							// 評估條件運算式
			      			TextCode.add("br i1 %t" + a.theVar.varIndex + ", label %" + ifLabel + ", label %" + thenLabel);
					
							// 產生 "if" 區塊
			      			TextCode.add(ifLabel + ":");
						
			pushFollow(FOLLOW_if_block_stmt_in_if_stmt593);
			if_block_stmt();
			state._fsp--;

			// myCompiler.g:290:4: ( ELSE else_block_stmt )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ELSE) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// myCompiler.g:290:5: ELSE else_block_stmt
					{
					match(input,ELSE,FOLLOW_ELSE_in_if_stmt599); 
					pushFollow(FOLLOW_else_block_stmt_in_if_stmt601);
					else_block_stmt();
					state._fsp--;

					}
					break;

			}


							// 產生結束標籤
							if(is_else==0){    //如果沒有else
								TextCode.add("br label %" + thenLabel);
								TextCode.add(thenLabel + ":");
							}

							//is_else歸零
							is_else = 0;
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_stmt"



	// $ANTLR start "if_block_stmt"
	// myCompiler.g:303:1: if_block_stmt : '{' statements '}' ;
	public final void if_block_stmt() throws RecognitionException {
		try {
			// myCompiler.g:304:3: ( '{' statements '}' )
			// myCompiler.g:304:5: '{' statements '}'
			{
			match(input,35,FOLLOW_35_in_if_block_stmt628); 
			pushFollow(FOLLOW_statements_in_if_block_stmt630);
			statements();
			state._fsp--;

			match(input,36,FOLLOW_36_in_if_block_stmt632); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_block_stmt"



	// $ANTLR start "else_block_stmt"
	// myCompiler.g:306:1: else_block_stmt : '{' statements '}' ;
	public final void else_block_stmt() throws RecognitionException {
		try {
			// myCompiler.g:307:3: ( '{' statements '}' )
			// myCompiler.g:307:6: '{' statements '}'
			{
			match(input,35,FOLLOW_35_in_else_block_stmt647); 

								elseLabel = newLabel();
								TextCode.add("br label %" + elseLabel);
								TextCode.add(thenLabel + ":");

						  	
			pushFollow(FOLLOW_statements_in_else_block_stmt660);
			statements();
			state._fsp--;

			match(input,36,FOLLOW_36_in_else_block_stmt662); 

						TextCode.add("br label %" + elseLabel);
						TextCode.add(elseLabel + ":");
						is_else = 1;

					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "else_block_stmt"



	// $ANTLR start "printf_expression"
	// myCompiler.g:323:1: printf_expression : ( TEXT1 ',' a= arith_expression | TEXT2 | TEXT3 ',' b= arith_expression );
	public final void printf_expression() throws RecognitionException {
		Token TEXT18=null;
		Token TEXT29=null;
		Token TEXT310=null;
		Info a =null;
		Info b =null;

		try {
			// myCompiler.g:323:18: ( TEXT1 ',' a= arith_expression | TEXT2 | TEXT3 ',' b= arith_expression )
			int alt6=3;
			switch ( input.LA(1) ) {
			case TEXT1:
				{
				alt6=1;
				}
				break;
			case TEXT2:
				{
				alt6=2;
				}
				break;
			case TEXT3:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// myCompiler.g:323:20: TEXT1 ',' a= arith_expression
					{
					TEXT18=(Token)match(input,TEXT1,FOLLOW_TEXT1_in_printf_expression676); 
					match(input,32,FOLLOW_32_in_printf_expression678); 
					pushFollow(FOLLOW_arith_expression_in_printf_expression682);
					a=arith_expression();
					state._fsp--;


										//先檢查type是否符合
										if(a.theType != Type.INT){
											System.out.println("Error! " + TEXT18.getLine() + ": Type mismatch for the printf function.");
											System.exit(0);
										}

										int Text_length;
										String replacedText="";
										String newstr="";
										if(((TEXT18!=null?TEXT18.getText():null).contains("\\n"))||((TEXT18!=null?TEXT18.getText():null).contains("\\r"))||((TEXT18!=null?TEXT18.getText():null).contains("\\t"))){
											Text_length = (TEXT18!=null?TEXT18.getText():null).length() - 2 ; //要扣掉前後兩個""
											//將\n換成\0A\00等
											replacedText = (TEXT18!=null?TEXT18.getText():null).replaceAll("\\\\n", "\\\\0A\\\\00");
											replacedText = replacedText.replaceAll("\\\\r", "\\\\0D\\\\00");
											replacedText = replacedText.replaceAll("\\\\t", "\\\\09\\\\00");
										}
										else{
											Text_length = (TEXT18!=null?TEXT18.getText():null).length() - 1 ; //要扣掉前後兩個""
											//將最後面結束字串改成\00
											newstr = "\\00";
											int lastIndex = (TEXT18!=null?TEXT18.getText():null).length() - 1;
											replacedText = (TEXT18!=null?TEXT18.getText():null).substring(0, lastIndex) + newstr + (TEXT18!=null?TEXT18.getText():null).substring(lastIndex);
										}

										System.out.println("@.str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + replacedText);
										TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + Text_length + " x i8], [" + Text_length + " x i8]* @.str" + var_str_Count + ", i64 0, i64 0), i32 %t" + a.theVar.varIndex + ")" );
										varCount++;
										var_str_Count++;
										
									
					}
					break;
				case 2 :
					// myCompiler.g:355:9: TEXT2
					{
					TEXT29=(Token)match(input,TEXT2,FOLLOW_TEXT2_in_printf_expression699); 

										int Text_length;
										String replacedText="";
										String newstr="";
										if(((TEXT29!=null?TEXT29.getText():null).contains("\\n"))||((TEXT29!=null?TEXT29.getText():null).contains("\\r"))||((TEXT29!=null?TEXT29.getText():null).contains("\\t"))){
											Text_length = (TEXT29!=null?TEXT29.getText():null).length() - 2 ; //要扣掉前後兩個""
											//將\n換成\0A\00等
											replacedText = (TEXT29!=null?TEXT29.getText():null).replaceAll("\\\\n", "\\\\0A\\\\00");
											replacedText = replacedText.replaceAll("\\\\r", "\\\\0D\\\\00");
											replacedText = replacedText.replaceAll("\\\\t", "\\\\09\\\\00");
										}
										else{
											Text_length = (TEXT29!=null?TEXT29.getText():null).length() - 1 ; //要扣掉前後兩個""
											//將最後面結束字串改成\00
											newstr = "\\00";
											int lastIndex = (TEXT29!=null?TEXT29.getText():null).length() - 1;
											replacedText = (TEXT29!=null?TEXT29.getText():null).substring(0, lastIndex) + newstr + (TEXT29!=null?TEXT29.getText():null).substring(lastIndex);
										}

										System.out.println("@str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + replacedText);
										TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + Text_length + " x i8], [" + Text_length + " x i8]* @str" + var_str_Count + ", i64 0, i64 0))");
										varCount++;
										var_str_Count++;
										
							  		
					}
					break;
				case 3 :
					// myCompiler.g:381:7: TEXT3 ',' b= arith_expression
					{
					TEXT310=(Token)match(input,TEXT3,FOLLOW_TEXT3_in_printf_expression716); 
					match(input,32,FOLLOW_32_in_printf_expression718); 
					pushFollow(FOLLOW_arith_expression_in_printf_expression722);
					b=arith_expression();
					state._fsp--;


										//先檢查type是否符合
										if(b.theType != Type.FLOAT){
											System.out.println("Error! " + TEXT310.getLine() + ": Type mismatch for the printf function.");
											System.exit(0);
										}
										int Text_length;
										String replacedText="";
										String newstr="";
										if(((TEXT310!=null?TEXT310.getText():null).contains("\\n"))||((TEXT310!=null?TEXT310.getText():null).contains("\\r"))||((TEXT310!=null?TEXT310.getText():null).contains("\\t"))){
											Text_length = (TEXT310!=null?TEXT310.getText():null).length() - 2 ; //要扣掉前後兩個""
											//將\n換成\0A\00等
											replacedText = (TEXT310!=null?TEXT310.getText():null).replaceAll("\\\\n", "\\\\0A\\\\00");
											replacedText = replacedText.replaceAll("\\\\r", "\\\\0D\\\\00");
											replacedText = replacedText.replaceAll("\\\\t", "\\\\09\\\\00");
										}
										else{
											Text_length = (TEXT310!=null?TEXT310.getText():null).length() - 1 ; //要扣掉前後兩個""
											//將最後面結束字串改成\00
											newstr = "\\00";
											int lastIndex = (TEXT310!=null?TEXT310.getText():null).length() - 1;
											replacedText = (TEXT310!=null?TEXT310.getText():null).substring(0, lastIndex) + newstr + (TEXT310!=null?TEXT310.getText():null).substring(lastIndex);
										}

					        			System.out.println("@str" + var_str_Count + " = private unnamed_addr constant [" + Text_length + " x i8] c" + replacedText);
										//when float need to call function, it need to converted to double
										TextCode.add("%t" + varCount + " = fpext float %t" + b.theVar.varIndex + " to double");
										int float_varCount = varCount;
										varCount++;
					        			TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + Text_length + " x i8], [" + Text_length + " x i8]* @str" + var_str_Count + ", i64 0, i64 0), double %t" + float_varCount + ")");
					        			varCount++;
					        			var_str_Count++;
									
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "printf_expression"



	// $ANTLR start "assign_stmt"
	// myCompiler.g:422:1: assign_stmt : Identifier '=' arith_expression ;
	public final void assign_stmt() throws RecognitionException {
		Token Identifier11=null;
		Info arith_expression12 =null;

		try {
			// myCompiler.g:422:12: ( Identifier '=' arith_expression )
			// myCompiler.g:422:14: Identifier '=' arith_expression
			{
			Identifier11=(Token)match(input,Identifier,FOLLOW_Identifier_in_assign_stmt871); 
			match(input,34,FOLLOW_34_in_assign_stmt873); 
			pushFollow(FOLLOW_arith_expression_in_assign_stmt875);
			arith_expression12=arith_expression();
			state._fsp--;


							if(symtab.containsKey((Identifier11!=null?Identifier11.getText():null))){
				      		}
							else{ 											 //如果沒有宣告就給值
								System.out.println("Error! " + Identifier11.getLine() + ": Undeclared identifier.");
								System.exit(0);
							}
				      		
			            	Info theRHS = arith_expression12;
					 		Info theLHS = symtab.get((Identifier11!=null?Identifier11.getText():null)); 
					   
			                if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.INT)) {		   
			                	// issue store insruction.
			                	// Ex: store i32 %tx, i32* %ty
			                   	TextCode.add("store i32 %t" + theRHS.theVar.varIndex + ", i32* %t" + theLHS.theVar.varIndex);
					 		} 
					 		else if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.CONST_INT)) {
			                   	// issue store insruction.
			                   	// Ex: store i32 value, i32* %ty
			                   	TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* %t" + theLHS.theVar.varIndex);				
					 		}
					 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.FLOAT)) {
					    		// issue store insruction.
			                   	// Ex: store float %tx , float* %ty
			                   	TextCode.add("store float %t" + theRHS.theVar.varIndex + ", float* %t" + theLHS.theVar.varIndex);	
					 		}
					 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.CONST_FLOAT)) {
					    		// Convert the floating-point constant to its hexadecimal representation
			    		    	double val = theRHS.theVar.fValue;
			    		    	long bits = Double.doubleToLongBits(val);
			    		    	String hexValue = Long.toHexString(bits);

			    		    	// Issue store instruction
			    		    	TextCode.add("store float 0x" + hexValue + ", float* %t" + theLHS.theVar.varIndex);
					 		}
							else{
								// = 兩邊的datatype不一樣或不支援
								System.out.println("Error! " + Identifier11.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
								System.exit(0);
							}
				      	
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assign_stmt"



	// $ANTLR start "assign_stmt_templlvmIR"
	// myCompiler.g:466:1: assign_stmt_templlvmIR : Identifier '=' arith_expression ;
	public final void assign_stmt_templlvmIR() throws RecognitionException {
		Token Identifier13=null;
		Info arith_expression14 =null;

		try {
			// myCompiler.g:466:23: ( Identifier '=' arith_expression )
			// myCompiler.g:466:25: Identifier '=' arith_expression
			{
			Identifier13=(Token)match(input,Identifier,FOLLOW_Identifier_in_assign_stmt_templlvmIR914); 
			match(input,34,FOLLOW_34_in_assign_stmt_templlvmIR916); 
			pushFollow(FOLLOW_arith_expression_in_assign_stmt_templlvmIR918);
			arith_expression14=arith_expression();
			state._fsp--;


							if(symtab.containsKey((Identifier13!=null?Identifier13.getText():null))){
				      		}
							else{ 											 //如果沒有宣告就給值
								System.out.println("Error! " + Identifier13.getLine() + ": Undeclared identifier.");
								System.exit(0);
							}
				      		
			            	Info theRHS = arith_expression14;
					 		Info theLHS = symtab.get((Identifier13!=null?Identifier13.getText():null)); 
					   
			                if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.INT)) {		   
			                	// issue store insruction.
			                	// Ex: store i32 %tx, i32* %ty
			                   	templlvmIR = "store i32 %t" + theRHS.theVar.varIndex + ", i32* %t" + theLHS.theVar.varIndex;
					 		} 
					 		else if ((theLHS.theType == Type.INT) && (theRHS.theType == Type.CONST_INT)) {
			                   	// issue store insruction.
			                   	// Ex: store i32 value, i32* %ty
			                   	templlvmIR = "store i32 " + theRHS.theVar.iValue + ", i32* %t" + theLHS.theVar.varIndex;			
					 		}
					 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.FLOAT)) {
					    		// issue store insruction.
			                   	// Ex: store float %tx , float* %ty
			                   	templlvmIR = "store float %t" + theRHS.theVar.varIndex + ", float* %t" + theLHS.theVar.varIndex;
					 		}
					 		else if((theLHS.theType == Type.FLOAT) && (theRHS.theType == Type.CONST_FLOAT)) {
					    		// Convert the floating-point constant to its hexadecimal representation
			    		    	double val = theRHS.theVar.fValue;
			    		    	long bits = Double.doubleToLongBits(val);
			    		    	String hexValue = Long.toHexString(bits);

			    		    	// Issue store instruction
			    		    	templlvmIR = "store float 0x" + hexValue + ", float* %t" + theLHS.theVar.varIndex;
					 		}
							else{
								// = 兩邊的datatype不一樣或不支援
								System.out.println("Error! " + Identifier13.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
								System.exit(0);
							}
				      	
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assign_stmt_templlvmIR"



	// $ANTLR start "func_no_return_stmt"
	// myCompiler.g:510:1: func_no_return_stmt : Identifier '(' argument ')' ;
	public final void func_no_return_stmt() throws RecognitionException {
		try {
			// myCompiler.g:510:20: ( Identifier '(' argument ')' )
			// myCompiler.g:510:22: Identifier '(' argument ')'
			{
			match(input,Identifier,FOLLOW_Identifier_in_func_no_return_stmt962); 
			match(input,30,FOLLOW_30_in_func_no_return_stmt964); 
			pushFollow(FOLLOW_argument_in_func_no_return_stmt966);
			argument();
			state._fsp--;

			match(input,31,FOLLOW_31_in_func_no_return_stmt968); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "func_no_return_stmt"



	// $ANTLR start "argument"
	// myCompiler.g:513:1: argument : arg ( ',' arg )* ;
	public final void argument() throws RecognitionException {
		try {
			// myCompiler.g:513:9: ( arg ( ',' arg )* )
			// myCompiler.g:513:11: arg ( ',' arg )*
			{
			pushFollow(FOLLOW_arg_in_argument995);
			arg();
			state._fsp--;

			// myCompiler.g:513:15: ( ',' arg )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==32) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// myCompiler.g:513:16: ',' arg
					{
					match(input,32,FOLLOW_32_in_argument998); 
					pushFollow(FOLLOW_arg_in_argument1000);
					arg();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "argument"



	// $ANTLR start "arg"
	// myCompiler.g:516:1: arg : ( arith_expression | STRING_LITERAL );
	public final void arg() throws RecognitionException {
		try {
			// myCompiler.g:516:4: ( arith_expression | STRING_LITERAL )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Floating_point_constant||(LA8_0 >= Identifier && LA8_0 <= Integer_constant)||LA8_0==SUB_OR_UNARY||(LA8_0 >= 29 && LA8_0 <= 30)) ) {
				alt8=1;
			}
			else if ( (LA8_0==STRING_LITERAL) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// myCompiler.g:516:6: arith_expression
					{
					pushFollow(FOLLOW_arith_expression_in_arg1018);
					arith_expression();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:517:6: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_arg1025); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arg"



	// $ANTLR start "cond_expression"
	// myCompiler.g:520:1: cond_expression returns [Info theInfo] : a= arith_expression ( RelationOP b= arith_expression )* ;
	public final Info cond_expression() throws RecognitionException {
		Info theInfo = null;


		Token RelationOP15=null;
		Info a =null;
		Info b =null;

		theInfo = new Info();
		try {
			// myCompiler.g:523:16: (a= arith_expression ( RelationOP b= arith_expression )* )
			// myCompiler.g:523:18: a= arith_expression ( RelationOP b= arith_expression )*
			{
			pushFollow(FOLLOW_arith_expression_in_cond_expression1069);
			a=arith_expression();
			state._fsp--;

			 theInfo =a;
			// myCompiler.g:524:8: ( RelationOP b= arith_expression )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==RelationOP) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// myCompiler.g:524:9: RelationOP b= arith_expression
					{
					RelationOP15=(Token)match(input,RelationOP,FOLLOW_RelationOP_in_cond_expression1080); 
					pushFollow(FOLLOW_arith_expression_in_cond_expression1084);
					b=arith_expression();
					state._fsp--;


										// 生成對應的LLVM IR代碼
										String llvmOP = "";
										//int
										if((a.theType == Type.INT) && (b.theType == Type.INT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " i32 %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
											// 更新變量信息
					          				theInfo.theType = Type.BOOL; // 假設結果是布爾類型
					          				theInfo.theVar.varIndex = varCount;
					          				varCount++;
										}
										else if((a.theType == Type.INT) && (b.theType == Type.CONST_INT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;	
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " i32 %t" + theInfo.theVar.varIndex + ", " + b.theVar.iValue);
											// 更新變量信息
					          				theInfo.theType = Type.BOOL; // 假設結果是布爾類型
					          				theInfo.theVar.varIndex = varCount;
					          				varCount++;
										}
										else if((a.theType == Type.CONST_INT) && (b.theType == Type.INT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " i32 " + a.theVar.iValue + ", %t" + b.theVar.varIndex);
											// 更新變量信息
					          				theInfo.theType = Type.BOOL; // 假設結果是布爾類型
					          				theInfo.theVar.varIndex = varCount;
					          				varCount++;
										}
										else if((a.theType == Type.CONST_INT) && (b.theType == Type.CONST_INT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " i32 " + a.theVar.iValue + ", " + b.theVar.iValue);
										   
								    		// Update arith_expression's theInfo.
								    		theInfo.theType = Type.BOOL;
								    		theInfo.theVar.varIndex = varCount;
								    		varCount ++;
										}

										//float
										else if((a.theType == Type.FLOAT) && (b.theType == Type.FLOAT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " float %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
						   
								    		// Update arith_expression's theInfo.
								    		theInfo.theType = Type.BOOL;
								    		theInfo.theVar.varIndex = varCount;
								    		varCount ++;
										}
										else if((a.theType == Type.FLOAT) && (b.theType == Type.CONST_FLOAT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " float %t" + theInfo.theVar.varIndex + ", " + b.theVar.fValue);
						   					// Update arith_expression's theInfo.
								    		theInfo.theType = Type.BOOL;
								    		theInfo.theVar.varIndex = varCount;
								    		varCount ++;
										}
										else if((a.theType == Type.CONST_FLOAT) && (b.theType == Type.FLOAT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " float " + a.theVar.fValue + ", %t" + b.theVar.varIndex);
						   					// Update arith_expression's theInfo.
								    		theInfo.theType = Type.BOOL;
								    		theInfo.theVar.varIndex = varCount;
								    		varCount ++;
										}
										else if((a.theType == Type.CONST_FLOAT) && (b.theType == Type.CONST_FLOAT)) {
											switch (RelationOP15.getText()){
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
													theInfo.theType = Type.ERR;
													break;
											}
											TextCode.add("%t" + varCount + " = " + llvmOP + " float " + a.theVar.fValue + ", " + b.theVar.fValue);
						   					// Update arith_expression's theInfo.
								    		theInfo.theType = Type.BOOL;
								    		theInfo.theVar.varIndex = varCount;
								    		varCount ++;
										}

										//error
										else{
											System.out.println("Error! " + RelationOP15.getLine() + ": Type mismatch for the condition operator in an expression.");
											theInfo.theType = Type.ERR;
											System.exit(0);
										}
									
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "cond_expression"



	// $ANTLR start "arith_expression"
	// myCompiler.g:784:1: arith_expression returns [Info theInfo] : a= multExpr ( ADD b= multExpr | SUB_OR_UNARY c= multExpr )* ;
	public final Info arith_expression() throws RecognitionException {
		Info theInfo = null;


		Token ADD16=null;
		Token SUB_OR_UNARY17=null;
		Info a =null;
		Info b =null;
		Info c =null;

		theInfo = new Info();
		try {
			// myCompiler.g:787:17: (a= multExpr ( ADD b= multExpr | SUB_OR_UNARY c= multExpr )* )
			// myCompiler.g:787:19: a= multExpr ( ADD b= multExpr | SUB_OR_UNARY c= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_arith_expression1155);
			a=multExpr();
			state._fsp--;

			 theInfo =a; 
			// myCompiler.g:788:18: ( ADD b= multExpr | SUB_OR_UNARY c= multExpr )*
			loop10:
			while (true) {
				int alt10=3;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==ADD) ) {
					alt10=1;
				}
				else if ( (LA10_0==SUB_OR_UNARY) ) {
					alt10=2;
				}

				switch (alt10) {
				case 1 :
					// myCompiler.g:788:20: ADD b= multExpr
					{
					ADD16=(Token)match(input,ADD,FOLLOW_ADD_in_arith_expression1178); 
					pushFollow(FOLLOW_multExpr_in_arith_expression1182);
					b=multExpr();
					state._fsp--;


					                    	// We need to do type checking first.
					                       	// ...
										  
					                       	// code generation.
					                       
					                       	//int					   
					                    	if ((a.theType == Type.INT) && (b.theType == Type.INT)) {
					                    		TextCode.add("%t" + varCount + " = add nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	} 
					                       	else if ((a.theType == Type.INT) && (b.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = add nsw i32 %t" + theInfo.theVar.varIndex + ", " + b.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                    	else if((a.theType == Type.CONST_INT) && (b.theType == Type.INT)) {
					                    		TextCode.add("%t" + varCount + " = add nsw i32 " + a.theVar.iValue + ", %t" + b.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if ((a.theType == Type.CONST_INT) && (b.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = add nsw i32 " + a.theVar.iValue + ", " + b.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       
					                       	//float
					                       	else if((a.theType == Type.FLOAT) && (b.theType == Type.FLOAT)) {
					                           	TextCode.add("%t" + varCount + " = fadd float %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.FLOAT) && (b.theType == Type.CONST_FLOAT)) {
					                       
					                        	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = b.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fadd float %t" + theInfo.theVar.varIndex + ", 0x" + hexValue);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       		}
					                       	else if((a.theType == Type.CONST_FLOAT) && (b.theType == Type.FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = a.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fadd float 0x" + hexValue + ", %t" + b.theVar.varIndex);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_FLOAT) && (b.theType == Type.CONST_FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val_L = a.theVar.fValue;
					    		   	    		long bits_L = Double.doubleToLongBits(val_L);
					    		   	    		String hexValue_L = Long.toHexString(bits_L);
					    		   	    		double val_R = b.theVar.fValue;
					    		   	    		long bits_R = Double.doubleToLongBits(val_R);
					    		   	    		String hexValue_R = Long.toHexString(bits_R);

					                           	TextCode.add("%t" + varCount + " = fadd float 0x" + hexValue_L + ", 0x" + hexValue_R);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++; 
					                       	}

											//error
											else{
												System.out.println("Error! " + ADD16.getLine() + ": Type mismatch for the operator + in an expression.");
												theInfo.theType = Type.ERR;
												System.exit(0);
											}
					                    
					}
					break;
				case 2 :
					// myCompiler.g:892:20: SUB_OR_UNARY c= multExpr
					{
					SUB_OR_UNARY17=(Token)match(input,SUB_OR_UNARY,FOLLOW_SUB_OR_UNARY_in_arith_expression1226); 
					pushFollow(FOLLOW_multExpr_in_arith_expression1230);
					c=multExpr();
					state._fsp--;


					                    	// We need to do type checking first.
					                       	// ...
										  
					                       	// code generation.	
					                       	// int				   
					                       	if ((a.theType == Type.INT) && (c.theType == Type.INT)) {
					                           	TextCode.add("%t" + varCount + " = sub nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	} 
					                       	else if ((a.theType == Type.INT) && (c.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = sub nsw i32 %t" + theInfo.theVar.varIndex + ", " + c.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if ((a.theType == Type.CONST_INT) && (c.theType == Type.INT)) {
					                           	TextCode.add("%t" + varCount + " = sub nsw i32 " + a.theVar.iValue + ", %t" + c.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if ((a.theType == Type.CONST_INT) && (c.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = sub nsw i32 " + a.theVar.iValue + ", " + c.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       
					                       	// float
					                       	else if((a.theType == Type.FLOAT) && (c.theType == Type.FLOAT)) {
					                           	TextCode.add("%t" + varCount + " = fsub float %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);
						   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.FLOAT) && (c.theType == Type.CONST_FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = c.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fsub float %t" + theInfo.theVar.varIndex + ", 0x" + hexValue);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_FLOAT) && (c.theType == Type.FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = a.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fsub float 0x" + hexValue + ", %t" + c.theVar.varIndex);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_FLOAT) && (c.theType == Type.CONST_FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val_L = a.theVar.fValue;
					    		   	    		long bits_L = Double.doubleToLongBits(val_L);
					    		   	    		String hexValue_L = Long.toHexString(bits_L);
					    		   	    		double val_R = c.theVar.fValue;
					    		   	    		long bits_R = Double.doubleToLongBits(val_R);
					    		   	    		String hexValue_R = Long.toHexString(bits_R);

					                           	TextCode.add("%t" + varCount + " = fsub float 0x" + hexValue_L + ", 0x" + hexValue_R);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++; 
					                       	}

											//error
											else{
												System.out.println("Error! " + SUB_OR_UNARY17.getLine() +": Type mismatch for the operator - in an expression.");
												theInfo.theType = Type.ERR;
												System.exit(0);
											}

					                    
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "arith_expression"



	// $ANTLR start "multExpr"
	// myCompiler.g:998:1: multExpr returns [Info theInfo] : a= signExpr ( MUL b= signExpr | DIV c= signExpr )* ;
	public final Info multExpr() throws RecognitionException {
		Info theInfo = null;


		Token MUL18=null;
		Token DIV19=null;
		Info a =null;
		Info b =null;
		Info c =null;

		theInfo = new Info();
		try {
			// myCompiler.g:1001:12: (a= signExpr ( MUL b= signExpr | DIV c= signExpr )* )
			// myCompiler.g:1001:14: a= signExpr ( MUL b= signExpr | DIV c= signExpr )*
			{
			pushFollow(FOLLOW_signExpr_in_multExpr1320);
			a=signExpr();
			state._fsp--;

			 theInfo =a; 
			// myCompiler.g:1002:12: ( MUL b= signExpr | DIV c= signExpr )*
			loop11:
			while (true) {
				int alt11=3;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==MUL) ) {
					alt11=1;
				}
				else if ( (LA11_0==DIV) ) {
					alt11=2;
				}

				switch (alt11) {
				case 1 :
					// myCompiler.g:1002:14: MUL b= signExpr
					{
					MUL18=(Token)match(input,MUL,FOLLOW_MUL_in_multExpr1337); 
					pushFollow(FOLLOW_signExpr_in_multExpr1341);
					b=signExpr();
					state._fsp--;


					                    	// We need to do type checking first.
					                       	// ...
										  
					                       	// code generation.
					                       	// int	
					                       		   
					                       	if ((a.theType == Type.INT) && (b.theType == Type.INT)) {
					                           	TextCode.add("%t" + varCount + " = mul nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	} 
					                       	else if ((a.theType == Type.INT) && (b.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = mul nsw i32 %t" + theInfo.theVar.varIndex + ", " + b.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_INT) && (b.theType == Type.INT)) {
					                           	TextCode.add("%t" + varCount + " = mul nsw i32 " + a.theVar.iValue + ", %t" + b.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if ((a.theType == Type.CONST_INT) && (b.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = mul nsw i32 " + a.theVar.iValue + ", " + b.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       
					                       	// float
					                       	else if((a.theType == Type.FLOAT) && (b.theType == Type.FLOAT)) {
					                           	TextCode.add("%t" + varCount + " = fmul float %t" + theInfo.theVar.varIndex + ", %t" + b.theVar.varIndex);
						   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.FLOAT) && (b.theType == Type.CONST_FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = b.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fmul float %t" + theInfo.theVar.varIndex + ", 0x" + hexValue);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_FLOAT) && (b.theType == Type.FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = a.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fmul float 0x" + hexValue + ", %t" + b.theVar.varIndex);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_FLOAT) && (b.theType == Type.CONST_FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val_L = a.theVar.fValue;
					    		   	    		long bits_L = Double.doubleToLongBits(val_L);
					    		   	    		String hexValue_L = Long.toHexString(bits_L);
					    		   	    		double val_R = b.theVar.fValue;
					    		   	    		long bits_R = Double.doubleToLongBits(val_R);
					    		   	    		String hexValue_R = Long.toHexString(bits_R);

					                           	TextCode.add("%t" + varCount + " = fmul float 0x" + hexValue_L + ", 0x" + hexValue_R);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++; 
					                       	}

											//error
											else{
												System.out.println("Error! " + MUL18.getLine() +": Type mismatch for the operator * in an expression.");
												theInfo.theType = Type.ERR;
												System.exit(0);
											}
					                 
					}
					break;
				case 2 :
					// myCompiler.g:1105:14: DIV c= signExpr
					{
					DIV19=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr1370); 
					pushFollow(FOLLOW_signExpr_in_multExpr1374);
					c=signExpr();
					state._fsp--;


					                       	// We need to do type checking first.
					                       	// ...
										  
					                       	// code generation.
					                       	// int					   
					                       	if ((a.theType == Type.INT) && (c.theType == Type.INT)) {
					                           	TextCode.add("%t" + varCount + " = sdiv i32 %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	} 
					                       	else if ((a.theType == Type.INT) && (c.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = sdiv i32 %t" + theInfo.theVar.varIndex + ", " + c.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if ((a.theType == Type.CONST_INT) && (c.theType == Type.INT)) {
					                           	TextCode.add("%t" + varCount + " = sdiv i32 " + a.theVar.iValue + ", %t" + c.theVar.varIndex);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if ((a.theType == Type.CONST_INT) && (c.theType == Type.CONST_INT)) {
					                           	TextCode.add("%t" + varCount + " = sdiv i32 " + a.theVar.iValue + ", " + c.theVar.iValue);
										   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.INT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}

					                       	// float
					                       	else if((a.theType == Type.FLOAT) && (c.theType == Type.FLOAT)) {
					                           	TextCode.add("%t" + varCount + " = fdiv float %t" + theInfo.theVar.varIndex + ", %t" + c.theVar.varIndex);

								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.FLOAT) && (c.theType == Type.CONST_FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = c.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fdiv float %t" + theInfo.theVar.varIndex + ", 0x" + hexValue);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_FLOAT) && (c.theType == Type.FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val = a.theVar.fValue;
					    		   	    		long bits = Double.doubleToLongBits(val);
					    		   	    		String hexValue = Long.toHexString(bits);
					    		   	    
					                           	TextCode.add("%t" + varCount + " = fdiv float 0x" + hexValue + ", %t" + c.theVar.varIndex);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++;
					                       	}
					                       	else if((a.theType == Type.CONST_FLOAT) && (c.theType == Type.CONST_FLOAT)) {
					                       
					                           	// Convert the floating-point constant to its hexadecimal representation
					    		    	    	double val_L = a.theVar.fValue;
					    		   	    		long bits_L = Double.doubleToLongBits(val_L);
					    		   	    		String hexValue_L = Long.toHexString(bits_L);
					    		   	    		double val_R = c.theVar.fValue;
					    		   	    		long bits_R = Double.doubleToLongBits(val_R);
					    		   	    		String hexValue_R = Long.toHexString(bits_R);

					                           	TextCode.add("%t" + varCount + " = fdiv float 0x" + hexValue_L + ", 0x" + hexValue_R);
					   
								    			// Update arith_expression's theInfo.
								    			theInfo.theType = Type.FLOAT;
								    			theInfo.theVar.varIndex = varCount;
								    			varCount ++; 
					                       	}

											//error
											else{
												System.out.println("Error! " + DIV19.getLine() +": Type mismatch for the operator / in an expression.");
												theInfo.theType = Type.ERR;
												System.exit(0);
											}
					                
					}
					break;

				default :
					break loop11;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "signExpr"
	// myCompiler.g:1210:1: signExpr returns [Info theInfo] : (a= primaryExpr | SUB_OR_UNARY a= primaryExpr );
	public final Info signExpr() throws RecognitionException {
		Info theInfo = null;


		Token SUB_OR_UNARY20=null;
		Info a =null;

		theInfo = new Info();
		try {
			// myCompiler.g:1213:10: (a= primaryExpr | SUB_OR_UNARY a= primaryExpr )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==Floating_point_constant||(LA12_0 >= Identifier && LA12_0 <= Integer_constant)||(LA12_0 >= 29 && LA12_0 <= 30)) ) {
				alt12=1;
			}
			else if ( (LA12_0==SUB_OR_UNARY) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// myCompiler.g:1213:12: a= primaryExpr
					{
					pushFollow(FOLLOW_primaryExpr_in_signExpr1430);
					a=primaryExpr();
					state._fsp--;

					 theInfo =a; 
					}
					break;
				case 2 :
					// myCompiler.g:1214:12: SUB_OR_UNARY a= primaryExpr
					{
					SUB_OR_UNARY20=(Token)match(input,SUB_OR_UNARY,FOLLOW_SUB_OR_UNARY_in_signExpr1446); 
					pushFollow(FOLLOW_primaryExpr_in_signExpr1450);
					a=primaryExpr();
					state._fsp--;


					        	   		if (a.theType == Type.INT) {
					    					TextCode.add("%t" + varCount + " = sub nsw i32 0, %t" + a.theVar.varIndex);
					    					// Update theInfo.
					    					theInfo.theType = Type.INT;
					    					theInfo.theVar.varIndex = varCount;
					    					varCount++;
										}
										else if (a.theType == Type.CONST_INT) {
											TextCode.add("%t" + varCount + " = sub nsw i32 0, " + a.theVar.iValue);
					    					// Update theInfo.
					    				
					    					theInfo.theType = Type.INT;
					    					theInfo.theVar.varIndex = varCount;
					    					varCount++;
										}
										else if (a.theType == Type.FLOAT) {

					    					TextCode.add("%t" + varCount + " = fsub float 0x0000000000000000, %t" + a.theVar.varIndex);
					    					// Update theInfo.
					    					theInfo.theType = Type.FLOAT;
					    					theInfo.theVar.varIndex = varCount;
					    					varCount++;
										}
										else if (a.theType == Type.CONST_FLOAT) {

											
											// Convert the floating-point constant to its hexadecimal representation
					    		    	    double val = a.theVar.fValue;
					    		   	    	long bits = Double.doubleToLongBits(val);
					    		   	    	String hexValue = Long.toHexString(bits);

											TextCode.add("%t" + varCount + " = fsub float 0x0000000000000000, 0x" + hexValue);
					    					// Update theInfo.
					    				
					    					theInfo.theType = Type.FLOAT;
					    					theInfo.theVar.varIndex = varCount;
					    					varCount++;
										}
										else{
											System.out.println("Error! " + SUB_OR_UNARY20.getLine() +": Type mismatch for the unary operator - in an expression.");
											theInfo.theType = Type.ERR;
											System.exit(0);
										}
										
					        	   	
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "signExpr"



	// $ANTLR start "primaryExpr"
	// myCompiler.g:1263:1: primaryExpr returns [Info theInfo] : ( Integer_constant | Floating_point_constant | Identifier | '&' Identifier | '(' arith_expression ')' );
	public final Info primaryExpr() throws RecognitionException {
		Info theInfo = null;


		Token Integer_constant21=null;
		Token Floating_point_constant22=null;
		Token Identifier23=null;
		Info arith_expression24 =null;

		theInfo = new Info();
		try {
			// myCompiler.g:1266:12: ( Integer_constant | Floating_point_constant | Identifier | '&' Identifier | '(' arith_expression ')' )
			int alt13=5;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				alt13=1;
				}
				break;
			case Floating_point_constant:
				{
				alt13=2;
				}
				break;
			case Identifier:
				{
				alt13=3;
				}
				break;
			case 29:
				{
				alt13=4;
				}
				break;
			case 30:
				{
				alt13=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// myCompiler.g:1266:14: Integer_constant
					{
					Integer_constant21=(Token)match(input,Integer_constant,FOLLOW_Integer_constant_in_primaryExpr1501); 

					            	theInfo.theType = Type.CONST_INT;
									theInfo.theVar.iValue = Integer.parseInt((Integer_constant21!=null?Integer_constant21.getText():null));
					            
					}
					break;
				case 2 :
					// myCompiler.g:1271:15: Floating_point_constant
					{
					Floating_point_constant22=(Token)match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primaryExpr1525); 

					           		theInfo.theType = Type.CONST_FLOAT;
									theInfo.theVar.fValue = Float.parseFloat((Floating_point_constant22!=null?Floating_point_constant22.getText():null));
								
					}
					break;
				case 3 :
					// myCompiler.g:1276:15: Identifier
					{
					Identifier23=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryExpr1555); 

					                // get type information from symtab.
					                Type the_type = symtab.get((Identifier23!=null?Identifier23.getText():null)).theType;
									theInfo.theType = the_type;

					                // get variable index from symtab.
					                int vIndex = symtab.get((Identifier23!=null?Identifier23.getText():null)).theVar.varIndex;
									
					                switch (the_type) {
					                	case INT: 
					                        // get a new temporary variable and
											// load the variable into the temporary variable.
					                         
											// Ex: %tx = load i32, i32* %ty.
											TextCode.add("%t" + varCount + " = load i32, i32* %t" + vIndex);
									         
											// Now, Identifier's value is at the temporary variable %t[varCount].
											// Therefore, update it.
											theInfo.theVar.varIndex = varCount;
											varCount ++;
					                        break;
					                	case FLOAT:
					                		// get a new temporary variable and load the variable into the temporary variable.
					    					// Ex: %tx = load float, float* %ty.
					    					TextCode.add("%t" + varCount + " = load float, float* %t" + vIndex);

					    					// Now, Identifier's value is at the temporary variable %t[varCount].
					    					// Therefore, update it.
					    					
					    					theInfo.theVar.varIndex = varCount;
					    					varCount++;
					                        break;
					                	case CHAR:
					                		// get a new temporary variable and load the variable into the temporary variable.
					    					// Ex: %tx = load i8, i8* %ty.
					    					TextCode.add("%t" + varCount + " = load i8, i8* %t" + vIndex);

					    					// Now, Identifier's value is at the temporary variable %t[varCount].
					    					// Therefore, update it.
					    					theInfo.theVar.varIndex = varCount;
					    					varCount++;
					                        break;
										default:
											System.out.println("Error! " + Identifier23.getLine() + " :　This datatype is not supported or wrong");
											theInfo.theType = Type.ERR;
											System.exit(0);
											
								
					                }
					            
					}
					break;
				case 4 :
					// myCompiler.g:1327:11: '&' Identifier
					{
					match(input,29,FOLLOW_29_in_primaryExpr1581); 
					match(input,Identifier,FOLLOW_Identifier_in_primaryExpr1583); 
					}
					break;
				case 5 :
					// myCompiler.g:1328:11: '(' arith_expression ')'
					{
					match(input,30,FOLLOW_30_in_primaryExpr1598); 
					pushFollow(FOLLOW_arith_expression_in_primaryExpr1600);
					arith_expression24=arith_expression();
					state._fsp--;

					match(input,31,FOLLOW_31_in_primaryExpr1602); 

					    			// 直接传递子表达式的 theInfo 值给父表达式的 theInfo
					       			theInfo =arith_expression24;
						       	
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "primaryExpr"

	// Delegated rules



	public static final BitSet FOLLOW_VOID_in_program36 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_MAIN_in_program38 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_program40 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_program42 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_program63 = new BitSet(new long[]{0x000000100808EC60L});
	public static final BitSet FOLLOW_declarations_in_program77 = new BitSet(new long[]{0x000000100808A840L});
	public static final BitSet FOLLOW_statements_in_program90 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_program100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations127 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Identifier_in_declarations129 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_declarations131 = new BitSet(new long[]{0x0000000000004420L});
	public static final BitSet FOLLOW_declarations_in_declarations133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_in_type204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_type214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements225 = new BitSet(new long[]{0x000000000808A840L});
	public static final BitSet FOLLOW_statements_in_statements227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_stmt_in_statement258 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_statement260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stmt_in_statement273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_no_return_stmt_in_statement286 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_statement288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stmt_in_statement301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stmt_in_statement308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINTF_in_statement315 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_statement317 = new BitSet(new long[]{0x0000000003800000L});
	public static final BitSet FOLLOW_printf_expression_in_statement319 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_statement321 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_statement323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMENT_in_statement331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_stmt348 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_for_stmt352 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assign_stmt_in_for_stmt361 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_for_stmt363 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_cond_expression_in_for_stmt388 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_for_stmt390 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assign_stmt_templlvmIR_in_for_stmt417 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_for_stmt434 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_for_block_stmt_in_for_stmt452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_for_block_stmt480 = new BitSet(new long[]{0x000000100808A840L});
	public static final BitSet FOLLOW_statements_in_for_block_stmt482 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_for_block_stmt484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_stmt495 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_while_stmt497 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_cond_expression_in_while_stmt509 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_while_stmt521 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_while_block_stmt_in_while_stmt523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_while_block_stmt545 = new BitSet(new long[]{0x000000100808A840L});
	public static final BitSet FOLLOW_statements_in_while_block_stmt547 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_while_block_stmt549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_stmt574 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_if_stmt576 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_cond_expression_in_if_stmt580 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_if_stmt582 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_if_block_stmt_in_if_stmt593 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_ELSE_in_if_stmt599 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_else_block_stmt_in_if_stmt601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_if_block_stmt628 = new BitSet(new long[]{0x000000100808A840L});
	public static final BitSet FOLLOW_statements_in_if_block_stmt630 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_if_block_stmt632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_else_block_stmt647 = new BitSet(new long[]{0x000000100808A840L});
	public static final BitSet FOLLOW_statements_in_else_block_stmt660 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_else_block_stmt662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEXT1_in_printf_expression676 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_printf_expression678 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_arith_expression_in_printf_expression682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEXT2_in_printf_expression699 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEXT3_in_printf_expression716 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_printf_expression718 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_arith_expression_in_printf_expression722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_assign_stmt871 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_assign_stmt873 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_arith_expression_in_assign_stmt875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_assign_stmt_templlvmIR914 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_assign_stmt_templlvmIR916 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_arith_expression_in_assign_stmt_templlvmIR918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_func_no_return_stmt962 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_func_no_return_stmt964 = new BitSet(new long[]{0x0000000060619000L});
	public static final BitSet FOLLOW_argument_in_func_no_return_stmt966 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_func_no_return_stmt968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_in_argument995 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_argument998 = new BitSet(new long[]{0x0000000060619000L});
	public static final BitSet FOLLOW_arg_in_argument1000 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_arith_expression_in_arg1018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_arg1025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arith_expression_in_cond_expression1069 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_RelationOP_in_cond_expression1080 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_arith_expression_in_cond_expression1084 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression1155 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_ADD_in_arith_expression1178 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression1182 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_SUB_OR_UNARY_in_arith_expression1226 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression1230 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1320 = new BitSet(new long[]{0x0000000000040082L});
	public static final BitSet FOLLOW_MUL_in_multExpr1337 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1341 = new BitSet(new long[]{0x0000000000040082L});
	public static final BitSet FOLLOW_DIV_in_multExpr1370 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1374 = new BitSet(new long[]{0x0000000000040082L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr1430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUB_OR_UNARY_in_signExpr1446 = new BitSet(new long[]{0x0000000060019000L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr1450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primaryExpr1501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primaryExpr1525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr1555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_primaryExpr1581 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr1583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_primaryExpr1598 = new BitSet(new long[]{0x0000000060419000L});
	public static final BitSet FOLLOW_arith_expression_in_primaryExpr1600 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_primaryExpr1602 = new BitSet(new long[]{0x0000000000000002L});
}
