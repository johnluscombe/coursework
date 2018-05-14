// Generated from /home/johnluscombe/Documents/COS382/P03_Translator/src/QuizGen.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuizGenParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, DIGIT=6, LETTER=7, CHAR=8, HWS=9, 
		VWS=10;
	public static final int
		RULE_file = 0, RULE_o_block = 1, RULE_more_options = 2, RULE_option = 3, 
		RULE_q_blocks = 4, RULE_q_block = 5, RULE_i_choices = 6, RULE_i_choice = 7, 
		RULE_c_choice = 8, RULE_key = 9, RULE_value = 10, RULE_string = 11;
	public static final String[] ruleNames = {
		"file", "o_block", "more_options", "option", "q_blocks", "q_block", "i_choices", 
		"i_choice", "c_choice", "key", "value", "string"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'(OP)'", "'END'", "'|'", "'='", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "DIGIT", "LETTER", "CHAR", "HWS", 
		"VWS"
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
	public String getGrammarFileName() { return "QuizGen.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuizGenParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public O_blockContext o_block() {
			return getRuleContext(O_blockContext.class,0);
		}
		public Q_blocksContext q_blocks() {
			return getRuleContext(Q_blocksContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			o_block();
			setState(25);
			q_blocks();
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

	public static class O_blockContext extends ParserRuleContext {
		public More_optionsContext more_options() {
			return getRuleContext(More_optionsContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(QuizGenParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(QuizGenParser.VWS, i);
		}
		public O_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterO_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitO_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitO_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final O_blockContext o_block() throws RecognitionException {
		O_blockContext _localctx = new O_blockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_o_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(27);
				match(T__0);
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(28);
					match(VWS);
					}
					}
					setState(31); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VWS );
				setState(33);
				more_options();
				setState(34);
				match(T__1);
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(35);
					match(VWS);
					}
					}
					setState(38); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VWS );
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

	public static class More_optionsContext extends ParserRuleContext {
		public OptionContext option() {
			return getRuleContext(OptionContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(QuizGenParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(QuizGenParser.VWS, i);
		}
		public More_optionsContext more_options() {
			return getRuleContext(More_optionsContext.class,0);
		}
		public More_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_more_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterMore_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitMore_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitMore_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final More_optionsContext more_options() throws RecognitionException {
		More_optionsContext _localctx = new More_optionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_more_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			option();
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				match(VWS);
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VWS );
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(48);
				more_options();
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

	public static class OptionContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> HWS() { return getTokens(QuizGenParser.HWS); }
		public TerminalNode HWS(int i) {
			return getToken(QuizGenParser.HWS, i);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_option);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__2);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HWS) {
				{
				{
				setState(52);
				match(HWS);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			key();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HWS) {
				{
				{
				setState(59);
				match(HWS);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(T__3);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					match(HWS);
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(72);
			value();
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

	public static class Q_blocksContext extends ParserRuleContext {
		public Q_blockContext q_block() {
			return getRuleContext(Q_blockContext.class,0);
		}
		public Q_blocksContext q_blocks() {
			return getRuleContext(Q_blocksContext.class,0);
		}
		public Q_blocksContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_q_blocks; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterQ_blocks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitQ_blocks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitQ_blocks(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Q_blocksContext q_blocks() throws RecognitionException {
		Q_blocksContext _localctx = new Q_blocksContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_q_blocks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			q_block();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << LETTER) | (1L << CHAR) | (1L << HWS))) != 0)) {
				{
				setState(75);
				q_blocks();
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

	public static class Q_blockContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public List<I_choicesContext> i_choices() {
			return getRuleContexts(I_choicesContext.class);
		}
		public I_choicesContext i_choices(int i) {
			return getRuleContext(I_choicesContext.class,i);
		}
		public C_choiceContext c_choice() {
			return getRuleContext(C_choiceContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(QuizGenParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(QuizGenParser.VWS, i);
		}
		public Q_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_q_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterQ_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitQ_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitQ_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Q_blockContext q_block() throws RecognitionException {
		Q_blockContext _localctx = new Q_blockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_q_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			string();
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				match(VWS);
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VWS );
			setState(84);
			i_choices();
			setState(85);
			c_choice();
			setState(86);
			i_choices();
			setState(87);
			match(T__1);
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				match(VWS);
				}
				}
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VWS );
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

	public static class I_choicesContext extends ParserRuleContext {
		public I_choiceContext i_choice() {
			return getRuleContext(I_choiceContext.class,0);
		}
		public I_choicesContext i_choices() {
			return getRuleContext(I_choicesContext.class,0);
		}
		public I_choicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_i_choices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterI_choices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitI_choices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitI_choices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final I_choicesContext i_choices() throws RecognitionException {
		I_choicesContext _localctx = new I_choicesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_i_choices);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(93);
				i_choice();
				setState(94);
				i_choices();
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

	public static class I_choiceContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(QuizGenParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(QuizGenParser.VWS, i);
		}
		public I_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_i_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterI_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitI_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitI_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final I_choiceContext i_choice() throws RecognitionException {
		I_choiceContext _localctx = new I_choiceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_i_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__2);
			setState(99);
			string();
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(100);
				match(VWS);
				}
				}
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VWS );
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

	public static class C_choiceContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(QuizGenParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(QuizGenParser.VWS, i);
		}
		public C_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterC_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitC_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitC_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final C_choiceContext c_choice() throws RecognitionException {
		C_choiceContext _localctx = new C_choiceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_c_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__4);
			setState(106);
			string();
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				match(VWS);
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VWS );
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

	public static class KeyContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(QuizGenParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(QuizGenParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(QuizGenParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(QuizGenParser.DIGIT, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(QuizGenParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(QuizGenParser.CHAR, i);
		}
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(LETTER);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << LETTER) | (1L << CHAR))) != 0)) {
				{
				{
				setState(113);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << LETTER) | (1L << CHAR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(118);
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

	public static class ValueContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(QuizGenParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(QuizGenParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(QuizGenParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(QuizGenParser.DIGIT, i);
		}
		public List<TerminalNode> HWS() { return getTokens(QuizGenParser.HWS); }
		public TerminalNode HWS(int i) {
			return getToken(QuizGenParser.HWS, i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << LETTER) | (1L << HWS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << LETTER) | (1L << HWS))) != 0) );
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

	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(QuizGenParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(QuizGenParser.DIGIT, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(QuizGenParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(QuizGenParser.LETTER, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(QuizGenParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(QuizGenParser.CHAR, i);
		}
		public List<TerminalNode> HWS() { return getTokens(QuizGenParser.HWS); }
		public TerminalNode HWS(int i) {
			return getToken(QuizGenParser.HWS, i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuizGenListener ) ((QuizGenListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuizGenVisitor ) return ((QuizGenVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << LETTER) | (1L << CHAR) | (1L << HWS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << LETTER) | (1L << CHAR) | (1L << HWS))) != 0) );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f\u0084\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\6\3 \n\3\r\3\16\3!\3\3\3\3\3\3"+
		"\6\3\'\n\3\r\3\16\3(\5\3+\n\3\3\4\3\4\6\4/\n\4\r\4\16\4\60\3\4\5\4\64"+
		"\n\4\3\5\3\5\7\58\n\5\f\5\16\5;\13\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3"+
		"\5\3\5\7\5F\n\5\f\5\16\5I\13\5\3\5\3\5\3\6\3\6\5\6O\n\6\3\7\3\7\6\7S\n"+
		"\7\r\7\16\7T\3\7\3\7\3\7\3\7\3\7\6\7\\\n\7\r\7\16\7]\3\b\3\b\3\b\5\bc"+
		"\n\b\3\t\3\t\3\t\6\th\n\t\r\t\16\ti\3\n\3\n\3\n\6\no\n\n\r\n\16\np\3\13"+
		"\3\13\7\13u\n\13\f\13\16\13x\13\13\3\f\6\f{\n\f\r\f\16\f|\3\r\6\r\u0080"+
		"\n\r\r\r\16\r\u0081\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\3\2\b"+
		"\n\4\2\b\t\13\13\3\2\b\13\2\u0088\2\32\3\2\2\2\4*\3\2\2\2\6,\3\2\2\2\b"+
		"\65\3\2\2\2\nL\3\2\2\2\fP\3\2\2\2\16b\3\2\2\2\20d\3\2\2\2\22k\3\2\2\2"+
		"\24r\3\2\2\2\26z\3\2\2\2\30\177\3\2\2\2\32\33\5\4\3\2\33\34\5\n\6\2\34"+
		"\3\3\2\2\2\35\37\7\3\2\2\36 \7\f\2\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2"+
		"\2!\"\3\2\2\2\"#\3\2\2\2#$\5\6\4\2$&\7\4\2\2%\'\7\f\2\2&%\3\2\2\2\'(\3"+
		"\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*\35\3\2\2\2*+\3\2\2\2+\5\3\2\2\2"+
		",.\5\b\5\2-/\7\f\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61"+
		"\63\3\2\2\2\62\64\5\6\4\2\63\62\3\2\2\2\63\64\3\2\2\2\64\7\3\2\2\2\65"+
		"9\7\5\2\2\668\7\13\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:"+
		"<\3\2\2\2;9\3\2\2\2<@\5\24\13\2=?\7\13\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2"+
		"\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CG\7\6\2\2DF\7\13\2\2ED\3\2\2\2FI\3\2"+
		"\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\5\26\f\2K\t\3\2\2\2LN\5"+
		"\f\7\2MO\5\n\6\2NM\3\2\2\2NO\3\2\2\2O\13\3\2\2\2PR\5\30\r\2QS\7\f\2\2"+
		"RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\5\16\b\2WX\5\22\n"+
		"\2XY\5\16\b\2Y[\7\4\2\2Z\\\7\f\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3"+
		"\2\2\2^\r\3\2\2\2_`\5\20\t\2`a\5\16\b\2ac\3\2\2\2b_\3\2\2\2bc\3\2\2\2"+
		"c\17\3\2\2\2de\7\5\2\2eg\5\30\r\2fh\7\f\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2"+
		"\2\2ij\3\2\2\2j\21\3\2\2\2kl\7\7\2\2ln\5\30\r\2mo\7\f\2\2nm\3\2\2\2op"+
		"\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\23\3\2\2\2rv\7\t\2\2su\t\2\2\2ts\3\2\2\2"+
		"ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\25\3\2\2\2xv\3\2\2\2y{\t\3\2\2zy\3\2\2"+
		"\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\27\3\2\2\2~\u0080\t\4\2\2\177~\3\2\2"+
		"\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\31"+
		"\3\2\2\2\23!(*\60\639@GNT]bipv|\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}