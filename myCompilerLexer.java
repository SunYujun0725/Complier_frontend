// $ANTLR 3.5.3 myCompiler.g 2023-05-30 23:40:53

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCompilerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public myCompilerLexer() {} 
	public myCompilerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "myCompiler.g"; }

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:7:7: ( '&' )
			// myCompiler.g:7:9: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:8:7: ( '(' )
			// myCompiler.g:8:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:9:7: ( ')' )
			// myCompiler.g:9:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:10:7: ( ',' )
			// myCompiler.g:10:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:11:7: ( ';' )
			// myCompiler.g:11:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:12:7: ( '=' )
			// myCompiler.g:12:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:13:7: ( '{' )
			// myCompiler.g:13:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:14:7: ( '}' )
			// myCompiler.g:14:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "TEXT1"
	public final void mTEXT1() throws RecognitionException {
		try {
			int _type = TEXT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:417:6: ( '\"' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '%d' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '\"' )
			// myCompiler.g:417:8: '\"' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '%d' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '\"'
			{
			match('\"'); 
			// myCompiler.g:417:12: ( '%%' | '\"\"' |~ ( '\"' | '%' ) )*
			loop1:
			while (true) {
				int alt1=4;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='%') ) {
					int LA1_1 = input.LA(2);
					if ( (LA1_1=='%') ) {
						alt1=1;
					}

				}
				else if ( (LA1_0=='\"') ) {
					alt1=2;
				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '$')||(LA1_0 >= '&' && LA1_0 <= '\uFFFF')) ) {
					alt1=3;
				}

				switch (alt1) {
				case 1 :
					// myCompiler.g:417:14: '%%'
					{
					match("%%"); 

					}
					break;
				case 2 :
					// myCompiler.g:417:20: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 3 :
					// myCompiler.g:417:27: ~ ( '\"' | '%' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '&' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			match("%d"); 

			// myCompiler.g:417:46: ( '%%' | '\"\"' |~ ( '\"' | '%' ) )*
			loop2:
			while (true) {
				int alt2=4;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\"') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='\"') ) {
						alt2=2;
					}

				}
				else if ( (LA2_0=='%') ) {
					alt2=1;
				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '$')||(LA2_0 >= '&' && LA2_0 <= '\uFFFF')) ) {
					alt2=3;
				}

				switch (alt2) {
				case 1 :
					// myCompiler.g:417:48: '%%'
					{
					match("%%"); 

					}
					break;
				case 2 :
					// myCompiler.g:417:54: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 3 :
					// myCompiler.g:417:61: ~ ( '\"' | '%' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '&' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEXT1"

	// $ANTLR start "TEXT2"
	public final void mTEXT2() throws RecognitionException {
		try {
			int _type = TEXT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:418:6: ( '\"' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '\"' )
			// myCompiler.g:418:8: '\"' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '\"'
			{
			match('\"'); 
			// myCompiler.g:418:11: ( '%%' | '\"\"' |~ ( '\"' | '%' ) )*
			loop3:
			while (true) {
				int alt3=4;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\"') ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1=='\"') ) {
						alt3=2;
					}

				}
				else if ( (LA3_0=='%') ) {
					alt3=1;
				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '$')||(LA3_0 >= '&' && LA3_0 <= '\uFFFF')) ) {
					alt3=3;
				}

				switch (alt3) {
				case 1 :
					// myCompiler.g:418:13: '%%'
					{
					match("%%"); 

					}
					break;
				case 2 :
					// myCompiler.g:418:19: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 3 :
					// myCompiler.g:418:26: ~ ( '\"' | '%' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '&' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEXT2"

	// $ANTLR start "TEXT3"
	public final void mTEXT3() throws RecognitionException {
		try {
			int _type = TEXT3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:419:6: ( '\"' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '%f' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '\"' )
			// myCompiler.g:419:8: '\"' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '%f' ( '%%' | '\"\"' |~ ( '\"' | '%' ) )* '\"'
			{
			match('\"'); 
			// myCompiler.g:419:12: ( '%%' | '\"\"' |~ ( '\"' | '%' ) )*
			loop4:
			while (true) {
				int alt4=4;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='%') ) {
					int LA4_1 = input.LA(2);
					if ( (LA4_1=='%') ) {
						alt4=1;
					}

				}
				else if ( (LA4_0=='\"') ) {
					alt4=2;
				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '$')||(LA4_0 >= '&' && LA4_0 <= '\uFFFF')) ) {
					alt4=3;
				}

				switch (alt4) {
				case 1 :
					// myCompiler.g:419:14: '%%'
					{
					match("%%"); 

					}
					break;
				case 2 :
					// myCompiler.g:419:20: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 3 :
					// myCompiler.g:419:27: ~ ( '\"' | '%' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '&' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			match("%f"); 

			// myCompiler.g:419:46: ( '%%' | '\"\"' |~ ( '\"' | '%' ) )*
			loop5:
			while (true) {
				int alt5=4;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\"') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='\"') ) {
						alt5=2;
					}

				}
				else if ( (LA5_0=='%') ) {
					alt5=1;
				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '$')||(LA5_0 >= '&' && LA5_0 <= '\uFFFF')) ) {
					alt5=3;
				}

				switch (alt5) {
				case 1 :
					// myCompiler.g:419:48: '%%'
					{
					match("%%"); 

					}
					break;
				case 2 :
					// myCompiler.g:419:54: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 3 :
					// myCompiler.g:419:61: ~ ( '\"' | '%' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '&' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEXT3"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1337:6: ( 'float' )
			// myCompiler.g:1337:7: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1338:4: ( 'int' )
			// myCompiler.g:1338:5: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1339:5: ( 'char' )
			// myCompiler.g:1339:7: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1340:4: ( '+' )
			// myCompiler.g:1340:6: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "SUB_OR_UNARY"
	public final void mSUB_OR_UNARY() throws RecognitionException {
		try {
			int _type = SUB_OR_UNARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1341:13: ( '-' )
			// myCompiler.g:1341:15: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB_OR_UNARY"

	// $ANTLR start "MUL"
	public final void mMUL() throws RecognitionException {
		try {
			int _type = MUL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1342:4: ( '*' )
			// myCompiler.g:1342:6: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1343:4: ( '/' )
			// myCompiler.g:1343:6: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "PRINTF"
	public final void mPRINTF() throws RecognitionException {
		try {
			int _type = PRINTF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1344:7: ( 'printf' )
			// myCompiler.g:1344:9: 'printf'
			{
			match("printf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTF"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1345:6: ( 'while' )
			// myCompiler.g:1345:8: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1348:5: ( 'main' )
			// myCompiler.g:1348:7: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1349:5: ( 'void' )
			// myCompiler.g:1349:7: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1350:3: ( 'if' )
			// myCompiler.g:1350:5: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1351:5: ( 'else' )
			// myCompiler.g:1351:7: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1352:4: ( 'for' )
			// myCompiler.g:1352:6: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "RelationOP"
	public final void mRelationOP() throws RecognitionException {
		try {
			int _type = RelationOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1354:11: ( '>' | '>=' | '<' | '<=' | '==' | '!=' )
			int alt6=6;
			switch ( input.LA(1) ) {
			case '>':
				{
				int LA6_1 = input.LA(2);
				if ( (LA6_1=='=') ) {
					alt6=2;
				}

				else {
					alt6=1;
				}

				}
				break;
			case '<':
				{
				int LA6_2 = input.LA(2);
				if ( (LA6_2=='=') ) {
					alt6=4;
				}

				else {
					alt6=3;
				}

				}
				break;
			case '=':
				{
				alt6=5;
				}
				break;
			case '!':
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// myCompiler.g:1354:13: '>'
					{
					match('>'); 
					}
					break;
				case 2 :
					// myCompiler.g:1354:18: '>='
					{
					match(">="); 

					}
					break;
				case 3 :
					// myCompiler.g:1354:25: '<'
					{
					match('<'); 
					}
					break;
				case 4 :
					// myCompiler.g:1354:31: '<='
					{
					match("<="); 

					}
					break;
				case 5 :
					// myCompiler.g:1354:38: '=='
					{
					match("=="); 

					}
					break;
				case 6 :
					// myCompiler.g:1354:45: '!='
					{
					match("!="); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RelationOP"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1356:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// myCompiler.g:1356:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// myCompiler.g:1356:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop7;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Identifier"

	// $ANTLR start "Integer_constant"
	public final void mInteger_constant() throws RecognitionException {
		try {
			int _type = Integer_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1357:17: ( ( '0' .. '9' )+ )
			// myCompiler.g:1357:18: ( '0' .. '9' )+
			{
			// myCompiler.g:1357:18: ( '0' .. '9' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Integer_constant"

	// $ANTLR start "Floating_point_constant"
	public final void mFloating_point_constant() throws RecognitionException {
		try {
			int _type = Floating_point_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1358:24: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// myCompiler.g:1358:25: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// myCompiler.g:1358:25: ( '0' .. '9' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			match('.'); 
			// myCompiler.g:1358:39: ( '0' .. '9' )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Floating_point_constant"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1361:5: ( '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"' )
			// myCompiler.g:1361:8: '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// myCompiler.g:1361:12: ( EscapeSequence |~ ( '\\\\' | '\"' ) )*
			loop11:
			while (true) {
				int alt11=3;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\\') ) {
					alt11=1;
				}
				else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
					alt11=2;
				}

				switch (alt11) {
				case 1 :
					// myCompiler.g:1361:14: EscapeSequence
					{
					mEscapeSequence(); 

					}
					break;
				case 2 :
					// myCompiler.g:1361:31: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1364:3: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// myCompiler.g:1364:4: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1367:8: ( '/*' ( . )* '*/' | '//' ( . )* '\\n' )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='/') ) {
				int LA14_1 = input.LA(2);
				if ( (LA14_1=='*') ) {
					alt14=1;
				}
				else if ( (LA14_1=='/') ) {
					alt14=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// myCompiler.g:1367:9: '/*' ( . )* '*/'
					{
					match("/*"); 

					// myCompiler.g:1367:14: ( . )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0=='*') ) {
							int LA12_1 = input.LA(2);
							if ( (LA12_1=='/') ) {
								alt12=2;
							}
							else if ( ((LA12_1 >= '\u0000' && LA12_1 <= '.')||(LA12_1 >= '0' && LA12_1 <= '\uFFFF')) ) {
								alt12=1;
							}

						}
						else if ( ((LA12_0 >= '\u0000' && LA12_0 <= ')')||(LA12_0 >= '+' && LA12_0 <= '\uFFFF')) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// myCompiler.g:1367:14: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop12;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;
				case 2 :
					// myCompiler.g:1368:4: '//' ( . )* '\\n'
					{
					match("//"); 

					// myCompiler.g:1368:8: ( . )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0=='\n') ) {
							alt13=2;
						}
						else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\uFFFF')) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// myCompiler.g:1368:9: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop13;
						}
					}

					match('\n'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "EscapeSequence"
	public final void mEscapeSequence() throws RecognitionException {
		try {
			// myCompiler.g:1374:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
			// myCompiler.g:1374:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
			{
			match('\\'); 
			if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EscapeSequence"

	@Override
	public void mTokens() throws RecognitionException {
		// myCompiler.g:1:8: ( T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | TEXT1 | TEXT2 | TEXT3 | FLOAT | INT | CHAR | ADD | SUB_OR_UNARY | MUL | DIV | PRINTF | WHILE | MAIN | VOID | IF | ELSE | FOR | RelationOP | Identifier | Integer_constant | Floating_point_constant | STRING_LITERAL | WS | COMMENT )
		int alt15=32;
		alt15 = dfa15.predict(input);
		switch (alt15) {
			case 1 :
				// myCompiler.g:1:10: T__29
				{
				mT__29(); 

				}
				break;
			case 2 :
				// myCompiler.g:1:16: T__30
				{
				mT__30(); 

				}
				break;
			case 3 :
				// myCompiler.g:1:22: T__31
				{
				mT__31(); 

				}
				break;
			case 4 :
				// myCompiler.g:1:28: T__32
				{
				mT__32(); 

				}
				break;
			case 5 :
				// myCompiler.g:1:34: T__33
				{
				mT__33(); 

				}
				break;
			case 6 :
				// myCompiler.g:1:40: T__34
				{
				mT__34(); 

				}
				break;
			case 7 :
				// myCompiler.g:1:46: T__35
				{
				mT__35(); 

				}
				break;
			case 8 :
				// myCompiler.g:1:52: T__36
				{
				mT__36(); 

				}
				break;
			case 9 :
				// myCompiler.g:1:58: TEXT1
				{
				mTEXT1(); 

				}
				break;
			case 10 :
				// myCompiler.g:1:64: TEXT2
				{
				mTEXT2(); 

				}
				break;
			case 11 :
				// myCompiler.g:1:70: TEXT3
				{
				mTEXT3(); 

				}
				break;
			case 12 :
				// myCompiler.g:1:76: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 13 :
				// myCompiler.g:1:82: INT
				{
				mINT(); 

				}
				break;
			case 14 :
				// myCompiler.g:1:86: CHAR
				{
				mCHAR(); 

				}
				break;
			case 15 :
				// myCompiler.g:1:91: ADD
				{
				mADD(); 

				}
				break;
			case 16 :
				// myCompiler.g:1:95: SUB_OR_UNARY
				{
				mSUB_OR_UNARY(); 

				}
				break;
			case 17 :
				// myCompiler.g:1:108: MUL
				{
				mMUL(); 

				}
				break;
			case 18 :
				// myCompiler.g:1:112: DIV
				{
				mDIV(); 

				}
				break;
			case 19 :
				// myCompiler.g:1:116: PRINTF
				{
				mPRINTF(); 

				}
				break;
			case 20 :
				// myCompiler.g:1:123: WHILE
				{
				mWHILE(); 

				}
				break;
			case 21 :
				// myCompiler.g:1:129: MAIN
				{
				mMAIN(); 

				}
				break;
			case 22 :
				// myCompiler.g:1:134: VOID
				{
				mVOID(); 

				}
				break;
			case 23 :
				// myCompiler.g:1:139: IF
				{
				mIF(); 

				}
				break;
			case 24 :
				// myCompiler.g:1:142: ELSE
				{
				mELSE(); 

				}
				break;
			case 25 :
				// myCompiler.g:1:147: FOR
				{
				mFOR(); 

				}
				break;
			case 26 :
				// myCompiler.g:1:151: RelationOP
				{
				mRelationOP(); 

				}
				break;
			case 27 :
				// myCompiler.g:1:162: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 28 :
				// myCompiler.g:1:173: Integer_constant
				{
				mInteger_constant(); 

				}
				break;
			case 29 :
				// myCompiler.g:1:190: Floating_point_constant
				{
				mFloating_point_constant(); 

				}
				break;
			case 30 :
				// myCompiler.g:1:214: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 31 :
				// myCompiler.g:1:229: WS
				{
				mWS(); 

				}
				break;
			case 32 :
				// myCompiler.g:1:232: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA15_eotS =
		"\6\uffff\1\32\3\uffff\3\27\3\uffff\1\45\5\27\2\uffff\1\53\3\uffff\1\62"+
		"\2\uffff\3\27\1\72\1\27\2\uffff\5\27\10\uffff\1\62\3\uffff\1\27\1\117"+
		"\1\120\1\uffff\6\27\10\uffff\1\62\1\60\3\uffff\1\27\2\uffff\1\136\2\27"+
		"\1\141\1\142\1\143\1\uffff\1\113\2\uffff\1\115\1\uffff\1\146\1\uffff\1"+
		"\27\1\150\3\uffff\2\60\1\uffff\1\151\2\uffff";
	static final String DFA15_eofS =
		"\152\uffff";
	static final String DFA15_minS =
		"\1\11\5\uffff\1\75\2\uffff\1\0\1\154\1\146\1\150\3\uffff\1\52\1\162\1"+
		"\150\1\141\1\157\1\154\2\uffff\1\56\2\uffff\1\0\1\42\2\0\1\157\1\162\1"+
		"\164\1\60\1\141\2\uffff\4\151\1\163\2\uffff\3\0\1\uffff\1\0\1\uffff\1"+
		"\0\1\45\2\0\1\141\2\60\1\uffff\1\162\1\156\1\154\1\156\1\144\1\145\1\0"+
		"\1\uffff\3\0\1\uffff\2\0\1\42\1\0\1\uffff\1\0\1\uffff\1\164\2\uffff\1"+
		"\60\1\164\1\145\3\60\6\0\1\60\1\uffff\1\146\1\60\3\uffff\2\0\1\uffff\1"+
		"\60\2\uffff";
	static final String DFA15_maxS =
		"\1\175\5\uffff\1\75\2\uffff\1\uffff\1\157\1\156\1\150\3\uffff\1\57\1\162"+
		"\1\150\1\141\1\157\1\154\2\uffff\1\71\2\uffff\1\uffff\1\42\2\uffff\1\157"+
		"\1\162\1\164\1\172\1\141\2\uffff\4\151\1\163\2\uffff\3\uffff\1\uffff\1"+
		"\uffff\1\uffff\1\uffff\1\146\2\uffff\1\141\2\172\1\uffff\1\162\1\156\1"+
		"\154\1\156\1\144\1\145\1\uffff\1\uffff\3\uffff\1\uffff\2\uffff\1\42\1"+
		"\uffff\1\uffff\1\uffff\1\uffff\1\164\2\uffff\1\172\1\164\1\145\3\172\6"+
		"\uffff\1\172\1\uffff\1\146\1\172\3\uffff\2\uffff\1\uffff\1\172\2\uffff";
	static final String DFA15_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\4\uffff\1\17\1\20\1\21\6"+
		"\uffff\1\32\1\33\1\uffff\1\37\1\6\11\uffff\1\40\1\22\5\uffff\1\34\1\35"+
		"\3\uffff\1\36\1\uffff\1\12\7\uffff\1\27\7\uffff\1\11\3\uffff\1\13\4\uffff"+
		"\1\11\1\uffff\1\13\1\uffff\1\31\1\15\15\uffff\1\16\2\uffff\1\25\1\26\1"+
		"\30\2\uffff\1\14\1\uffff\1\24\1\23";
	static final String DFA15_specialS =
		"\11\uffff\1\3\21\uffff\1\4\1\uffff\1\6\1\32\16\uffff\1\25\1\15\1\1\1\uffff"+
		"\1\20\1\uffff\1\12\1\uffff\1\27\1\22\12\uffff\1\24\1\uffff\1\5\1\31\1"+
		"\2\1\uffff\1\16\1\11\1\uffff\1\13\1\uffff\1\17\12\uffff\1\30\1\0\1\26"+
		"\1\10\1\21\1\7\7\uffff\1\14\1\23\4\uffff}>";
	static final String[] DFA15_transitionS = {
			"\2\31\2\uffff\1\31\22\uffff\1\31\1\26\1\11\3\uffff\1\1\1\uffff\1\2\1"+
			"\3\1\17\1\15\1\4\1\16\1\uffff\1\20\12\30\1\uffff\1\5\1\26\1\6\1\26\2"+
			"\uffff\32\27\4\uffff\1\27\1\uffff\2\27\1\14\1\27\1\25\1\12\2\27\1\13"+
			"\3\27\1\23\2\27\1\21\5\27\1\24\1\22\3\27\1\7\1\uffff\1\10",
			"",
			"",
			"",
			"",
			"",
			"\1\26",
			"",
			"",
			"\42\36\1\34\2\36\1\33\66\36\1\35\uffa3\36",
			"\1\37\2\uffff\1\40",
			"\1\42\7\uffff\1\41",
			"\1\43",
			"",
			"",
			"",
			"\1\44\4\uffff\1\44",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"",
			"",
			"\1\54\1\uffff\12\30",
			"",
			"",
			"\45\60\1\55\76\60\1\56\1\60\1\57\uff99\60",
			"\1\61",
			"\42\66\1\63\2\66\1\64\1\66\1\65\64\66\1\65\5\66\1\65\3\66\1\65\7\66"+
			"\1\65\3\66\1\65\1\66\1\65\uff8b\66",
			"\42\36\1\34\2\36\1\33\66\36\1\35\uffa3\36",
			"\1\67",
			"\1\70",
			"\1\71",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\73",
			"",
			"",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"",
			"",
			"\42\36\1\34\2\36\1\33\66\36\1\35\uffa3\36",
			"\42\104\1\102\2\104\1\101\66\104\1\103\uffa3\104",
			"\42\110\1\106\2\110\1\105\66\110\1\107\uffa3\110",
			"",
			"\42\66\1\111\2\66\1\64\uffda\66",
			"",
			"\42\60\1\112\uffdd\60",
			"\1\114\76\uffff\1\113\1\uffff\1\115",
			"\42\36\1\34\2\36\1\33\66\36\1\35\uffa3\36",
			"\42\66\1\111\2\66\1\64\uffda\66",
			"\1\116",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\45\60\1\127\uffda\60",
			"",
			"\42\113\1\130\4\113\1\131\64\113\1\131\5\113\1\131\3\113\1\131\7\113"+
			"\1\131\3\113\1\131\1\113\1\131\uff8b\113",
			"\42\104\1\102\2\104\1\101\66\104\1\103\uffa3\104",
			"\45\60\1\132\uffda\60",
			"",
			"\42\115\1\133\4\115\1\134\64\115\1\134\5\115\1\134\3\115\1\134\7\115"+
			"\1\134\3\115\1\134\1\115\1\134\uff8b\115",
			"\42\110\1\106\2\110\1\105\66\110\1\107\uffa3\110",
			"\1\61",
			"\42\66\1\111\2\66\1\64\uffda\66",
			"",
			"\42\66\1\111\2\66\1\64\uffda\66",
			"",
			"\1\135",
			"",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\137",
			"\1\140",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\42\104\1\102\2\104\1\101\66\104\1\103\uffa3\104",
			"\42\60\1\144\uffdd\60",
			"\42\104\1\102\2\104\1\101\66\104\1\103\uffa3\104",
			"\42\110\1\106\2\110\1\105\66\110\1\107\uffa3\110",
			"\42\60\1\145\uffdd\60",
			"\42\110\1\106\2\110\1\105\66\110\1\107\uffa3\110",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\1\147",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"",
			"",
			"\0\113",
			"\0\115",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			""
	};

	static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
	static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
	static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
	static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
	static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
	static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
	static final short[][] DFA15_transition;

	static {
		int numStates = DFA15_transitionS.length;
		DFA15_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
		}
	}

	protected class DFA15 extends DFA {

		public DFA15(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 15;
			this.eot = DFA15_eot;
			this.eof = DFA15_eof;
			this.min = DFA15_min;
			this.max = DFA15_max;
			this.accept = DFA15_accept;
			this.special = DFA15_special;
			this.transition = DFA15_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | TEXT1 | TEXT2 | TEXT3 | FLOAT | INT | CHAR | ADD | SUB_OR_UNARY | MUL | DIV | PRINTF | WHILE | MAIN | VOID | IF | ELSE | FOR | RelationOP | Identifier | Integer_constant | Floating_point_constant | STRING_LITERAL | WS | COMMENT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA15_88 = input.LA(1);
						s = -1;
						if ( (LA15_88=='\"') ) {s = 100;}
						else if ( ((LA15_88 >= '\u0000' && LA15_88 <= '!')||(LA15_88 >= '#' && LA15_88 <= '\uFFFF')) ) {s = 48;}
						else s = 75;
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA15_47 = input.LA(1);
						s = -1;
						if ( (LA15_47=='%') ) {s = 69;}
						else if ( (LA15_47=='\"') ) {s = 70;}
						else if ( (LA15_47=='\\') ) {s = 71;}
						else if ( ((LA15_47 >= '\u0000' && LA15_47 <= '!')||(LA15_47 >= '#' && LA15_47 <= '$')||(LA15_47 >= '&' && LA15_47 <= '[')||(LA15_47 >= ']' && LA15_47 <= '\uFFFF')) ) {s = 72;}
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA15_69 = input.LA(1);
						s = -1;
						if ( (LA15_69=='%') ) {s = 90;}
						else if ( ((LA15_69 >= '\u0000' && LA15_69 <= '$')||(LA15_69 >= '&' && LA15_69 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;
					case 3 : 
						int LA15_9 = input.LA(1);
						s = -1;
						if ( (LA15_9=='%') ) {s = 27;}
						else if ( (LA15_9=='\"') ) {s = 28;}
						else if ( (LA15_9=='\\') ) {s = 29;}
						else if ( ((LA15_9 >= '\u0000' && LA15_9 <= '!')||(LA15_9 >= '#' && LA15_9 <= '$')||(LA15_9 >= '&' && LA15_9 <= '[')||(LA15_9 >= ']' && LA15_9 <= '\uFFFF')) ) {s = 30;}
						if ( s>=0 ) return s;
						break;
					case 4 : 
						int LA15_27 = input.LA(1);
						s = -1;
						if ( (LA15_27=='%') ) {s = 45;}
						else if ( (LA15_27=='d') ) {s = 46;}
						else if ( (LA15_27=='f') ) {s = 47;}
						else if ( ((LA15_27 >= '\u0000' && LA15_27 <= '$')||(LA15_27 >= '&' && LA15_27 <= 'c')||LA15_27=='e'||(LA15_27 >= 'g' && LA15_27 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;
					case 5 : 
						int LA15_67 = input.LA(1);
						s = -1;
						if ( (LA15_67=='\"') ) {s = 88;}
						else if ( (LA15_67=='\''||LA15_67=='\\'||LA15_67=='b'||LA15_67=='f'||LA15_67=='n'||LA15_67=='r'||LA15_67=='t') ) {s = 89;}
						else if ( ((LA15_67 >= '\u0000' && LA15_67 <= '!')||(LA15_67 >= '#' && LA15_67 <= '&')||(LA15_67 >= '(' && LA15_67 <= '[')||(LA15_67 >= ']' && LA15_67 <= 'a')||(LA15_67 >= 'c' && LA15_67 <= 'e')||(LA15_67 >= 'g' && LA15_67 <= 'm')||(LA15_67 >= 'o' && LA15_67 <= 'q')||LA15_67=='s'||(LA15_67 >= 'u' && LA15_67 <= '\uFFFF')) ) {s = 75;}
						if ( s>=0 ) return s;
						break;
					case 6 : 
						int LA15_29 = input.LA(1);
						s = -1;
						if ( (LA15_29=='\"') ) {s = 51;}
						else if ( (LA15_29=='%') ) {s = 52;}
						else if ( (LA15_29=='\''||LA15_29=='\\'||LA15_29=='b'||LA15_29=='f'||LA15_29=='n'||LA15_29=='r'||LA15_29=='t') ) {s = 53;}
						else if ( ((LA15_29 >= '\u0000' && LA15_29 <= '!')||(LA15_29 >= '#' && LA15_29 <= '$')||LA15_29=='&'||(LA15_29 >= '(' && LA15_29 <= '[')||(LA15_29 >= ']' && LA15_29 <= 'a')||(LA15_29 >= 'c' && LA15_29 <= 'e')||(LA15_29 >= 'g' && LA15_29 <= 'm')||(LA15_29 >= 'o' && LA15_29 <= 'q')||LA15_29=='s'||(LA15_29 >= 'u' && LA15_29 <= '\uFFFF')) ) {s = 54;}
						if ( s>=0 ) return s;
						break;
					case 7 : 
						int LA15_92 = input.LA(1);
						s = -1;
						if ( (LA15_92=='\"') ) {s = 70;}
						else if ( (LA15_92=='\\') ) {s = 71;}
						else if ( (LA15_92=='%') ) {s = 69;}
						else if ( ((LA15_92 >= '\u0000' && LA15_92 <= '!')||(LA15_92 >= '#' && LA15_92 <= '$')||(LA15_92 >= '&' && LA15_92 <= '[')||(LA15_92 >= ']' && LA15_92 <= '\uFFFF')) ) {s = 72;}
						if ( s>=0 ) return s;
						break;
					case 8 : 
						int LA15_90 = input.LA(1);
						s = -1;
						if ( (LA15_90=='\"') ) {s = 70;}
						else if ( (LA15_90=='%') ) {s = 69;}
						else if ( (LA15_90=='\\') ) {s = 71;}
						else if ( ((LA15_90 >= '\u0000' && LA15_90 <= '!')||(LA15_90 >= '#' && LA15_90 <= '$')||(LA15_90 >= '&' && LA15_90 <= '[')||(LA15_90 >= ']' && LA15_90 <= '\uFFFF')) ) {s = 72;}
						if ( s>=0 ) return s;
						break;
					case 9 : 
						int LA15_72 = input.LA(1);
						s = -1;
						if ( (LA15_72=='\"') ) {s = 70;}
						else if ( (LA15_72=='%') ) {s = 69;}
						else if ( (LA15_72=='\\') ) {s = 71;}
						else if ( ((LA15_72 >= '\u0000' && LA15_72 <= '!')||(LA15_72 >= '#' && LA15_72 <= '$')||(LA15_72 >= '&' && LA15_72 <= '[')||(LA15_72 >= ']' && LA15_72 <= '\uFFFF')) ) {s = 72;}
						if ( s>=0 ) return s;
						break;
					case 10 : 
						int LA15_51 = input.LA(1);
						s = -1;
						if ( (LA15_51=='\"') ) {s = 74;}
						else if ( ((LA15_51 >= '\u0000' && LA15_51 <= '!')||(LA15_51 >= '#' && LA15_51 <= '\uFFFF')) ) {s = 48;}
						else s = 50;
						if ( s>=0 ) return s;
						break;
					case 11 : 
						int LA15_74 = input.LA(1);
						s = -1;
						if ( (LA15_74=='%') ) {s = 52;}
						else if ( (LA15_74=='\"') ) {s = 73;}
						else if ( ((LA15_74 >= '\u0000' && LA15_74 <= '!')||(LA15_74 >= '#' && LA15_74 <= '$')||(LA15_74 >= '&' && LA15_74 <= '\uFFFF')) ) {s = 54;}
						else s = 48;
						if ( s>=0 ) return s;
						break;
					case 12 : 
						int LA15_100 = input.LA(1);
						s = -1;
						if ( ((LA15_100 >= '\u0000' && LA15_100 <= '\uFFFF')) ) {s = 75;}
						else s = 48;
						if ( s>=0 ) return s;
						break;
					case 13 : 
						int LA15_46 = input.LA(1);
						s = -1;
						if ( (LA15_46=='%') ) {s = 65;}
						else if ( (LA15_46=='\"') ) {s = 66;}
						else if ( (LA15_46=='\\') ) {s = 67;}
						else if ( ((LA15_46 >= '\u0000' && LA15_46 <= '!')||(LA15_46 >= '#' && LA15_46 <= '$')||(LA15_46 >= '&' && LA15_46 <= '[')||(LA15_46 >= ']' && LA15_46 <= '\uFFFF')) ) {s = 68;}
						if ( s>=0 ) return s;
						break;
					case 14 : 
						int LA15_71 = input.LA(1);
						s = -1;
						if ( (LA15_71=='\"') ) {s = 91;}
						else if ( (LA15_71=='\''||LA15_71=='\\'||LA15_71=='b'||LA15_71=='f'||LA15_71=='n'||LA15_71=='r'||LA15_71=='t') ) {s = 92;}
						else if ( ((LA15_71 >= '\u0000' && LA15_71 <= '!')||(LA15_71 >= '#' && LA15_71 <= '&')||(LA15_71 >= '(' && LA15_71 <= '[')||(LA15_71 >= ']' && LA15_71 <= 'a')||(LA15_71 >= 'c' && LA15_71 <= 'e')||(LA15_71 >= 'g' && LA15_71 <= 'm')||(LA15_71 >= 'o' && LA15_71 <= 'q')||LA15_71=='s'||(LA15_71 >= 'u' && LA15_71 <= '\uFFFF')) ) {s = 77;}
						if ( s>=0 ) return s;
						break;
					case 15 : 
						int LA15_76 = input.LA(1);
						s = -1;
						if ( (LA15_76=='%') ) {s = 52;}
						else if ( (LA15_76=='\"') ) {s = 73;}
						else if ( ((LA15_76 >= '\u0000' && LA15_76 <= '!')||(LA15_76 >= '#' && LA15_76 <= '$')||(LA15_76 >= '&' && LA15_76 <= '\uFFFF')) ) {s = 54;}
						if ( s>=0 ) return s;
						break;
					case 16 : 
						int LA15_49 = input.LA(1);
						s = -1;
						if ( (LA15_49=='%') ) {s = 52;}
						else if ( (LA15_49=='\"') ) {s = 73;}
						else if ( ((LA15_49 >= '\u0000' && LA15_49 <= '!')||(LA15_49 >= '#' && LA15_49 <= '$')||(LA15_49 >= '&' && LA15_49 <= '\uFFFF')) ) {s = 54;}
						if ( s>=0 ) return s;
						break;
					case 17 : 
						int LA15_91 = input.LA(1);
						s = -1;
						if ( (LA15_91=='\"') ) {s = 101;}
						else if ( ((LA15_91 >= '\u0000' && LA15_91 <= '!')||(LA15_91 >= '#' && LA15_91 <= '\uFFFF')) ) {s = 48;}
						else s = 77;
						if ( s>=0 ) return s;
						break;
					case 18 : 
						int LA15_54 = input.LA(1);
						s = -1;
						if ( (LA15_54=='%') ) {s = 52;}
						else if ( (LA15_54=='\"') ) {s = 73;}
						else if ( ((LA15_54 >= '\u0000' && LA15_54 <= '!')||(LA15_54 >= '#' && LA15_54 <= '$')||(LA15_54 >= '&' && LA15_54 <= '\uFFFF')) ) {s = 54;}
						if ( s>=0 ) return s;
						break;
					case 19 : 
						int LA15_101 = input.LA(1);
						s = -1;
						if ( ((LA15_101 >= '\u0000' && LA15_101 <= '\uFFFF')) ) {s = 77;}
						else s = 48;
						if ( s>=0 ) return s;
						break;
					case 20 : 
						int LA15_65 = input.LA(1);
						s = -1;
						if ( (LA15_65=='%') ) {s = 87;}
						else if ( ((LA15_65 >= '\u0000' && LA15_65 <= '$')||(LA15_65 >= '&' && LA15_65 <= '\uFFFF')) ) {s = 48;}
						if ( s>=0 ) return s;
						break;
					case 21 : 
						int LA15_45 = input.LA(1);
						s = -1;
						if ( (LA15_45=='%') ) {s = 27;}
						else if ( (LA15_45=='\"') ) {s = 28;}
						else if ( (LA15_45=='\\') ) {s = 29;}
						else if ( ((LA15_45 >= '\u0000' && LA15_45 <= '!')||(LA15_45 >= '#' && LA15_45 <= '$')||(LA15_45 >= '&' && LA15_45 <= '[')||(LA15_45 >= ']' && LA15_45 <= '\uFFFF')) ) {s = 30;}
						if ( s>=0 ) return s;
						break;
					case 22 : 
						int LA15_89 = input.LA(1);
						s = -1;
						if ( (LA15_89=='\"') ) {s = 66;}
						else if ( (LA15_89=='\\') ) {s = 67;}
						else if ( (LA15_89=='%') ) {s = 65;}
						else if ( ((LA15_89 >= '\u0000' && LA15_89 <= '!')||(LA15_89 >= '#' && LA15_89 <= '$')||(LA15_89 >= '&' && LA15_89 <= '[')||(LA15_89 >= ']' && LA15_89 <= '\uFFFF')) ) {s = 68;}
						if ( s>=0 ) return s;
						break;
					case 23 : 
						int LA15_53 = input.LA(1);
						s = -1;
						if ( (LA15_53=='\"') ) {s = 28;}
						else if ( (LA15_53=='\\') ) {s = 29;}
						else if ( (LA15_53=='%') ) {s = 27;}
						else if ( ((LA15_53 >= '\u0000' && LA15_53 <= '!')||(LA15_53 >= '#' && LA15_53 <= '$')||(LA15_53 >= '&' && LA15_53 <= '[')||(LA15_53 >= ']' && LA15_53 <= '\uFFFF')) ) {s = 30;}
						if ( s>=0 ) return s;
						break;
					case 24 : 
						int LA15_87 = input.LA(1);
						s = -1;
						if ( (LA15_87=='\"') ) {s = 66;}
						else if ( (LA15_87=='%') ) {s = 65;}
						else if ( (LA15_87=='\\') ) {s = 67;}
						else if ( ((LA15_87 >= '\u0000' && LA15_87 <= '!')||(LA15_87 >= '#' && LA15_87 <= '$')||(LA15_87 >= '&' && LA15_87 <= '[')||(LA15_87 >= ']' && LA15_87 <= '\uFFFF')) ) {s = 68;}
						if ( s>=0 ) return s;
						break;
					case 25 : 
						int LA15_68 = input.LA(1);
						s = -1;
						if ( (LA15_68=='\"') ) {s = 66;}
						else if ( (LA15_68=='%') ) {s = 65;}
						else if ( (LA15_68=='\\') ) {s = 67;}
						else if ( ((LA15_68 >= '\u0000' && LA15_68 <= '!')||(LA15_68 >= '#' && LA15_68 <= '$')||(LA15_68 >= '&' && LA15_68 <= '[')||(LA15_68 >= ']' && LA15_68 <= '\uFFFF')) ) {s = 68;}
						if ( s>=0 ) return s;
						break;
					case 26 : 
						int LA15_30 = input.LA(1);
						s = -1;
						if ( (LA15_30=='%') ) {s = 27;}
						else if ( (LA15_30=='\"') ) {s = 28;}
						else if ( (LA15_30=='\\') ) {s = 29;}
						else if ( ((LA15_30 >= '\u0000' && LA15_30 <= '!')||(LA15_30 >= '#' && LA15_30 <= '$')||(LA15_30 >= '&' && LA15_30 <= '[')||(LA15_30 >= ']' && LA15_30 <= '\uFFFF')) ) {s = 30;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 15, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
