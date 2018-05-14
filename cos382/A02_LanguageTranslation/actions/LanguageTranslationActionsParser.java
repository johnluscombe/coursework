// Generated from /Users/johnluscombe/Documents/COS382/A02/src/LanguageTranslationActions.g4 by ANTLR 4.6

    import java.util.Enumeration;
    import java.util.Hashtable;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageTranslationActionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ID=10, NUM=11, DIGIT=12, LETTER=13, WS=14;
	public static final int
		RULE_start = 0, RULE_list = 1, RULE_expr = 2, RULE_terms = 3, RULE_term = 4, 
		RULE_factors = 5, RULE_factor = 6;
	public static final String[] ruleNames = {
		"start", "list", "expr", "terms", "term", "factors", "factor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'EOF'", "';'", "'+'", "'-'", "'*'", "'/'", "'MOD'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "ID", "NUM", 
		"DIGIT", "LETTER", "WS"
	};
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
	public String getGrammarFileName() { return "LanguageTranslationActions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageTranslationActionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public Hashtable<String, String> symbolTable = new Hashtable<>();;
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationActionsVisitor ) return ((LanguageTranslationActionsVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			list();
			System.out.println("eof");
			setState(16);
			match(T__0);

			        Enumeration<String> keys = ((StartContext)getInvokingContext(0)).symbolTable.keys();
			        StringBuilder symbolTableString = new StringBuilder();

			        while (keys.hasMoreElements()) {
			            symbolTableString.append(keys.nextElement());
			            symbolTableString.append(", ");
			        }

			        int deleteStart = symbolTableString.length()-2;
			        int deleteEnd = symbolTableString.length();
			        symbolTableString.delete(deleteStart, deleteEnd);
			        System.out.println("Symbol Table: " + symbolTableString.toString());

			        System.out.println();
			    
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

	public static class ListContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationActionsVisitor ) return ((LanguageTranslationActionsVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				setState(19);
				expr();
				setState(20);
				match(T__1);
				System.out.println(";");
				setState(22);
				list();
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

	public static class ExprContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationActionsVisitor ) return ((LanguageTranslationActionsVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			term();
			setState(27);
			terms();
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

	public static class TermsContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationActionsVisitor ) return ((LanguageTranslationActionsVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_terms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(29);
				match(T__2);
				setState(30);
				term();
				System.out.print("+ ");
				setState(32);
				terms();
				}
				break;
			case T__3:
				{
				setState(34);
				match(T__3);
				setState(35);
				term();
				System.out.print("- ");
				setState(37);
				terms();
				}
				break;
			case T__1:
			case T__8:
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorsContext factors() {
			return getRuleContext(FactorsContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationActionsVisitor ) return ((LanguageTranslationActionsVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			factor();
			setState(42);
			factors();
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

	public static class FactorsContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorsContext factors() {
			return getRuleContext(FactorsContext.class,0);
		}
		public FactorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).enterFactors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).exitFactors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationActionsVisitor ) return ((LanguageTranslationActionsVisitor<? extends T>)visitor).visitFactors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorsContext factors() throws RecognitionException {
		FactorsContext _localctx = new FactorsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factors);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(44);
				match(T__4);
				setState(45);
				factor();
				System.out.print("* ");
				setState(47);
				factors();
				}
				break;
			case T__5:
				{
				setState(49);
				match(T__5);
				setState(50);
				factor();
				System.out.print("/ ");
				setState(52);
				factors();
				}
				break;
			case T__6:
				{
				setState(54);
				match(T__6);
				setState(55);
				factor();
				System.out.print("MOD ");
				setState(57);
				factors();
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__8:
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

	public static class FactorContext extends ParserRuleContext {
		public Token ID;
		public Token NUM;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(LanguageTranslationActionsParser.ID, 0); }
		public TerminalNode NUM() { return getToken(LanguageTranslationActionsParser.NUM, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationActionsListener ) ((LanguageTranslationActionsListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationActionsVisitor ) return ((LanguageTranslationActionsVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_factor);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(T__7);
				setState(62);
				expr();
				setState(63);
				match(T__8);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				((FactorContext)_localctx).ID = match(ID);

				                System.out.print((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null) + " ");
				                ((StartContext)getInvokingContext(0)).symbolTable.put((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null), "");
				            
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				((FactorContext)_localctx).NUM = match(NUM);
				System.out.print((((FactorContext)_localctx).NUM!=null?((FactorContext)_localctx).NUM.getText():null) + " ");
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20J\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5*\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7>\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bH\n\b\3"+
		"\b\2\2\t\2\4\6\b\n\f\16\2\2J\2\20\3\2\2\2\4\32\3\2\2\2\6\34\3\2\2\2\b"+
		")\3\2\2\2\n+\3\2\2\2\f=\3\2\2\2\16G\3\2\2\2\20\21\5\4\3\2\21\22\b\2\1"+
		"\2\22\23\7\3\2\2\23\24\b\2\1\2\24\3\3\2\2\2\25\26\5\6\4\2\26\27\7\4\2"+
		"\2\27\30\b\3\1\2\30\31\5\4\3\2\31\33\3\2\2\2\32\25\3\2\2\2\32\33\3\2\2"+
		"\2\33\5\3\2\2\2\34\35\5\n\6\2\35\36\5\b\5\2\36\7\3\2\2\2\37 \7\5\2\2 "+
		"!\5\n\6\2!\"\b\5\1\2\"#\5\b\5\2#*\3\2\2\2$%\7\6\2\2%&\5\n\6\2&\'\b\5\1"+
		"\2\'(\5\b\5\2(*\3\2\2\2)\37\3\2\2\2)$\3\2\2\2)*\3\2\2\2*\t\3\2\2\2+,\5"+
		"\16\b\2,-\5\f\7\2-\13\3\2\2\2./\7\7\2\2/\60\5\16\b\2\60\61\b\7\1\2\61"+
		"\62\5\f\7\2\62>\3\2\2\2\63\64\7\b\2\2\64\65\5\16\b\2\65\66\b\7\1\2\66"+
		"\67\5\f\7\2\67>\3\2\2\289\7\t\2\29:\5\16\b\2:;\b\7\1\2;<\5\f\7\2<>\3\2"+
		"\2\2=.\3\2\2\2=\63\3\2\2\2=8\3\2\2\2=>\3\2\2\2>\r\3\2\2\2?@\7\n\2\2@A"+
		"\5\6\4\2AB\7\13\2\2BH\3\2\2\2CD\7\f\2\2DH\b\b\1\2EF\7\r\2\2FH\b\b\1\2"+
		"G?\3\2\2\2GC\3\2\2\2GE\3\2\2\2H\17\3\2\2\2\6\32)=G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}