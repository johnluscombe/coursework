// Generated from /Users/johnluscombe/Documents/COS382/A02/src/LanguageTranslationActions.g4 by ANTLR 4.6

    import java.util.Enumeration;
    import java.util.Hashtable;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageTranslationActionsParser}.
 */
public interface LanguageTranslationActionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationActionsParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LanguageTranslationActionsParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationActionsParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LanguageTranslationActionsParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationActionsParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(LanguageTranslationActionsParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationActionsParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(LanguageTranslationActionsParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationActionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LanguageTranslationActionsParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationActionsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LanguageTranslationActionsParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationActionsParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(LanguageTranslationActionsParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationActionsParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(LanguageTranslationActionsParser.TermsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationActionsParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LanguageTranslationActionsParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationActionsParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LanguageTranslationActionsParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationActionsParser#factors}.
	 * @param ctx the parse tree
	 */
	void enterFactors(LanguageTranslationActionsParser.FactorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationActionsParser#factors}.
	 * @param ctx the parse tree
	 */
	void exitFactors(LanguageTranslationActionsParser.FactorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageTranslationActionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LanguageTranslationActionsParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageTranslationActionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LanguageTranslationActionsParser.FactorContext ctx);
}