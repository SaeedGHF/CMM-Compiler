// Generated from F:/Phase2/src/main/grammar\Cmm.g4 by ANTLR 4.9.2
package parsers;

     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.struct.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import java.util.*;
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, RETURN=2, VOID=3, SIZE=4, DISPLAY=5, APPEND=6, IF=7, ELSE=8, PLUS=9, 
		MINUS=10, MULT=11, DIVIDE=12, EQUAL=13, ARROW=14, GREATER_THAN=15, LESS_THAN=16, 
		AND=17, OR=18, NOT=19, TRUE=20, FALSE=21, BEGIN=22, END=23, INT=24, BOOL=25, 
		LIST=26, STRUCT=27, FPTR=28, GET=29, SET=30, WHILE=31, DO=32, ASSIGN=33, 
		SHARP=34, LPAR=35, RPAR=36, LBRACK=37, RBRACK=38, COMMA=39, DOT=40, SEMICOLON=41, 
		NEWLINE=42, INT_VALUE=43, IDENTIFIER=44, COMMENT=45, WS=46;
	public static final int
		RULE_cmm = 0, RULE_program = 1, RULE_main = 2, RULE_structDeclaration = 3, 
		RULE_singleVarWithGetAndSet = 4, RULE_singleStatementStructBody = 5, RULE_structBody = 6, 
		RULE_getBody = 7, RULE_setBody = 8, RULE_functionDeclaration = 9, RULE_functionArgsDec = 10, 
		RULE_functionArguments = 11, RULE_body = 12, RULE_loopCondBody = 13, RULE_blockStatement = 14, 
		RULE_varDecStatement = 15, RULE_functionCallStmt = 16, RULE_returnStatement = 17, 
		RULE_ifStatement = 18, RULE_elseStatement = 19, RULE_loopStatement = 20, 
		RULE_whileLoopStatement = 21, RULE_doWhileLoopStatement = 22, RULE_displayStatement = 23, 
		RULE_assignmentStatement = 24, RULE_singleStatement = 25, RULE_expression = 26, 
		RULE_orExpression = 27, RULE_andExpression = 28, RULE_equalityExpression = 29, 
		RULE_relationalExpression = 30, RULE_additiveExpression = 31, RULE_multiplicativeExpression = 32, 
		RULE_preUnaryExpression = 33, RULE_accessExpression = 34, RULE_otherExpression = 35, 
		RULE_size = 36, RULE_append = 37, RULE_value = 38, RULE_boolValue = 39, 
		RULE_identifier = 40, RULE_type = 41, RULE_fptrType = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"cmm", "program", "main", "structDeclaration", "singleVarWithGetAndSet", 
			"singleStatementStructBody", "structBody", "getBody", "setBody", "functionDeclaration", 
			"functionArgsDec", "functionArguments", "body", "loopCondBody", "blockStatement", 
			"varDecStatement", "functionCallStmt", "returnStatement", "ifStatement", 
			"elseStatement", "loopStatement", "whileLoopStatement", "doWhileLoopStatement", 
			"displayStatement", "assignmentStatement", "singleStatement", "expression", 
			"orExpression", "andExpression", "equalityExpression", "relationalExpression", 
			"additiveExpression", "multiplicativeExpression", "preUnaryExpression", 
			"accessExpression", "otherExpression", "size", "append", "value", "boolValue", 
			"identifier", "type", "fptrType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'return'", "'void'", "'size'", "'display'", "'append'", 
			"'if'", "'else'", "'+'", "'-'", "'*'", "'/'", "'=='", "'->'", "'>'", 
			"'<'", "'&'", "'|'", "'~'", "'true'", "'false'", "'begin'", "'end'", 
			"'int'", "'bool'", "'list'", "'struct'", "'fptr'", "'get'", "'set'", 
			"'while'", "'do'", "'='", "'#'", "'('", "')'", "'['", "']'", "','", "'.'", 
			"';'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "RETURN", "VOID", "SIZE", "DISPLAY", "APPEND", "IF", "ELSE", 
			"PLUS", "MINUS", "MULT", "DIVIDE", "EQUAL", "ARROW", "GREATER_THAN", 
			"LESS_THAN", "AND", "OR", "NOT", "TRUE", "FALSE", "BEGIN", "END", "INT", 
			"BOOL", "LIST", "STRUCT", "FPTR", "GET", "SET", "WHILE", "DO", "ASSIGN", 
			"SHARP", "LPAR", "RPAR", "LBRACK", "RBRACK", "COMMA", "DOT", "SEMICOLON", 
			"NEWLINE", "INT_VALUE", "IDENTIFIER", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CmmContext extends ParserRuleContext {
		public Program cmmProgram;
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public CmmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterCmm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitCmm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitCmm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmmContext cmm() throws RecognitionException {
		CmmContext _localctx = new CmmContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_cmm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(86);
				match(NEWLINE);
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			((CmmContext)_localctx).p = program();
			((CmmContext)_localctx).cmmProgram =  ((CmmContext)_localctx).p.programRet;
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(94);
				match(NEWLINE);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public StructDeclarationContext s;
		public FunctionDeclarationContext f;
		public MainContext m;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<StructDeclarationContext> structDeclaration() {
			return getRuleContexts(StructDeclarationContext.class);
		}
		public StructDeclarationContext structDeclaration(int i) {
			return getRuleContext(StructDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).programRet =  new Program();
			     int line = 1;
			     _localctx.programRet.setLine(line);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					((ProgramContext)_localctx).s = structDeclaration();
					_localctx.programRet.addStruct(((ProgramContext)_localctx).s.structDeclarationRet);
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << BOOL) | (1L << LIST) | (1L << STRUCT) | (1L << FPTR))) != 0)) {
				{
				{
				setState(111);
				((ProgramContext)_localctx).f = functionDeclaration();
				_localctx.programRet.addFunction(((ProgramContext)_localctx).f.functionDeclarationRet);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			((ProgramContext)_localctx).m = main();
			_localctx.programRet.setMain(((ProgramContext)_localctx).m.mainRet);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public MainDeclaration mainRet;
		public Token MAIN;
		public BodyContext body;
		public TerminalNode MAIN() { return getToken(CmmParser.MAIN, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			((MainContext)_localctx).MAIN = match(MAIN);
			setState(123);
			match(LPAR);
			setState(124);
			match(RPAR);
			setState(125);
			((MainContext)_localctx).body = body();

			        MainDeclaration dec = new MainDeclaration();
			        dec.setLine((((MainContext)_localctx).MAIN!=null?((MainContext)_localctx).MAIN.getLine():0));
			        dec.setBody(((MainContext)_localctx).body.stmt);
			        ((MainContext)_localctx).mainRet =  dec;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public StructDeclaration structDeclarationRet;
		public Token STRUCT;
		public IdentifierContext identifier;
		public Token BEGIN;
		public StructBodyContext structBody;
		public SingleStatementStructBodyContext singleStatementStructBody;
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public StructBodyContext structBody() {
			return getRuleContext(StructBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public SingleStatementStructBodyContext singleStatementStructBody() {
			return getRuleContext(SingleStatementStructBodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((StructDeclarationContext)_localctx).STRUCT = match(STRUCT);
			setState(129);
			((StructDeclarationContext)_localctx).identifier = identifier();

			        StructDeclaration dec = new StructDeclaration();
			        dec.setLine((((StructDeclarationContext)_localctx).STRUCT!=null?((StructDeclarationContext)_localctx).STRUCT.getLine():0));
			        dec.setStructName(((StructDeclarationContext)_localctx).identifier.ID);
			    
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(131);
				((StructDeclarationContext)_localctx).BEGIN = match(BEGIN);
				setState(132);
				((StructDeclarationContext)_localctx).structBody = structBody();

				        BlockStmt block = new BlockStmt();
				        block.setLine((((StructDeclarationContext)_localctx).BEGIN!=null?((StructDeclarationContext)_localctx).BEGIN.getLine():0));
				        block.setStatements(((StructDeclarationContext)_localctx).structBody.stmt);
				        Statement stmt = block;
				        dec.setBody(stmt);
				    
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(134);
					match(NEWLINE);
					}
					}
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(139);
				match(END);
				}
				}
				break;
			case NEWLINE:
				{
				{
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141);
					match(NEWLINE);
					}
					}
					setState(144); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(146);
				((StructDeclarationContext)_localctx).singleStatementStructBody = singleStatementStructBody();

				        dec.setBody(((StructDeclarationContext)_localctx).singleStatementStructBody.stmt);
				    
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(148);
					match(SEMICOLON);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				match(NEWLINE);
				}
				}
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			((StructDeclarationContext)_localctx).structDeclarationRet =  dec;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleVarWithGetAndSetContext extends ParserRuleContext {
		public Statement stmt;
		public TypeContext type;
		public IdentifierContext identifier;
		public FunctionArgsDecContext functionArgsDec;
		public SetBodyContext setBody;
		public GetBodyContext getBody;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionArgsDecContext functionArgsDec() {
			return getRuleContext(FunctionArgsDecContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public SetBodyContext setBody() {
			return getRuleContext(SetBodyContext.class,0);
		}
		public GetBodyContext getBody() {
			return getRuleContext(GetBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public SingleVarWithGetAndSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleVarWithGetAndSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleVarWithGetAndSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleVarWithGetAndSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleVarWithGetAndSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleVarWithGetAndSetContext singleVarWithGetAndSet() throws RecognitionException {
		SingleVarWithGetAndSetContext _localctx = new SingleVarWithGetAndSetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleVarWithGetAndSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			((SingleVarWithGetAndSetContext)_localctx).type = type();
			setState(161);
			((SingleVarWithGetAndSetContext)_localctx).identifier = identifier();

			        SetGetVarDeclaration dec = new SetGetVarDeclaration();
			        dec.setLine(((SingleVarWithGetAndSetContext)_localctx).identifier.ID.getLine());
			        dec.setVarName(((SingleVarWithGetAndSetContext)_localctx).identifier.ID);
			        dec.setVarType(((SingleVarWithGetAndSetContext)_localctx).type.varType);
			    
			setState(163);
			((SingleVarWithGetAndSetContext)_localctx).functionArgsDec = functionArgsDec();

			        dec.setArgs(((SingleVarWithGetAndSetContext)_localctx).functionArgsDec.args);
			    
			setState(165);
			match(BEGIN);
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				match(NEWLINE);
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(171);
			((SingleVarWithGetAndSetContext)_localctx).setBody = setBody();

			        dec.setSetterBody(((SingleVarWithGetAndSetContext)_localctx).setBody.stmt);
			    
			setState(173);
			((SingleVarWithGetAndSetContext)_localctx).getBody = getBody();

			        dec.setGetterBody(((SingleVarWithGetAndSetContext)_localctx).getBody.stmt);
			    
			setState(175);
			match(END);

			        ((SingleVarWithGetAndSetContext)_localctx).stmt =  dec;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementStructBodyContext extends ParserRuleContext {
		public Statement stmt;
		public VarDecStatementContext varDecStatement;
		public SingleVarWithGetAndSetContext singleVarWithGetAndSet;
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public SingleVarWithGetAndSetContext singleVarWithGetAndSet() {
			return getRuleContext(SingleVarWithGetAndSetContext.class,0);
		}
		public SingleStatementStructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatementStructBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleStatementStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleStatementStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleStatementStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementStructBodyContext singleStatementStructBody() throws RecognitionException {
		SingleStatementStructBodyContext _localctx = new SingleStatementStructBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_singleStatementStructBody);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((SingleStatementStructBodyContext)_localctx).varDecStatement = varDecStatement();

				        ((SingleStatementStructBodyContext)_localctx).stmt =  ((SingleStatementStructBodyContext)_localctx).varDecStatement.stmt;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				((SingleStatementStructBodyContext)_localctx).singleVarWithGetAndSet = singleVarWithGetAndSet();

				        ((SingleStatementStructBodyContext)_localctx).stmt =  ((SingleStatementStructBodyContext)_localctx).singleVarWithGetAndSet.stmt;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructBodyContext extends ParserRuleContext {
		public ArrayList<Statement> stmt;
		public SingleStatementStructBodyContext singleStatementStructBody;
		public List<SingleStatementStructBodyContext> singleStatementStructBody() {
			return getRuleContexts(SingleStatementStructBodyContext.class);
		}
		public SingleStatementStructBodyContext singleStatementStructBody(int i) {
			return getRuleContext(SingleStatementStructBodyContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CmmParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CmmParser.SEMICOLON, i);
		}
		public StructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructBodyContext structBody() throws RecognitionException {
		StructBodyContext _localctx = new StructBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			ArrayList<Statement> statements = new ArrayList<Statement>();
			setState(206); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(188); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(187);
						match(NEWLINE);
						}
						}
						setState(190); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(198);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(192);
							((StructBodyContext)_localctx).singleStatementStructBody = singleStatementStructBody();

							        statements.add(((StructBodyContext)_localctx).singleStatementStructBody.stmt);
							    
							setState(194);
							match(SEMICOLON);
							}
							} 
						}
						setState(200);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(201);
					((StructBodyContext)_localctx).singleStatementStructBody = singleStatementStructBody();

					        statements.add(((StructBodyContext)_localctx).singleStatementStructBody.stmt);
					    
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(203);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(208); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			((StructBodyContext)_localctx).stmt =  statements;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetBodyContext extends ParserRuleContext {
		public Statement stmt;
		public BodyContext body;
		public TerminalNode GET() { return getToken(CmmParser.GET, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public GetBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterGetBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitGetBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitGetBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetBodyContext getBody() throws RecognitionException {
		GetBodyContext _localctx = new GetBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_getBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(GET);
			setState(213);
			((GetBodyContext)_localctx).body = body();

			        ((GetBodyContext)_localctx).stmt =  ((GetBodyContext)_localctx).body.stmt;
			    
			setState(216); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(215);
				match(NEWLINE);
				}
				}
				setState(218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetBodyContext extends ParserRuleContext {
		public Statement stmt;
		public BodyContext body;
		public TerminalNode SET() { return getToken(CmmParser.SET, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public SetBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSetBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSetBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSetBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetBodyContext setBody() throws RecognitionException {
		SetBodyContext _localctx = new SetBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_setBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(SET);
			setState(221);
			((SetBodyContext)_localctx).body = body();

			        ((SetBodyContext)_localctx).stmt =  ((SetBodyContext)_localctx).body.stmt;
			    
			setState(224); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(223);
				match(NEWLINE);
				}
				}
				setState(226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclaration functionDeclarationRet;
		public TypeContext type;
		public IdentifierContext identifier;
		public FunctionArgsDecContext functionArgsDec;
		public BodyContext body;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionArgsDecContext functionArgsDec() {
			return getRuleContext(FunctionArgsDecContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			FunctionDeclaration dec = new FunctionDeclaration();
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				setState(229);
				((FunctionDeclarationContext)_localctx).type = type();
				dec.setReturnType(((FunctionDeclarationContext)_localctx).type.varType);
				}
				break;
			case VOID:
				{
				setState(232);
				match(VOID);

				        Type voidType = new VoidType();
				        dec.setReturnType(voidType);
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(236);
			((FunctionDeclarationContext)_localctx).identifier = identifier();

			        dec.setFunctionName(((FunctionDeclarationContext)_localctx).identifier.ID);
			        dec.setLine(((FunctionDeclarationContext)_localctx).identifier.ID.getLine());
			    
			setState(238);
			((FunctionDeclarationContext)_localctx).functionArgsDec = functionArgsDec();

			        dec.setArgs(((FunctionDeclarationContext)_localctx).functionArgsDec.args);
			    
			setState(240);
			((FunctionDeclarationContext)_localctx).body = body();

			        dec.setBody(((FunctionDeclarationContext)_localctx).body.stmt);
			    
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				match(NEWLINE);
				}
				}
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			((FunctionDeclarationContext)_localctx).functionDeclarationRet =  dec;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgsDecContext extends ParserRuleContext {
		public ArrayList<VariableDeclaration> args;
		public TypeContext type;
		public IdentifierContext identifier;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionArgsDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgsDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionArgsDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionArgsDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionArgsDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgsDecContext functionArgsDec() throws RecognitionException {
		FunctionArgsDecContext _localctx = new FunctionArgsDecContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionArgsDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			ArrayList<VariableDeclaration> a = new ArrayList<VariableDeclaration>();
			setState(250);
			match(LPAR);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << LIST) | (1L << STRUCT) | (1L << FPTR))) != 0)) {
				{
				setState(251);
				((FunctionArgsDecContext)_localctx).type = type();
				setState(252);
				((FunctionArgsDecContext)_localctx).identifier = identifier();

				        VariableDeclaration dec = new VariableDeclaration(((FunctionArgsDecContext)_localctx).identifier.ID, ((FunctionArgsDecContext)_localctx).type.varType);
				        a.add(dec);
				    
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(254);
					match(COMMA);
					setState(255);
					((FunctionArgsDecContext)_localctx).type = type();
					setState(256);
					((FunctionArgsDecContext)_localctx).identifier = identifier();

					        VariableDeclaration dec_ = new VariableDeclaration(((FunctionArgsDecContext)_localctx).identifier.ID, ((FunctionArgsDecContext)_localctx).type.varType);
					        a.add(dec_);
					    
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(266);
			match(RPAR);

			        ((FunctionArgsDecContext)_localctx).args =  a;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public ArrayList<Expression> args;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionArgumentsContext)_localctx).args =  new ArrayList<Expression>();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZE) | (1L << APPEND) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(270);
				((FunctionArgumentsContext)_localctx).expression = expression();
				_localctx.args.add(((FunctionArgumentsContext)_localctx).expression.exp);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(272);
					match(COMMA);
					setState(273);
					((FunctionArgumentsContext)_localctx).expression = expression();
					_localctx.args.add(((FunctionArgumentsContext)_localctx).expression.exp);
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public Statement stmt;
		public BlockStatementContext blockStatement;
		public SingleStatementContext singleStatement;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				setState(283);
				((BodyContext)_localctx).blockStatement = blockStatement();
				((BodyContext)_localctx).stmt =  ((BodyContext)_localctx).blockStatement.stmt;
				}
				break;
			case NEWLINE:
				{
				{
				setState(287); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(286);
					match(NEWLINE);
					}
					}
					setState(289); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(291);
				((BodyContext)_localctx).singleStatement = singleStatement();
				((BodyContext)_localctx).stmt =  ((BodyContext)_localctx).singleStatement.stmt;
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(293);
					match(SEMICOLON);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopCondBodyContext extends ParserRuleContext {
		public Statement stmt;
		public BlockStatementContext blockStatement;
		public SingleStatementContext singleStatement;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public LoopCondBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopCondBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterLoopCondBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitLoopCondBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitLoopCondBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopCondBodyContext loopCondBody() throws RecognitionException {
		LoopCondBodyContext _localctx = new LoopCondBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loopCondBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				setState(298);
				((LoopCondBodyContext)_localctx).blockStatement = blockStatement();
				((LoopCondBodyContext)_localctx).stmt =  ((LoopCondBodyContext)_localctx).blockStatement.stmt;
				}
				break;
			case NEWLINE:
				{
				{
				setState(302); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(301);
					match(NEWLINE);
					}
					}
					setState(304); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(306);
				((LoopCondBodyContext)_localctx).singleStatement = singleStatement();
				((LoopCondBodyContext)_localctx).stmt =  ((LoopCondBodyContext)_localctx).singleStatement.stmt;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public Statement stmt;
		public Token BEGIN;
		public SingleStatementContext singleStatement;
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CmmParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CmmParser.SEMICOLON, i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_blockStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			((BlockStatementContext)_localctx).BEGIN = match(BEGIN);

			        BlockStmt block = new BlockStmt();
			        block.setLine((((BlockStatementContext)_localctx).BEGIN!=null?((BlockStatementContext)_localctx).BEGIN.getLine():0));
			    
			setState(332); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(314); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(313);
						match(NEWLINE);
						}
						}
						setState(316); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(324);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(318);
							((BlockStatementContext)_localctx).singleStatement = singleStatement();
							setState(319);
							match(SEMICOLON);

							        block.addStatement(((BlockStatementContext)_localctx).singleStatement.stmt);
							    
							}
							} 
						}
						setState(326);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					}
					setState(327);
					((BlockStatementContext)_localctx).singleStatement = singleStatement();

					        block.addStatement(((BlockStatementContext)_localctx).singleStatement.stmt);
					    
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(329);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(334); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

			        ((BlockStatementContext)_localctx).stmt =  block;
			    
			setState(338); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(337);
				match(NEWLINE);
				}
				}
				setState(340); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(342);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecStatementContext extends ParserRuleContext {
		public Statement stmt;
		public TypeContext type;
		public IdentifierContext identifier;
		public OrExpressionContext orExpression;
		public OrExpressionContext e_;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(CmmParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(CmmParser.ASSIGN, i);
		}
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public VarDecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVarDecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVarDecStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVarDecStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecStatementContext varDecStatement() throws RecognitionException {
		VarDecStatementContext _localctx = new VarDecStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varDecStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			((VarDecStatementContext)_localctx).type = type();
			setState(345);
			((VarDecStatementContext)_localctx).identifier = identifier();

			        VarDecStmt decStmt = new VarDecStmt();
			        decStmt.setLine(((VarDecStatementContext)_localctx).identifier.ID.getLine());
			        VariableDeclaration varDec = new VariableDeclaration(((VarDecStatementContext)_localctx).identifier.ID, ((VarDecStatementContext)_localctx).type.varType);
			    
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(347);
				match(ASSIGN);
				setState(348);
				((VarDecStatementContext)_localctx).orExpression = orExpression();

				        varDec.setDefaultValue(((VarDecStatementContext)_localctx).orExpression.exp);
				    
				}
			}


			        decStmt.addVar(varDec);
			    
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(354);
				match(COMMA);
				setState(355);
				((VarDecStatementContext)_localctx).identifier = identifier();

				        VariableDeclaration varDec_ = new VariableDeclaration(((VarDecStatementContext)_localctx).identifier.ID, ((VarDecStatementContext)_localctx).type.varType);
				    
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(357);
					match(ASSIGN);
					setState(358);
					((VarDecStatementContext)_localctx).e_ = ((VarDecStatementContext)_localctx).orExpression = orExpression();

					        varDec_.setDefaultValue(((VarDecStatementContext)_localctx).e_.exp);
					    
					}
				}


				        decStmt.addVar(varDec_);
				    
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        ((VarDecStatementContext)_localctx).stmt =  decStmt;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStmtContext extends ParserRuleContext {
		public Statement stmt;
		public OtherExpressionContext otherExpression;
		public Token LPAR;
		public FunctionArgumentsContext functionArguments;
		public Token DOT;
		public IdentifierContext identifier;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> LPAR() { return getTokens(CmmParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(CmmParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(CmmParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(CmmParser.RPAR, i);
		}
		public List<TerminalNode> DOT() { return getTokens(CmmParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(CmmParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public FunctionCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStmtContext functionCallStmt() throws RecognitionException {
		FunctionCallStmtContext _localctx = new FunctionCallStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionCallStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			((FunctionCallStmtContext)_localctx).otherExpression = otherExpression();

			        Expression instance = ((FunctionCallStmtContext)_localctx).otherExpression.exp;
			    
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(385);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(374);
						((FunctionCallStmtContext)_localctx).LPAR = match(LPAR);

						        FunctionCall fc = new FunctionCall(instance);
						        fc.setLine((((FunctionCallStmtContext)_localctx).LPAR!=null?((FunctionCallStmtContext)_localctx).LPAR.getLine():0));
						    
						setState(376);
						((FunctionCallStmtContext)_localctx).functionArguments = functionArguments();
						fc.setArgs(((FunctionCallStmtContext)_localctx).functionArguments.args);
						setState(378);
						match(RPAR);

						        instance = fc;
						    
						}
						}
						break;
					case DOT:
						{
						{
						setState(381);
						((FunctionCallStmtContext)_localctx).DOT = match(DOT);
						setState(382);
						((FunctionCallStmtContext)_localctx).identifier = identifier();

						        StructAccess sa = new StructAccess(instance, ((FunctionCallStmtContext)_localctx).identifier.ID);
						        sa.setLine((((FunctionCallStmtContext)_localctx).DOT!=null?((FunctionCallStmtContext)_localctx).DOT.getLine():0));
						        instance = sa;
						    
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			{
			setState(390);
			((FunctionCallStmtContext)_localctx).LPAR = match(LPAR);
			setState(391);
			((FunctionCallStmtContext)_localctx).functionArguments = functionArguments();
			setState(392);
			match(RPAR);
			}

			        FunctionCall call = new FunctionCall(instance);
			        call.setLine((((FunctionCallStmtContext)_localctx).LPAR!=null?((FunctionCallStmtContext)_localctx).LPAR.getLine():0));
			        call.setArgs(((FunctionCallStmtContext)_localctx).functionArguments.args);
			        ((FunctionCallStmtContext)_localctx).stmt =  new FunctionCallStmt(call);
			        _localctx.stmt.setLine((((FunctionCallStmtContext)_localctx).LPAR!=null?((FunctionCallStmtContext)_localctx).LPAR.getLine():0));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public Statement stmt;
		public ExpressionContext expression;
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(RETURN);

			        ReturnStmt ret = new ReturnStmt();
			    
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZE) | (1L << APPEND) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(398);
				((ReturnStatementContext)_localctx).expression = expression();
				ret.setReturnedExpr(((ReturnStatementContext)_localctx).expression.exp);
				}
			}


			        ((ReturnStatementContext)_localctx).stmt =  ret;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public Statement stmt;
		public ExpressionContext expression;
		public LoopCondBodyContext loopCondBody;
		public BodyContext body;
		public ElseStatementContext elseStatement;
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			match(IF);
			setState(406);
			((IfStatementContext)_localctx).expression = expression();
			ConditionalStmt con = new ConditionalStmt(((IfStatementContext)_localctx).expression.exp);
			setState(416);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(408);
				((IfStatementContext)_localctx).loopCondBody = loopCondBody();
				con.setThenBody(((IfStatementContext)_localctx).loopCondBody.stmt);
				}
				break;
			case 2:
				{
				setState(411);
				((IfStatementContext)_localctx).body = body();
				con.setThenBody(((IfStatementContext)_localctx).body.stmt);
				setState(413);
				((IfStatementContext)_localctx).elseStatement = elseStatement();
				con.setElseBody(((IfStatementContext)_localctx).elseStatement.stmt);
				}
				break;
			}
			((IfStatementContext)_localctx).stmt =  con;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public Statement stmt;
		public LoopCondBodyContext loopCondBody;
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(420);
				match(NEWLINE);
				}
				}
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(426);
			match(ELSE);
			setState(427);
			((ElseStatementContext)_localctx).loopCondBody = loopCondBody();
			((ElseStatementContext)_localctx).stmt =  ((ElseStatementContext)_localctx).loopCondBody.stmt;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public Statement stmt;
		public WhileLoopStatementContext whileLoopStatement;
		public DoWhileLoopStatementContext doWhileLoopStatement;
		public WhileLoopStatementContext whileLoopStatement() {
			return getRuleContext(WhileLoopStatementContext.class,0);
		}
		public DoWhileLoopStatementContext doWhileLoopStatement() {
			return getRuleContext(DoWhileLoopStatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_loopStatement);
		try {
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				((LoopStatementContext)_localctx).whileLoopStatement = whileLoopStatement();
				((LoopStatementContext)_localctx).stmt =  ((LoopStatementContext)_localctx).whileLoopStatement.stmt;
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				((LoopStatementContext)_localctx).doWhileLoopStatement = doWhileLoopStatement();
				((LoopStatementContext)_localctx).stmt =  ((LoopStatementContext)_localctx).doWhileLoopStatement.stmt;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLoopStatementContext extends ParserRuleContext {
		public Statement stmt;
		public Token WHILE;
		public ExpressionContext expression;
		public LoopCondBodyContext loopCondBody;
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public WhileLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopStatementContext whileLoopStatement() throws RecognitionException {
		WhileLoopStatementContext _localctx = new WhileLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileLoopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			((WhileLoopStatementContext)_localctx).WHILE = match(WHILE);
			setState(439);
			((WhileLoopStatementContext)_localctx).expression = expression();
			setState(440);
			((WhileLoopStatementContext)_localctx).loopCondBody = loopCondBody();

			        LoopStmt loop = new LoopStmt();
			        loop.setLine((((WhileLoopStatementContext)_localctx).WHILE!=null?((WhileLoopStatementContext)_localctx).WHILE.getLine():0));
			        loop.setCondition(((WhileLoopStatementContext)_localctx).expression.exp);
			        loop.setBody(((WhileLoopStatementContext)_localctx).loopCondBody.stmt);
			        ((WhileLoopStatementContext)_localctx).stmt =  loop;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoWhileLoopStatementContext extends ParserRuleContext {
		public Statement stmt;
		public Token DO;
		public BodyContext body;
		public ExpressionContext expression;
		public TerminalNode DO() { return getToken(CmmParser.DO, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public DoWhileLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDoWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDoWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDoWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileLoopStatementContext doWhileLoopStatement() throws RecognitionException {
		DoWhileLoopStatementContext _localctx = new DoWhileLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doWhileLoopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			((DoWhileLoopStatementContext)_localctx).DO = match(DO);
			setState(444);
			((DoWhileLoopStatementContext)_localctx).body = body();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(445);
				match(NEWLINE);
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(451);
			match(WHILE);
			setState(452);
			((DoWhileLoopStatementContext)_localctx).expression = expression();

			        LoopStmt loop = new LoopStmt();
			        loop.setLine((((DoWhileLoopStatementContext)_localctx).DO!=null?((DoWhileLoopStatementContext)_localctx).DO.getLine():0));
			        loop.setCondition(((DoWhileLoopStatementContext)_localctx).expression.exp);
			        loop.setBody(((DoWhileLoopStatementContext)_localctx).body.stmt);
			        ((DoWhileLoopStatementContext)_localctx).stmt =  loop;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisplayStatementContext extends ParserRuleContext {
		public Statement stmt;
		public Token DISPLAY;
		public ExpressionContext expression;
		public TerminalNode DISPLAY() { return getToken(CmmParser.DISPLAY, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public DisplayStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_displayStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDisplayStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDisplayStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDisplayStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisplayStatementContext displayStatement() throws RecognitionException {
		DisplayStatementContext _localctx = new DisplayStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_displayStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			((DisplayStatementContext)_localctx).DISPLAY = match(DISPLAY);
			setState(456);
			match(LPAR);
			setState(457);
			((DisplayStatementContext)_localctx).expression = expression();
			setState(458);
			match(RPAR);

			        ((DisplayStatementContext)_localctx).stmt =  new DisplayStmt(((DisplayStatementContext)_localctx).expression.exp);
			        _localctx.stmt.setLine((((DisplayStatementContext)_localctx).DISPLAY!=null?((DisplayStatementContext)_localctx).DISPLAY.getLine():0));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public Statement stmt;
		public OrExpressionContext orExpression;
		public Token ASSIGN;
		public ExpressionContext expression;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			((AssignmentStatementContext)_localctx).orExpression = orExpression();
			setState(462);
			((AssignmentStatementContext)_localctx).ASSIGN = match(ASSIGN);
			setState(463);
			((AssignmentStatementContext)_localctx).expression = expression();

			        ((AssignmentStatementContext)_localctx).stmt =  new AssignmentStmt(((AssignmentStatementContext)_localctx).orExpression.exp, ((AssignmentStatementContext)_localctx).expression.exp);
			        _localctx.stmt.setLine((((AssignmentStatementContext)_localctx).ASSIGN!=null?((AssignmentStatementContext)_localctx).ASSIGN.getLine():0));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public Statement stmt;
		public IfStatementContext ifStatement;
		public DisplayStatementContext displayStatement;
		public FunctionCallStmtContext functionCallStmt;
		public ReturnStatementContext returnStatement;
		public AssignmentStatementContext assignmentStatement;
		public VarDecStatementContext varDecStatement;
		public LoopStatementContext loopStatement;
		public AppendContext append;
		public SizeContext size;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public DisplayStatementContext displayStatement() {
			return getRuleContext(DisplayStatementContext.class,0);
		}
		public FunctionCallStmtContext functionCallStmt() {
			return getRuleContext(FunctionCallStmtContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public AppendContext append() {
			return getRuleContext(AppendContext.class,0);
		}
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_singleStatement);
		try {
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				((SingleStatementContext)_localctx).ifStatement = ifStatement();
				((SingleStatementContext)_localctx).stmt =  ((SingleStatementContext)_localctx).ifStatement.stmt;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				((SingleStatementContext)_localctx).displayStatement = displayStatement();
				((SingleStatementContext)_localctx).stmt =  ((SingleStatementContext)_localctx).displayStatement.stmt;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(472);
				((SingleStatementContext)_localctx).functionCallStmt = functionCallStmt();
				((SingleStatementContext)_localctx).stmt =  ((SingleStatementContext)_localctx).functionCallStmt.stmt;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(475);
				((SingleStatementContext)_localctx).returnStatement = returnStatement();
				((SingleStatementContext)_localctx).stmt =  ((SingleStatementContext)_localctx).returnStatement.stmt;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(478);
				((SingleStatementContext)_localctx).assignmentStatement = assignmentStatement();
				((SingleStatementContext)_localctx).stmt =  ((SingleStatementContext)_localctx).assignmentStatement.stmt;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(481);
				((SingleStatementContext)_localctx).varDecStatement = varDecStatement();
				((SingleStatementContext)_localctx).stmt =  ((SingleStatementContext)_localctx).varDecStatement.stmt;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(484);
				((SingleStatementContext)_localctx).loopStatement = loopStatement();
				((SingleStatementContext)_localctx).stmt =  ((SingleStatementContext)_localctx).loopStatement.stmt;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(487);
				((SingleStatementContext)_localctx).append = append();
				ListAppendStmt app = new ListAppendStmt(((SingleStatementContext)_localctx).append.exp); ((SingleStatementContext)_localctx).stmt =  app;
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(490);
				((SingleStatementContext)_localctx).size = size();
				ListSizeStmt s = new ListSizeStmt(((SingleStatementContext)_localctx).size.exp); ((SingleStatementContext)_localctx).stmt =  s;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression exp;
		public OrExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			((ExpressionContext)_localctx).e1 = orExpression();

			        ((ExpressionContext)_localctx).exp =  ((ExpressionContext)_localctx).e1.exp;
			    
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(497);
				((ExpressionContext)_localctx).op = match(ASSIGN);
				setState(498);
				((ExpressionContext)_localctx).e2 = expression();

				        ((ExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((ExpressionContext)_localctx).e2.exp, BinaryOperator.assign);
				        _localctx.exp.setLine((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getLine():0));
				    
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public Expression exp;
		public AndExpressionContext e1;
		public Token op;
		public AndExpressionContext e2;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CmmParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CmmParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			((OrExpressionContext)_localctx).e1 = andExpression();

			        ((OrExpressionContext)_localctx).exp =  ((OrExpressionContext)_localctx).e1.exp;
			    
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(505);
				((OrExpressionContext)_localctx).op = match(OR);
				setState(506);
				((OrExpressionContext)_localctx).e2 = andExpression();

				        ((OrExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((OrExpressionContext)_localctx).e2.exp, BinaryOperator.or);
				        _localctx.exp.setLine((((OrExpressionContext)_localctx).op!=null?((OrExpressionContext)_localctx).op.getLine():0));
				    
				}
				}
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression exp;
		public EqualityExpressionContext e1;
		public Token op;
		public EqualityExpressionContext e2;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(CmmParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CmmParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			((AndExpressionContext)_localctx).e1 = equalityExpression();

			        ((AndExpressionContext)_localctx).exp =  ((AndExpressionContext)_localctx).e1.exp;
			    
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(516);
				((AndExpressionContext)_localctx).op = match(AND);
				setState(517);
				((AndExpressionContext)_localctx).e2 = equalityExpression();

				        ((AndExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((AndExpressionContext)_localctx).e2.exp, BinaryOperator.and);
				        _localctx.exp.setLine((((AndExpressionContext)_localctx).op!=null?((AndExpressionContext)_localctx).op.getLine():0));
				    
				}
				}
				setState(524);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression exp;
		public RelationalExpressionContext e1;
		public Token op;
		public RelationalExpressionContext e2;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(CmmParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(CmmParser.EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			((EqualityExpressionContext)_localctx).e1 = relationalExpression();

			        ((EqualityExpressionContext)_localctx).exp =  ((EqualityExpressionContext)_localctx).e1.exp;
			    
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL) {
				{
				{
				setState(527);
				((EqualityExpressionContext)_localctx).op = match(EQUAL);
				setState(528);
				((EqualityExpressionContext)_localctx).e2 = relationalExpression();

				        ((EqualityExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((EqualityExpressionContext)_localctx).e2.exp, BinaryOperator.eq);
				        _localctx.exp.setLine((((EqualityExpressionContext)_localctx).op!=null?((EqualityExpressionContext)_localctx).op.getLine():0));
				    
				}
				}
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression exp;
		public AdditiveExpressionContext e1;
		public Token op_gt;
		public AdditiveExpressionContext e2;
		public Token op_lt;
		public AdditiveExpressionContext e3;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(CmmParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(CmmParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(CmmParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(CmmParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			((RelationalExpressionContext)_localctx).e1 = additiveExpression();

			        ((RelationalExpressionContext)_localctx).exp =  ((RelationalExpressionContext)_localctx).e1.exp;
			    
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				setState(546);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					{
					setState(538);
					((RelationalExpressionContext)_localctx).op_gt = match(GREATER_THAN);
					setState(539);
					((RelationalExpressionContext)_localctx).e2 = additiveExpression();

					        ((RelationalExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((RelationalExpressionContext)_localctx).e2.exp, BinaryOperator.gt);
					        _localctx.exp.setLine((((RelationalExpressionContext)_localctx).op_gt!=null?((RelationalExpressionContext)_localctx).op_gt.getLine():0));
					    
					}
					}
					break;
				case LESS_THAN:
					{
					{
					setState(542);
					((RelationalExpressionContext)_localctx).op_lt = match(LESS_THAN);
					setState(543);
					((RelationalExpressionContext)_localctx).e3 = additiveExpression();

					        ((RelationalExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((RelationalExpressionContext)_localctx).e3.exp, BinaryOperator.lt);
					        _localctx.exp.setLine((((RelationalExpressionContext)_localctx).op_lt!=null?((RelationalExpressionContext)_localctx).op_lt.getLine():0));
					    
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression exp;
		public MultiplicativeExpressionContext e1;
		public Token op_plus;
		public MultiplicativeExpressionContext e2;
		public Token op_minus;
		public MultiplicativeExpressionContext e3;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CmmParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CmmParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CmmParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CmmParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			((AdditiveExpressionContext)_localctx).e1 = multiplicativeExpression();

			        ((AdditiveExpressionContext)_localctx).exp =  ((AdditiveExpressionContext)_localctx).e1.exp;
			    
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(561);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					{
					setState(553);
					((AdditiveExpressionContext)_localctx).op_plus = match(PLUS);
					setState(554);
					((AdditiveExpressionContext)_localctx).e2 = multiplicativeExpression();

					        ((AdditiveExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((AdditiveExpressionContext)_localctx).e2.exp, BinaryOperator.add);
					        _localctx.exp.setLine((((AdditiveExpressionContext)_localctx).op_plus!=null?((AdditiveExpressionContext)_localctx).op_plus.getLine():0));
					    
					}
					}
					break;
				case MINUS:
					{
					{
					setState(557);
					((AdditiveExpressionContext)_localctx).op_minus = match(MINUS);
					setState(558);
					((AdditiveExpressionContext)_localctx).e3 = multiplicativeExpression();

					        ((AdditiveExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((AdditiveExpressionContext)_localctx).e3.exp, BinaryOperator.sub);
					        _localctx.exp.setLine((((AdditiveExpressionContext)_localctx).op_minus!=null?((AdditiveExpressionContext)_localctx).op_minus.getLine():0));
					    
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression exp;
		public PreUnaryExpressionContext e1;
		public Token op_mult;
		public PreUnaryExpressionContext e2;
		public Token op_div;
		public PreUnaryExpressionContext e3;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(CmmParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(CmmParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(CmmParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(CmmParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			((MultiplicativeExpressionContext)_localctx).e1 = preUnaryExpression();

			        ((MultiplicativeExpressionContext)_localctx).exp =  ((MultiplicativeExpressionContext)_localctx).e1.exp;
			    
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				setState(576);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					{
					setState(568);
					((MultiplicativeExpressionContext)_localctx).op_mult = match(MULT);
					setState(569);
					((MultiplicativeExpressionContext)_localctx).e2 = preUnaryExpression();

					        ((MultiplicativeExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((MultiplicativeExpressionContext)_localctx).e2.exp, BinaryOperator.mult);
					        _localctx.exp.setLine((((MultiplicativeExpressionContext)_localctx).op_mult!=null?((MultiplicativeExpressionContext)_localctx).op_mult.getLine():0));
					    
					}
					}
					break;
				case DIVIDE:
					{
					{
					setState(572);
					((MultiplicativeExpressionContext)_localctx).op_div = match(DIVIDE);
					setState(573);
					((MultiplicativeExpressionContext)_localctx).e3 = preUnaryExpression();

					        ((MultiplicativeExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp, ((MultiplicativeExpressionContext)_localctx).e3.exp, BinaryOperator.div);
					        _localctx.exp.setLine((((MultiplicativeExpressionContext)_localctx).op_div!=null?((MultiplicativeExpressionContext)_localctx).op_div.getLine():0));
					    
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression exp;
		public Token op_not;
		public PreUnaryExpressionContext e1;
		public Token op_minus;
		public PreUnaryExpressionContext e2;
		public AccessExpressionContext e3;
		public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_preUnaryExpression);
		try {
			setState(592);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(581);
				((PreUnaryExpressionContext)_localctx).op_not = match(NOT);
				setState(582);
				((PreUnaryExpressionContext)_localctx).e1 = preUnaryExpression();

				        ((PreUnaryExpressionContext)_localctx).exp =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).e1.exp, UnaryOperator.not);
				        _localctx.exp.setLine((((PreUnaryExpressionContext)_localctx).op_not!=null?((PreUnaryExpressionContext)_localctx).op_not.getLine():0));
				    
				}
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(585);
				((PreUnaryExpressionContext)_localctx).op_minus = match(MINUS);
				setState(586);
				((PreUnaryExpressionContext)_localctx).e2 = preUnaryExpression();

				        ((PreUnaryExpressionContext)_localctx).exp =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).e2.exp, UnaryOperator.minus);
				        _localctx.exp.setLine((((PreUnaryExpressionContext)_localctx).op_minus!=null?((PreUnaryExpressionContext)_localctx).op_minus.getLine():0));
				    
				}
				}
				break;
			case SIZE:
			case APPEND:
			case TRUE:
			case FALSE:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(589);
				((PreUnaryExpressionContext)_localctx).e3 = accessExpression();

				        ((PreUnaryExpressionContext)_localctx).exp =  ((PreUnaryExpressionContext)_localctx).e3.exp;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression exp;
		public OtherExpressionContext otherExpression;
		public Token LPAR;
		public FunctionArgumentsContext functionArguments;
		public Token DOT;
		public IdentifierContext identifier;
		public Token LBRACK;
		public ExpressionContext expression;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> LPAR() { return getTokens(CmmParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(CmmParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(CmmParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(CmmParser.RPAR, i);
		}
		public List<TerminalNode> DOT() { return getTokens(CmmParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(CmmParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(CmmParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(CmmParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(CmmParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(CmmParser.RBRACK, i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_accessExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			((AccessExpressionContext)_localctx).otherExpression = otherExpression();
			((AccessExpressionContext)_localctx).exp =  ((AccessExpressionContext)_localctx).otherExpression.exp;
			setState(608);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(606);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(596);
						((AccessExpressionContext)_localctx).LPAR = match(LPAR);

						        FunctionCall fc = new FunctionCall(_localctx.exp);
						        fc.setLine((((AccessExpressionContext)_localctx).LPAR!=null?((AccessExpressionContext)_localctx).LPAR.getLine():0));
						        ((AccessExpressionContext)_localctx).exp =  fc;
						    
						setState(598);
						((AccessExpressionContext)_localctx).functionArguments = functionArguments();
						fc.setArgs(((AccessExpressionContext)_localctx).functionArguments.args);
						setState(600);
						match(RPAR);
						}
						}
						break;
					case DOT:
						{
						{
						setState(602);
						((AccessExpressionContext)_localctx).DOT = match(DOT);
						setState(603);
						((AccessExpressionContext)_localctx).identifier = identifier();

						        StructAccess sa = new StructAccess(_localctx.exp, ((AccessExpressionContext)_localctx).identifier.ID);
						        sa.setLine((((AccessExpressionContext)_localctx).DOT!=null?((AccessExpressionContext)_localctx).DOT.getLine():0));
						        ((AccessExpressionContext)_localctx).exp =  sa;
						    
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(610);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK || _la==DOT) {
				{
				setState(620);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					{
					setState(611);
					((AccessExpressionContext)_localctx).LBRACK = match(LBRACK);
					setState(612);
					((AccessExpressionContext)_localctx).expression = expression();
					setState(613);
					match(RBRACK);

					        ListAccessByIndex labi = new ListAccessByIndex(_localctx.exp, ((AccessExpressionContext)_localctx).expression.exp);
					        labi.setLine((((AccessExpressionContext)_localctx).LBRACK!=null?((AccessExpressionContext)_localctx).LBRACK.getLine():0));
					        ((AccessExpressionContext)_localctx).exp =  labi;
					    
					}
					}
					break;
				case DOT:
					{
					{
					setState(616);
					((AccessExpressionContext)_localctx).DOT = match(DOT);
					setState(617);
					((AccessExpressionContext)_localctx).identifier = identifier();

					        StructAccess sa = new StructAccess(_localctx.exp, ((AccessExpressionContext)_localctx).identifier.ID);
					        sa.setLine((((AccessExpressionContext)_localctx).DOT!=null?((AccessExpressionContext)_localctx).DOT.getLine():0));
					        ((AccessExpressionContext)_localctx).exp =  sa;
					    
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(624);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression exp;
		public ValueContext value;
		public IdentifierContext identifier;
		public Token LPAR;
		public FunctionArgumentsContext functionArguments;
		public SizeContext size;
		public AppendContext append;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public AppendContext append() {
			return getRuleContext(AppendContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_otherExpression);
		try {
			setState(642);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case INT_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(625);
				((OtherExpressionContext)_localctx).value = value();
				((OtherExpressionContext)_localctx).exp =  ((OtherExpressionContext)_localctx).value.val;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(628);
				((OtherExpressionContext)_localctx).identifier = identifier();
				((OtherExpressionContext)_localctx).exp =  ((OtherExpressionContext)_localctx).identifier.ID;
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(631);
				((OtherExpressionContext)_localctx).LPAR = match(LPAR);
				{
				setState(632);
				((OtherExpressionContext)_localctx).functionArguments = functionArguments();
				}
				setState(633);
				match(RPAR);

				        ((OtherExpressionContext)_localctx).exp =  new ExprInPar(((OtherExpressionContext)_localctx).functionArguments.args);
				        _localctx.exp.setLine((((OtherExpressionContext)_localctx).LPAR!=null?((OtherExpressionContext)_localctx).LPAR.getLine():0));
				    
				}
				break;
			case SIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(636);
				((OtherExpressionContext)_localctx).size = size();
				((OtherExpressionContext)_localctx).exp =  ((OtherExpressionContext)_localctx).size.exp;
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 5);
				{
				setState(639);
				((OtherExpressionContext)_localctx).append = append();
				((OtherExpressionContext)_localctx).exp =  ((OtherExpressionContext)_localctx).append.exp;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SizeContext extends ParserRuleContext {
		public ListSize exp;
		public Token sizeLine;
		public ExpressionContext e1;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public TerminalNode SIZE() { return getToken(CmmParser.SIZE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			((SizeContext)_localctx).sizeLine = match(SIZE);
			setState(645);
			match(LPAR);
			setState(646);
			((SizeContext)_localctx).e1 = expression();
			setState(647);
			match(RPAR);

			        ((SizeContext)_localctx).exp =  new ListSize(((SizeContext)_localctx).e1.exp);
			        _localctx.exp.setLine((((SizeContext)_localctx).sizeLine!=null?((SizeContext)_localctx).sizeLine.getLine():0));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AppendContext extends ParserRuleContext {
		public ListAppend exp;
		public Token APPEND;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public TerminalNode APPEND() { return getToken(CmmParser.APPEND, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode COMMA() { return getToken(CmmParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AppendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_append; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAppend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAppend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAppend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppendContext append() throws RecognitionException {
		AppendContext _localctx = new AppendContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_append);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			((AppendContext)_localctx).APPEND = match(APPEND);
			setState(651);
			match(LPAR);
			setState(652);
			((AppendContext)_localctx).e1 = expression();
			setState(653);
			match(COMMA);
			setState(654);
			((AppendContext)_localctx).e2 = expression();
			setState(655);
			match(RPAR);

			        ListAppend app = new ListAppend(((AppendContext)_localctx).e1.exp, ((AppendContext)_localctx).e2.exp);
			        app.setLine(((AppendContext)_localctx).APPEND.getLine());
			        ((AppendContext)_localctx).exp =  app;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public Value val;
		public BoolValueContext b;
		public Token i;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode INT_VALUE() { return getToken(CmmParser.INT_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_value);
		try {
			setState(663);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(658);
				((ValueContext)_localctx).b = boolValue();
				((ValueContext)_localctx).val =  ((ValueContext)_localctx).b.boolVal;
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(661);
				((ValueContext)_localctx).i = match(INT_VALUE);

				        ((ValueContext)_localctx).val =  new IntValue(Integer.parseInt((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)));
				        _localctx.val.setLine(((ValueContext)_localctx).i.getLine());
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValueContext extends ParserRuleContext {
		public Value boolVal;
		public Token trueLine;
		public Token falseLine;
		public TerminalNode TRUE() { return getToken(CmmParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CmmParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_boolValue);
		try {
			setState(669);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(665);
				((BoolValueContext)_localctx).trueLine = match(TRUE);

				        ((BoolValueContext)_localctx).boolVal =  new BoolValue(true);
				        _localctx.boolVal.setLine(((BoolValueContext)_localctx).trueLine.getLine());
				    
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				((BoolValueContext)_localctx).falseLine = match(FALSE);

				        ((BoolValueContext)_localctx).boolVal =  new BoolValue(false);
				        _localctx.boolVal.setLine(((BoolValueContext)_localctx).falseLine.getLine());
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier ID;
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			((IdentifierContext)_localctx).name = match(IDENTIFIER);

			        ((IdentifierContext)_localctx).ID =  new Identifier((((IdentifierContext)_localctx).name!=null?((IdentifierContext)_localctx).name.getText():null));
			        _localctx.ID.setLine(((IdentifierContext)_localctx).name.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type varType;
		public TypeContext type;
		public IdentifierContext identifier;
		public FptrTypeContext fptrType;
		public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(CmmParser.BOOL, 0); }
		public TerminalNode LIST() { return getToken(CmmParser.LIST, 0); }
		public TerminalNode SHARP() { return getToken(CmmParser.SHARP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FptrTypeContext fptrType() {
			return getRuleContext(FptrTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		try {
			setState(690);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(674);
				match(INT);
				((TypeContext)_localctx).varType =  new IntType();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				match(BOOL);
				((TypeContext)_localctx).varType =  new BoolType();
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 3);
				{
				setState(678);
				match(LIST);
				setState(679);
				match(SHARP);
				setState(680);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).varType =  new ListType(((TypeContext)_localctx).type.varType);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				setState(683);
				match(STRUCT);
				setState(684);
				((TypeContext)_localctx).identifier = identifier();
				((TypeContext)_localctx).varType =  new StructType(((TypeContext)_localctx).identifier.ID);
				}
				break;
			case FPTR:
				enterOuterAlt(_localctx, 5);
				{
				setState(687);
				((TypeContext)_localctx).fptrType = fptrType();
				((TypeContext)_localctx).varType =  ((TypeContext)_localctx).fptrType.fptype;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FptrTypeContext extends ParserRuleContext {
		public FptrType fptype;
		public ArrayList<Type> Ltype;
		public TypeContext t1;
		public TypeContext t2;
		public TypeContext t3;
		public TerminalNode FPTR() { return getToken(CmmParser.FPTR, 0); }
		public TerminalNode LESS_THAN() { return getToken(CmmParser.LESS_THAN, 0); }
		public TerminalNode ARROW() { return getToken(CmmParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(CmmParser.GREATER_THAN, 0); }
		public List<TerminalNode> VOID() { return getTokens(CmmParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(CmmParser.VOID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FptrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFptrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFptrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFptrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FptrTypeContext fptrType() throws RecognitionException {
		FptrTypeContext _localctx = new FptrTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_fptrType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(692);
			match(FPTR);

			        ((FptrTypeContext)_localctx).Ltype =  new ArrayList<>();
			    
			{
			setState(694);
			match(LESS_THAN);
			setState(708);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(695);
				match(VOID);

				        VoidType vid = new VoidType();
				        _localctx.Ltype.add(vid);
				    
				}
				break;
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				{
				setState(697);
				((FptrTypeContext)_localctx).t1 = type();

				        _localctx.Ltype.add(((FptrTypeContext)_localctx).t1.varType);
				     
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(699);
					match(COMMA);
					setState(700);
					((FptrTypeContext)_localctx).t2 = type();

					        _localctx.Ltype.add(((FptrTypeContext)_localctx).t2.varType);
					     
					}
					}
					setState(707);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(710);
			match(ARROW);
			setState(716);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				setState(711);
				((FptrTypeContext)_localctx).t3 = type();

				             ((FptrTypeContext)_localctx).fptype =  new FptrType(_localctx.Ltype, ((FptrTypeContext)_localctx).t3.varType);
				          
				}
				break;
			case VOID:
				{
				setState(714);
				match(VOID);

				            VoidType vd = new VoidType();
				             ((FptrTypeContext)_localctx).fptype =  new FptrType(_localctx.Ltype, vd);
				          
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(718);
			match(GREATER_THAN);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u02d3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\3\2\7\2b\n\2\f\2\16\2e\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\3\3\3\3\3\7\3u\n\3\f"+
		"\3\16\3x\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\6\5\u008a\n\5\r\5\16\5\u008b\3\5\3\5\3\5\6\5\u0091\n\5\r\5\16"+
		"\5\u0092\3\5\3\5\3\5\5\5\u0098\n\5\5\5\u009a\n\5\3\5\6\5\u009d\n\5\r\5"+
		"\16\5\u009e\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u00aa\n\6\r\6\16\6"+
		"\u00ab\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00bb\n"+
		"\7\3\b\3\b\6\b\u00bf\n\b\r\b\16\b\u00c0\3\b\3\b\3\b\3\b\7\b\u00c7\n\b"+
		"\f\b\16\b\u00ca\13\b\3\b\3\b\3\b\5\b\u00cf\n\b\6\b\u00d1\n\b\r\b\16\b"+
		"\u00d2\3\b\3\b\3\t\3\t\3\t\3\t\6\t\u00db\n\t\r\t\16\t\u00dc\3\n\3\n\3"+
		"\n\3\n\6\n\u00e3\n\n\r\n\16\n\u00e4\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00ed\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00f6\n\13\r\13\16"+
		"\13\u00f7\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0106"+
		"\n\f\f\f\16\f\u0109\13\f\5\f\u010b\n\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\r\u0117\n\r\f\r\16\r\u011a\13\r\5\r\u011c\n\r\3\16\3\16\3\16"+
		"\3\16\6\16\u0122\n\16\r\16\16\16\u0123\3\16\3\16\3\16\5\16\u0129\n\16"+
		"\5\16\u012b\n\16\3\17\3\17\3\17\3\17\6\17\u0131\n\17\r\17\16\17\u0132"+
		"\3\17\3\17\3\17\5\17\u0138\n\17\3\20\3\20\3\20\6\20\u013d\n\20\r\20\16"+
		"\20\u013e\3\20\3\20\3\20\3\20\7\20\u0145\n\20\f\20\16\20\u0148\13\20\3"+
		"\20\3\20\3\20\5\20\u014d\n\20\6\20\u014f\n\20\r\20\16\20\u0150\3\20\3"+
		"\20\6\20\u0155\n\20\r\20\16\20\u0156\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0162\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u016c\n\21\3\21\3\21\7\21\u0170\n\21\f\21\16\21\u0173\13\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22"+
		"\u0184\n\22\f\22\16\22\u0187\13\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0194\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u01a3\n\24\3\24\3\24\3\25\7\25\u01a8"+
		"\n\25\f\25\16\25\u01ab\13\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u01b7\n\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\7\30"+
		"\u01c1\n\30\f\30\16\30\u01c4\13\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u01f0\n\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u01f8\n\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0200\n"+
		"\35\f\35\16\35\u0203\13\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u020b\n"+
		"\36\f\36\16\36\u020e\13\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0216\n"+
		"\37\f\37\16\37\u0219\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0225\n \f"+
		" \16 \u0228\13 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0234\n!\f!\16!\u0237"+
		"\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0243\n\"\f\"\16\"\u0246"+
		"\13\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0253\n#\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\7$\u0261\n$\f$\16$\u0264\13$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\7$\u026f\n$\f$\16$\u0272\13$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\5%\u0285\n%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3(\3(\3(\3(\3(\5(\u029a\n(\3)\3)\3)\3)\5)\u02a0\n)\3*\3*\3*\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u02b5\n+\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\7,\u02c2\n,\f,\16,\u02c5\13,\5,\u02c7\n,\3,\3,\3"+
		",\3,\3,\3,\5,\u02cf\n,\3,\3,\3,\2\2-\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\2\2\u02f7\2[\3\2\2\2\4h"+
		"\3\2\2\2\6|\3\2\2\2\b\u0082\3\2\2\2\n\u00a2\3\2\2\2\f\u00ba\3\2\2\2\16"+
		"\u00bc\3\2\2\2\20\u00d6\3\2\2\2\22\u00de\3\2\2\2\24\u00e6\3\2\2\2\26\u00fb"+
		"\3\2\2\2\30\u010f\3\2\2\2\32\u012a\3\2\2\2\34\u0137\3\2\2\2\36\u0139\3"+
		"\2\2\2 \u015a\3\2\2\2\"\u0176\3\2\2\2$\u018e\3\2\2\2&\u0197\3\2\2\2(\u01a9"+
		"\3\2\2\2*\u01b6\3\2\2\2,\u01b8\3\2\2\2.\u01bd\3\2\2\2\60\u01c9\3\2\2\2"+
		"\62\u01cf\3\2\2\2\64\u01ef\3\2\2\2\66\u01f1\3\2\2\28\u01f9\3\2\2\2:\u0204"+
		"\3\2\2\2<\u020f\3\2\2\2>\u021a\3\2\2\2@\u0229\3\2\2\2B\u0238\3\2\2\2D"+
		"\u0252\3\2\2\2F\u0254\3\2\2\2H\u0284\3\2\2\2J\u0286\3\2\2\2L\u028c\3\2"+
		"\2\2N\u0299\3\2\2\2P\u029f\3\2\2\2R\u02a1\3\2\2\2T\u02b4\3\2\2\2V\u02b6"+
		"\3\2\2\2XZ\7,\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2"+
		"][\3\2\2\2^_\5\4\3\2_c\b\2\1\2`b\7,\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2"+
		"cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\2\2\3g\3\3\2\2\2hn\b\3\1\2ij\5\b\5"+
		"\2jk\b\3\1\2km\3\2\2\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2ov\3\2\2"+
		"\2pn\3\2\2\2qr\5\24\13\2rs\b\3\1\2su\3\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2"+
		"\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\5\6\4\2z{\b\3\1\2{\5\3\2\2\2|}\7"+
		"\3\2\2}~\7%\2\2~\177\7&\2\2\177\u0080\5\32\16\2\u0080\u0081\b\4\1\2\u0081"+
		"\7\3\2\2\2\u0082\u0083\7\35\2\2\u0083\u0084\5R*\2\u0084\u0099\b\5\1\2"+
		"\u0085\u0086\7\30\2\2\u0086\u0087\5\16\b\2\u0087\u0089\b\5\1\2\u0088\u008a"+
		"\7,\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\31\2\2\u008e\u009a\3"+
		"\2\2\2\u008f\u0091\7,\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\5\f"+
		"\7\2\u0095\u0097\b\5\1\2\u0096\u0098\7+\2\2\u0097\u0096\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0085\3\2\2\2\u0099\u0090\3\2"+
		"\2\2\u009a\u009c\3\2\2\2\u009b\u009d\7,\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\b\5\1\2\u00a1\t\3\2\2\2\u00a2\u00a3\5T+\2\u00a3\u00a4"+
		"\5R*\2\u00a4\u00a5\b\6\1\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\b\6\1\2\u00a7"+
		"\u00a9\7\30\2\2\u00a8\u00aa\7,\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\5\22\n\2\u00ae\u00af\b\6\1\2\u00af\u00b0\5\20\t\2\u00b0\u00b1\b"+
		"\6\1\2\u00b1\u00b2\7\31\2\2\u00b2\u00b3\b\6\1\2\u00b3\13\3\2\2\2\u00b4"+
		"\u00b5\5 \21\2\u00b5\u00b6\b\7\1\2\u00b6\u00bb\3\2\2\2\u00b7\u00b8\5\n"+
		"\6\2\u00b8\u00b9\b\7\1\2\u00b9\u00bb\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba"+
		"\u00b7\3\2\2\2\u00bb\r\3\2\2\2\u00bc\u00d0\b\b\1\2\u00bd\u00bf\7,\2\2"+
		"\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\u00c8\3\2\2\2\u00c2\u00c3\5\f\7\2\u00c3\u00c4\b\b\1\2\u00c4"+
		"\u00c5\7+\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c7\u00ca\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cc\5\f\7\2\u00cc\u00ce\b\b\1\2\u00cd\u00cf\7+"+
		"\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00be\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\b\b\1\2\u00d5\17\3\2\2\2\u00d6\u00d7"+
		"\7\37\2\2\u00d7\u00d8\5\32\16\2\u00d8\u00da\b\t\1\2\u00d9\u00db\7,\2\2"+
		"\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\21\3\2\2\2\u00de\u00df\7 \2\2\u00df\u00e0\5\32\16\2\u00e0"+
		"\u00e2\b\n\1\2\u00e1\u00e3\7,\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\23\3\2\2\2\u00e6\u00ec"+
		"\b\13\1\2\u00e7\u00e8\5T+\2\u00e8\u00e9\b\13\1\2\u00e9\u00ed\3\2\2\2\u00ea"+
		"\u00eb\7\5\2\2\u00eb\u00ed\b\13\1\2\u00ec\u00e7\3\2\2\2\u00ec\u00ea\3"+
		"\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\5R*\2\u00ef\u00f0\b\13\1\2\u00f0"+
		"\u00f1\5\26\f\2\u00f1\u00f2\b\13\1\2\u00f2\u00f3\5\32\16\2\u00f3\u00f5"+
		"\b\13\1\2\u00f4\u00f6\7,\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\b\13"+
		"\1\2\u00fa\25\3\2\2\2\u00fb\u00fc\b\f\1\2\u00fc\u010a\7%\2\2\u00fd\u00fe"+
		"\5T+\2\u00fe\u00ff\5R*\2\u00ff\u0107\b\f\1\2\u0100\u0101\7)\2\2\u0101"+
		"\u0102\5T+\2\u0102\u0103\5R*\2\u0103\u0104\b\f\1\2\u0104\u0106\3\2\2\2"+
		"\u0105\u0100\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108"+
		"\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u00fd\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\7&\2\2\u010d\u010e\b\f"+
		"\1\2\u010e\27\3\2\2\2\u010f\u011b\b\r\1\2\u0110\u0111\5\66\34\2\u0111"+
		"\u0118\b\r\1\2\u0112\u0113\7)\2\2\u0113\u0114\5\66\34\2\u0114\u0115\b"+
		"\r\1\2\u0115\u0117\3\2\2\2\u0116\u0112\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011b\u0110\3\2\2\2\u011b\u011c\3\2\2\2\u011c\31\3\2\2\2\u011d\u011e"+
		"\5\36\20\2\u011e\u011f\b\16\1\2\u011f\u012b\3\2\2\2\u0120\u0122\7,\2\2"+
		"\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\5\64\33\2\u0126\u0128\b\16\1"+
		"\2\u0127\u0129\7+\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b"+
		"\3\2\2\2\u012a\u011d\3\2\2\2\u012a\u0121\3\2\2\2\u012b\33\3\2\2\2\u012c"+
		"\u012d\5\36\20\2\u012d\u012e\b\17\1\2\u012e\u0138\3\2\2\2\u012f\u0131"+
		"\7,\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\5\64\33\2\u0135\u0136\b"+
		"\17\1\2\u0136\u0138\3\2\2\2\u0137\u012c\3\2\2\2\u0137\u0130\3\2\2\2\u0138"+
		"\35\3\2\2\2\u0139\u013a\7\30\2\2\u013a\u014e\b\20\1\2\u013b\u013d\7,\2"+
		"\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013f\u0146\3\2\2\2\u0140\u0141\5\64\33\2\u0141\u0142\7+\2\2"+
		"\u0142\u0143\b\20\1\2\u0143\u0145\3\2\2\2\u0144\u0140\3\2\2\2\u0145\u0148"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u0146\3\2\2\2\u0149\u014a\5\64\33\2\u014a\u014c\b\20\1\2\u014b\u014d"+
		"\7+\2\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e"+
		"\u013c\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152\u0154\b\20\1\2\u0153\u0155\7,\2\2\u0154"+
		"\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158\u0159\7\31\2\2\u0159\37\3\2\2\2\u015a\u015b"+
		"\5T+\2\u015b\u015c\5R*\2\u015c\u0161\b\21\1\2\u015d\u015e\7#\2\2\u015e"+
		"\u015f\58\35\2\u015f\u0160\b\21\1\2\u0160\u0162\3\2\2\2\u0161\u015d\3"+
		"\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0171\b\21\1\2\u0164"+
		"\u0165\7)\2\2\u0165\u0166\5R*\2\u0166\u016b\b\21\1\2\u0167\u0168\7#\2"+
		"\2\u0168\u0169\58\35\2\u0169\u016a\b\21\1\2\u016a\u016c\3\2\2\2\u016b"+
		"\u0167\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\b\21"+
		"\1\2\u016e\u0170\3\2\2\2\u016f\u0164\3\2\2\2\u0170\u0173\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0174\u0175\b\21\1\2\u0175!\3\2\2\2\u0176\u0177\5H%\2\u0177\u0185"+
		"\b\22\1\2\u0178\u0179\7%\2\2\u0179\u017a\b\22\1\2\u017a\u017b\5\30\r\2"+
		"\u017b\u017c\b\22\1\2\u017c\u017d\7&\2\2\u017d\u017e\b\22\1\2\u017e\u0184"+
		"\3\2\2\2\u017f\u0180\7*\2\2\u0180\u0181\5R*\2\u0181\u0182\b\22\1\2\u0182"+
		"\u0184\3\2\2\2\u0183\u0178\3\2\2\2\u0183\u017f\3\2\2\2\u0184\u0187\3\2"+
		"\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0188\u0189\7%\2\2\u0189\u018a\5\30\r\2\u018a\u018b\7&"+
		"\2\2\u018b\u018c\3\2\2\2\u018c\u018d\b\22\1\2\u018d#\3\2\2\2\u018e\u018f"+
		"\7\4\2\2\u018f\u0193\b\23\1\2\u0190\u0191\5\66\34\2\u0191\u0192\b\23\1"+
		"\2\u0192\u0194\3\2\2\2\u0193\u0190\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195"+
		"\3\2\2\2\u0195\u0196\b\23\1\2\u0196%\3\2\2\2\u0197\u0198\7\t\2\2\u0198"+
		"\u0199\5\66\34\2\u0199\u01a2\b\24\1\2\u019a\u019b\5\34\17\2\u019b\u019c"+
		"\b\24\1\2\u019c\u01a3\3\2\2\2\u019d\u019e\5\32\16\2\u019e\u019f\b\24\1"+
		"\2\u019f\u01a0\5(\25\2\u01a0\u01a1\b\24\1\2\u01a1\u01a3\3\2\2\2\u01a2"+
		"\u019a\3\2\2\2\u01a2\u019d\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\b\24"+
		"\1\2\u01a5\'\3\2\2\2\u01a6\u01a8\7,\2\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab"+
		"\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ac\u01ad\7\n\2\2\u01ad\u01ae\5\34\17\2\u01ae\u01af\b"+
		"\25\1\2\u01af)\3\2\2\2\u01b0\u01b1\5,\27\2\u01b1\u01b2\b\26\1\2\u01b2"+
		"\u01b7\3\2\2\2\u01b3\u01b4\5.\30\2\u01b4\u01b5\b\26\1\2\u01b5\u01b7\3"+
		"\2\2\2\u01b6\u01b0\3\2\2\2\u01b6\u01b3\3\2\2\2\u01b7+\3\2\2\2\u01b8\u01b9"+
		"\7!\2\2\u01b9\u01ba\5\66\34\2\u01ba\u01bb\5\34\17\2\u01bb\u01bc\b\27\1"+
		"\2\u01bc-\3\2\2\2\u01bd\u01be\7\"\2\2\u01be\u01c2\5\32\16\2\u01bf\u01c1"+
		"\7,\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\7!"+
		"\2\2\u01c6\u01c7\5\66\34\2\u01c7\u01c8\b\30\1\2\u01c8/\3\2\2\2\u01c9\u01ca"+
		"\7\7\2\2\u01ca\u01cb\7%\2\2\u01cb\u01cc\5\66\34\2\u01cc\u01cd\7&\2\2\u01cd"+
		"\u01ce\b\31\1\2\u01ce\61\3\2\2\2\u01cf\u01d0\58\35\2\u01d0\u01d1\7#\2"+
		"\2\u01d1\u01d2\5\66\34\2\u01d2\u01d3\b\32\1\2\u01d3\63\3\2\2\2\u01d4\u01d5"+
		"\5&\24\2\u01d5\u01d6\b\33\1\2\u01d6\u01f0\3\2\2\2\u01d7\u01d8\5\60\31"+
		"\2\u01d8\u01d9\b\33\1\2\u01d9\u01f0\3\2\2\2\u01da\u01db\5\"\22\2\u01db"+
		"\u01dc\b\33\1\2\u01dc\u01f0\3\2\2\2\u01dd\u01de\5$\23\2\u01de\u01df\b"+
		"\33\1\2\u01df\u01f0\3\2\2\2\u01e0\u01e1\5\62\32\2\u01e1\u01e2\b\33\1\2"+
		"\u01e2\u01f0\3\2\2\2\u01e3\u01e4\5 \21\2\u01e4\u01e5\b\33\1\2\u01e5\u01f0"+
		"\3\2\2\2\u01e6\u01e7\5*\26\2\u01e7\u01e8\b\33\1\2\u01e8\u01f0\3\2\2\2"+
		"\u01e9\u01ea\5L\'\2\u01ea\u01eb\b\33\1\2\u01eb\u01f0\3\2\2\2\u01ec\u01ed"+
		"\5J&\2\u01ed\u01ee\b\33\1\2\u01ee\u01f0\3\2\2\2\u01ef\u01d4\3\2\2\2\u01ef"+
		"\u01d7\3\2\2\2\u01ef\u01da\3\2\2\2\u01ef\u01dd\3\2\2\2\u01ef\u01e0\3\2"+
		"\2\2\u01ef\u01e3\3\2\2\2\u01ef\u01e6\3\2\2\2\u01ef\u01e9\3\2\2\2\u01ef"+
		"\u01ec\3\2\2\2\u01f0\65\3\2\2\2\u01f1\u01f2\58\35\2\u01f2\u01f7\b\34\1"+
		"\2\u01f3\u01f4\7#\2\2\u01f4\u01f5\5\66\34\2\u01f5\u01f6\b\34\1\2\u01f6"+
		"\u01f8\3\2\2\2\u01f7\u01f3\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\67\3\2\2"+
		"\2\u01f9\u01fa\5:\36\2\u01fa\u0201\b\35\1\2\u01fb\u01fc\7\24\2\2\u01fc"+
		"\u01fd\5:\36\2\u01fd\u01fe\b\35\1\2\u01fe\u0200\3\2\2\2\u01ff\u01fb\3"+
		"\2\2\2\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202"+
		"9\3\2\2\2\u0203\u0201\3\2\2\2\u0204\u0205\5<\37\2\u0205\u020c\b\36\1\2"+
		"\u0206\u0207\7\23\2\2\u0207\u0208\5<\37\2\u0208\u0209\b\36\1\2\u0209\u020b"+
		"\3\2\2\2\u020a\u0206\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2\2\2\u020c"+
		"\u020d\3\2\2\2\u020d;\3\2\2\2\u020e\u020c\3\2\2\2\u020f\u0210\5> \2\u0210"+
		"\u0217\b\37\1\2\u0211\u0212\7\17\2\2\u0212\u0213\5> \2\u0213\u0214\b\37"+
		"\1\2\u0214\u0216\3\2\2\2\u0215\u0211\3\2\2\2\u0216\u0219\3\2\2\2\u0217"+
		"\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218=\3\2\2\2\u0219\u0217\3\2\2\2"+
		"\u021a\u021b\5@!\2\u021b\u0226\b \1\2\u021c\u021d\7\21\2\2\u021d\u021e"+
		"\5@!\2\u021e\u021f\b \1\2\u021f\u0225\3\2\2\2\u0220\u0221\7\22\2\2\u0221"+
		"\u0222\5@!\2\u0222\u0223\b \1\2\u0223\u0225\3\2\2\2\u0224\u021c\3\2\2"+
		"\2\u0224\u0220\3\2\2\2\u0225\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227"+
		"\3\2\2\2\u0227?\3\2\2\2\u0228\u0226\3\2\2\2\u0229\u022a\5B\"\2\u022a\u0235"+
		"\b!\1\2\u022b\u022c\7\13\2\2\u022c\u022d\5B\"\2\u022d\u022e\b!\1\2\u022e"+
		"\u0234\3\2\2\2\u022f\u0230\7\f\2\2\u0230\u0231\5B\"\2\u0231\u0232\b!\1"+
		"\2\u0232\u0234\3\2\2\2\u0233\u022b\3\2\2\2\u0233\u022f\3\2\2\2\u0234\u0237"+
		"\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236A\3\2\2\2\u0237"+
		"\u0235\3\2\2\2\u0238\u0239\5D#\2\u0239\u0244\b\"\1\2\u023a\u023b\7\r\2"+
		"\2\u023b\u023c\5D#\2\u023c\u023d\b\"\1\2\u023d\u0243\3\2\2\2\u023e\u023f"+
		"\7\16\2\2\u023f\u0240\5D#\2\u0240\u0241\b\"\1\2\u0241\u0243\3\2\2\2\u0242"+
		"\u023a\3\2\2\2\u0242\u023e\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2"+
		"\2\2\u0244\u0245\3\2\2\2\u0245C\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0248"+
		"\7\25\2\2\u0248\u0249\5D#\2\u0249\u024a\b#\1\2\u024a\u0253\3\2\2\2\u024b"+
		"\u024c\7\f\2\2\u024c\u024d\5D#\2\u024d\u024e\b#\1\2\u024e\u0253\3\2\2"+
		"\2\u024f\u0250\5F$\2\u0250\u0251\b#\1\2\u0251\u0253\3\2\2\2\u0252\u0247"+
		"\3\2\2\2\u0252\u024b\3\2\2\2\u0252\u024f\3\2\2\2\u0253E\3\2\2\2\u0254"+
		"\u0255\5H%\2\u0255\u0262\b$\1\2\u0256\u0257\7%\2\2\u0257\u0258\b$\1\2"+
		"\u0258\u0259\5\30\r\2\u0259\u025a\b$\1\2\u025a\u025b\7&\2\2\u025b\u0261"+
		"\3\2\2\2\u025c\u025d\7*\2\2\u025d\u025e\5R*\2\u025e\u025f\b$\1\2\u025f"+
		"\u0261\3\2\2\2\u0260\u0256\3\2\2\2\u0260\u025c\3\2\2\2\u0261\u0264\3\2"+
		"\2\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0270\3\2\2\2\u0264"+
		"\u0262\3\2\2\2\u0265\u0266\7\'\2\2\u0266\u0267\5\66\34\2\u0267\u0268\7"+
		"(\2\2\u0268\u0269\b$\1\2\u0269\u026f\3\2\2\2\u026a\u026b\7*\2\2\u026b"+
		"\u026c\5R*\2\u026c\u026d\b$\1\2\u026d\u026f\3\2\2\2\u026e\u0265\3\2\2"+
		"\2\u026e\u026a\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271"+
		"\3\2\2\2\u0271G\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0274\5N(\2\u0274\u0275"+
		"\b%\1\2\u0275\u0285\3\2\2\2\u0276\u0277\5R*\2\u0277\u0278\b%\1\2\u0278"+
		"\u0285\3\2\2\2\u0279\u027a\7%\2\2\u027a\u027b\5\30\r\2\u027b\u027c\7&"+
		"\2\2\u027c\u027d\b%\1\2\u027d\u0285\3\2\2\2\u027e\u027f\5J&\2\u027f\u0280"+
		"\b%\1\2\u0280\u0285\3\2\2\2\u0281\u0282\5L\'\2\u0282\u0283\b%\1\2\u0283"+
		"\u0285\3\2\2\2\u0284\u0273\3\2\2\2\u0284\u0276\3\2\2\2\u0284\u0279\3\2"+
		"\2\2\u0284\u027e\3\2\2\2\u0284\u0281\3\2\2\2\u0285I\3\2\2\2\u0286\u0287"+
		"\7\6\2\2\u0287\u0288\7%\2\2\u0288\u0289\5\66\34\2\u0289\u028a\7&\2\2\u028a"+
		"\u028b\b&\1\2\u028bK\3\2\2\2\u028c\u028d\7\b\2\2\u028d\u028e\7%\2\2\u028e"+
		"\u028f\5\66\34\2\u028f\u0290\7)\2\2\u0290\u0291\5\66\34\2\u0291\u0292"+
		"\7&\2\2\u0292\u0293\b\'\1\2\u0293M\3\2\2\2\u0294\u0295\5P)\2\u0295\u0296"+
		"\b(\1\2\u0296\u029a\3\2\2\2\u0297\u0298\7-\2\2\u0298\u029a\b(\1\2\u0299"+
		"\u0294\3\2\2\2\u0299\u0297\3\2\2\2\u029aO\3\2\2\2\u029b\u029c\7\26\2\2"+
		"\u029c\u02a0\b)\1\2\u029d\u029e\7\27\2\2\u029e\u02a0\b)\1\2\u029f\u029b"+
		"\3\2\2\2\u029f\u029d\3\2\2\2\u02a0Q\3\2\2\2\u02a1\u02a2\7.\2\2\u02a2\u02a3"+
		"\b*\1\2\u02a3S\3\2\2\2\u02a4\u02a5\7\32\2\2\u02a5\u02b5\b+\1\2\u02a6\u02a7"+
		"\7\33\2\2\u02a7\u02b5\b+\1\2\u02a8\u02a9\7\34\2\2\u02a9\u02aa\7$\2\2\u02aa"+
		"\u02ab\5T+\2\u02ab\u02ac\b+\1\2\u02ac\u02b5\3\2\2\2\u02ad\u02ae\7\35\2"+
		"\2\u02ae\u02af\5R*\2\u02af\u02b0\b+\1\2\u02b0\u02b5\3\2\2\2\u02b1\u02b2"+
		"\5V,\2\u02b2\u02b3\b+\1\2\u02b3\u02b5\3\2\2\2\u02b4\u02a4\3\2\2\2\u02b4"+
		"\u02a6\3\2\2\2\u02b4\u02a8\3\2\2\2\u02b4\u02ad\3\2\2\2\u02b4\u02b1\3\2"+
		"\2\2\u02b5U\3\2\2\2\u02b6\u02b7\7\36\2\2\u02b7\u02b8\b,\1\2\u02b8\u02c6"+
		"\7\22\2\2\u02b9\u02ba\7\5\2\2\u02ba\u02c7\b,\1\2\u02bb\u02bc\5T+\2\u02bc"+
		"\u02c3\b,\1\2\u02bd\u02be\7)\2\2\u02be\u02bf\5T+\2\u02bf\u02c0\b,\1\2"+
		"\u02c0\u02c2\3\2\2\2\u02c1\u02bd\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c1"+
		"\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6"+
		"\u02b9\3\2\2\2\u02c6\u02bb\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02ce\7\20"+
		"\2\2\u02c9\u02ca\5T+\2\u02ca\u02cb\b,\1\2\u02cb\u02cf\3\2\2\2\u02cc\u02cd"+
		"\7\5\2\2\u02cd\u02cf\b,\1\2\u02ce\u02c9\3\2\2\2\u02ce\u02cc\3\2\2\2\u02cf"+
		"\u02d0\3\2\2\2\u02d0\u02d1\7\21\2\2\u02d1W\3\2\2\2D[cnv\u008b\u0092\u0097"+
		"\u0099\u009e\u00ab\u00ba\u00c0\u00c8\u00ce\u00d2\u00dc\u00e4\u00ec\u00f7"+
		"\u0107\u010a\u0118\u011b\u0123\u0128\u012a\u0132\u0137\u013e\u0146\u014c"+
		"\u0150\u0156\u0161\u016b\u0171\u0183\u0185\u0193\u01a2\u01a9\u01b6\u01c2"+
		"\u01ef\u01f7\u0201\u020c\u0217\u0224\u0226\u0233\u0235\u0242\u0244\u0252"+
		"\u0260\u0262\u026e\u0270\u0284\u0299\u029f\u02b4\u02c3\u02c6\u02ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}