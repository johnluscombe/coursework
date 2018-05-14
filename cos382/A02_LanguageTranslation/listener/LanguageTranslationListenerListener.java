// Generated from /Users/johnluscombe/Documents/COS382/A02/src/LanguageTranslationListener.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageTranslationListenerParser}.
 */
public interface LanguageTranslationListenerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationListenerParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LanguageTranslationListenerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationListenerParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LanguageTranslationListenerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationListenerParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(LanguageTranslationListenerParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationListenerParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(LanguageTranslationListenerParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LanguageTranslationListenerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LanguageTranslationListenerParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationListenerParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(LanguageTranslationListenerParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationListenerParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(LanguageTranslationListenerParser.TermsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationListenerParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LanguageTranslationListenerParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationListenerParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LanguageTranslationListenerParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationListenerParser#factors}.
	 * @param ctx the parse tree
	 */
	void enterFactors(LanguageTranslationListenerParser.FactorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationListenerParser#factors}.
	 * @param ctx the parse tree
	 */
	void exitFactors(LanguageTranslationListenerParser.FactorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationListenerParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LanguageTranslationListenerParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationListenerParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LanguageTranslationListenerParser.FactorContext ctx);
}