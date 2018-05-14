// Generated from /Users/johnluscombe/Documents/COS382/A02/src/LanguageTranslationActions.g4 by ANTLR 4.6

    import java.util.Enumeration;
    import java.util.Hashtable;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageTranslationActionsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageTranslationActionsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationActionsParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LanguageTranslationActionsParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationActionsParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LanguageTranslationActionsParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationActionsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LanguageTranslationActionsParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationActionsParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(LanguageTranslationActionsParser.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationActionsParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LanguageTranslationActionsParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationActionsParser#factors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactors(LanguageTranslationActionsParser.FactorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationActionsParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LanguageTranslationActionsParser.FactorContext ctx);
}