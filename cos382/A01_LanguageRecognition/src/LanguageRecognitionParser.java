// Generated from /Users/johnluscombe/Documents/COS382/A01/LanguageRecognition.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageRecognitionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, Digit=7, Letter=8, WS=9;
	public static final int
		RULE_s = 0, RULE_b = 1, RULE_r = 2, RULE_x = 3, RULE_c = 4, RULE_v = 5, 
		RULE_l = 6, RULE_t = 7, RULE_o = 8, RULE_d = 9, RULE_n = 10;
	public static final String[] ruleNames = {
		"s", "b", "r", "x", "c", "v", "l", "t", "o", "d", "n"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "','", "'-'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "Digit", "Letter", "WS"
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
	public String getGrammarFileName() { return "LanguageRecognition.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageRecognitionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SContext extends ParserRuleContext {
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public RContext r() {
			return getRuleContext(RContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			b();
			setState(23);
			r();
			setState(24);
			t();
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

	public static class BContext extends ParserRuleContext {
		public OContext o() {
			return getRuleContext(OContext.class,0);
		}
		public NContext n() {
			return getRuleContext(NContext.class,0);
		}
		public BContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitB(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BContext b() throws RecognitionException {
		BContext _localctx = new BContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_b);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			o();
			setState(27);
			n();
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

	public static class RContext extends ParserRuleContext {
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public List<RContext> r() {
			return getRuleContexts(RContext.class);
		}
		public RContext r(int i) {
			return getRuleContext(RContext.class,i);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_r);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Digit) {
				{
				setState(29);
				x();
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(30);
						match(T__0);
						setState(31);
						r();
						}
						} 
					}
					setState(36);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class XContext extends ParserRuleContext {
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public VContext v() {
			return getRuleContext(VContext.class,0);
		}
		public XContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitX(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XContext x() throws RecognitionException {
		XContext _localctx = new XContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_x);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			c();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(40);
				match(T__1);
				setState(41);
				v();
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

	public static class CContext extends ParserRuleContext {
		public DContext d() {
			return getRuleContext(DContext.class,0);
		}
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			d();
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

	public static class VContext extends ParserRuleContext {
		public LContext l() {
			return getRuleContext(LContext.class,0);
		}
		public List<VContext> v() {
			return getRuleContexts(VContext.class);
		}
		public VContext v(int i) {
			return getRuleContext(VContext.class,i);
		}
		public VContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_v; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitV(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitV(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VContext v() throws RecognitionException {
		VContext _localctx = new VContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_v);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			l();
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					match(T__2);
					setState(48);
					v();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class LContext extends ParserRuleContext {
		public List<DContext> d() {
			return getRuleContexts(DContext.class);
		}
		public DContext d(int i) {
			return getRuleContext(DContext.class,i);
		}
		public LContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_l; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LContext l() throws RecognitionException {
		LContext _localctx = new LContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_l);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			d();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(55);
				match(T__3);
				setState(56);
				d();
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

	public static class TContext extends ParserRuleContext {
		public NContext n() {
			return getRuleContext(NContext.class,0);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_t);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(59);
				match(T__4);
				setState(60);
				n();
				setState(61);
				match(T__5);
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

	public static class OContext extends ParserRuleContext {
		public TerminalNode Digit() { return getToken(LanguageRecognitionParser.Digit, 0); }
		public OContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterO(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitO(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitO(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OContext o() throws RecognitionException {
		OContext _localctx = new OContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_o);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Digit) {
				{
				setState(65);
				match(Digit);
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

	public static class DContext extends ParserRuleContext {
		public List<TerminalNode> Digit() { return getTokens(LanguageRecognitionParser.Digit); }
		public TerminalNode Digit(int i) {
			return getToken(LanguageRecognitionParser.Digit, i);
		}
		public DContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_d; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DContext d() throws RecognitionException {
		DContext _localctx = new DContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_d);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				match(Digit);
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Digit );
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

	public static class NContext extends ParserRuleContext {
		public List<TerminalNode> Letter() { return getTokens(LanguageRecognitionParser.Letter); }
		public TerminalNode Letter(int i) {
			return getToken(LanguageRecognitionParser.Letter, i);
		}
		public NContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).enterN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageRecognitionListener ) ((LanguageRecognitionListener)listener).exitN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageRecognitionVisitor ) return ((LanguageRecognitionVisitor<? extends T>)visitor).visitN(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NContext n() throws RecognitionException {
		NContext _localctx = new NContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_n);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				match(Letter);
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Letter );
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13Q\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\7\4#\n\4\f\4\16\4&\13\4"+
		"\5\4(\n\4\3\5\3\5\3\5\5\5-\n\5\3\6\3\6\3\7\3\7\3\7\7\7\64\n\7\f\7\16\7"+
		"\67\13\7\3\b\3\b\3\b\5\b<\n\b\3\t\3\t\3\t\3\t\5\tB\n\t\3\n\5\nE\n\n\3"+
		"\13\6\13H\n\13\r\13\16\13I\3\f\6\fM\n\f\r\f\16\fN\3\f\2\2\r\2\4\6\b\n"+
		"\f\16\20\22\24\26\2\2N\2\30\3\2\2\2\4\34\3\2\2\2\6\'\3\2\2\2\b)\3\2\2"+
		"\2\n.\3\2\2\2\f\60\3\2\2\2\168\3\2\2\2\20A\3\2\2\2\22D\3\2\2\2\24G\3\2"+
		"\2\2\26L\3\2\2\2\30\31\5\4\3\2\31\32\5\6\4\2\32\33\5\20\t\2\33\3\3\2\2"+
		"\2\34\35\5\22\n\2\35\36\5\26\f\2\36\5\3\2\2\2\37$\5\b\5\2 !\7\3\2\2!#"+
		"\5\6\4\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2\2\2"+
		"\'\37\3\2\2\2\'(\3\2\2\2(\7\3\2\2\2),\5\n\6\2*+\7\4\2\2+-\5\f\7\2,*\3"+
		"\2\2\2,-\3\2\2\2-\t\3\2\2\2./\5\24\13\2/\13\3\2\2\2\60\65\5\16\b\2\61"+
		"\62\7\5\2\2\62\64\5\f\7\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65"+
		"\66\3\2\2\2\66\r\3\2\2\2\67\65\3\2\2\28;\5\24\13\29:\7\6\2\2:<\5\24\13"+
		"\2;9\3\2\2\2;<\3\2\2\2<\17\3\2\2\2=>\7\7\2\2>?\5\26\f\2?@\7\b\2\2@B\3"+
		"\2\2\2A=\3\2\2\2AB\3\2\2\2B\21\3\2\2\2CE\7\t\2\2DC\3\2\2\2DE\3\2\2\2E"+
		"\23\3\2\2\2FH\7\t\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\25\3\2"+
		"\2\2KM\7\n\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\27\3\2\2\2\13"+
		"$\',\65;ADIN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}