// Generated from /Users/johnluscombe/Documents/COS382/A02/src/LanguageTranslationListener.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageTranslationListenerParser extends Parser {
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
	public String getGrammarFileName() { return "LanguageTranslationListener.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageTranslationListenerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationListenerVisitor ) return ((LanguageTranslationListenerVisitor<? extends T>)visitor).visitStart(this);
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
			setState(15);
			match(T__0);
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
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationListenerVisitor ) return ((LanguageTranslationListenerVisitor<? extends T>)visitor).visitList(this);
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				setState(17);
				expr();
				setState(18);
				match(T__1);
				setState(19);
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
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationListenerVisitor ) return ((LanguageTranslationListenerVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			term();
			setState(24);
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
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationListenerVisitor ) return ((LanguageTranslationListenerVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_terms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(26);
				match(T__2);
				setState(27);
				term();
				setState(28);
				terms();
				}
				break;
			case T__3:
				{
				setState(30);
				match(T__3);
				setState(31);
				term();
				setState(32);
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
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationListenerVisitor ) return ((LanguageTranslationListenerVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			factor();
			setState(37);
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
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).enterFactors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).exitFactors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationListenerVisitor ) return ((LanguageTranslationListenerVisitor<? extends T>)visitor).visitFactors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorsContext factors() throws RecognitionException {
		FactorsContext _localctx = new FactorsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factors);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(39);
				match(T__4);
				setState(40);
				factor();
				setState(41);
				factors();
				}
				break;
			case T__5:
				{
				setState(43);
				match(T__5);
				setState(44);
				factor();
				setState(45);
				factors();
				}
				break;
			case T__6:
				{
				setState(47);
				match(T__6);
				setState(48);
				factor();
				setState(49);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(LanguageTranslationListenerParser.ID, 0); }
		public TerminalNode NUM() { return getToken(LanguageTranslationListenerParser.NUM, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageTranslationListenerListener ) ((LanguageTranslationListenerListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageTranslationListenerVisitor ) return ((LanguageTranslationListenerVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_factor);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__7);
				setState(54);
				expr();
				setState(55);
				match(T__8);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(ID);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(NUM);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\5\3\30\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5%\n\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\66\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b>\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2@\2\20\3\2\2"+
		"\2\4\27\3\2\2\2\6\31\3\2\2\2\b$\3\2\2\2\n&\3\2\2\2\f\65\3\2\2\2\16=\3"+
		"\2\2\2\20\21\5\4\3\2\21\22\7\3\2\2\22\3\3\2\2\2\23\24\5\6\4\2\24\25\7"+
		"\4\2\2\25\26\5\4\3\2\26\30\3\2\2\2\27\23\3\2\2\2\27\30\3\2\2\2\30\5\3"+
		"\2\2\2\31\32\5\n\6\2\32\33\5\b\5\2\33\7\3\2\2\2\34\35\7\5\2\2\35\36\5"+
		"\n\6\2\36\37\5\b\5\2\37%\3\2\2\2 !\7\6\2\2!\"\5\n\6\2\"#\5\b\5\2#%\3\2"+
		"\2\2$\34\3\2\2\2$ \3\2\2\2$%\3\2\2\2%\t\3\2\2\2&\'\5\16\b\2\'(\5\f\7\2"+
		"(\13\3\2\2\2)*\7\7\2\2*+\5\16\b\2+,\5\f\7\2,\66\3\2\2\2-.\7\b\2\2./\5"+
		"\16\b\2/\60\5\f\7\2\60\66\3\2\2\2\61\62\7\t\2\2\62\63\5\16\b\2\63\64\5"+
		"\f\7\2\64\66\3\2\2\2\65)\3\2\2\2\65-\3\2\2\2\65\61\3\2\2\2\65\66\3\2\2"+
		"\2\66\r\3\2\2\2\678\7\n\2\289\5\6\4\29:\7\13\2\2:>\3\2\2\2;>\7\f\2\2<"+
		">\7\r\2\2=\67\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\17\3\2\2\2\6\27$\65=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}