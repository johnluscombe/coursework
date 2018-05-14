// Generated from /Users/johnluscombe/Documents/COS382/A02/src/LanguageTranslationListener.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageTranslationListenerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageTranslationListenerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationListenerParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LanguageTranslationListenerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationListenerParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LanguageTranslationListenerParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationListenerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LanguageTranslationListenerParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationListenerParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(LanguageTranslationListenerParser.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationListenerParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LanguageTranslationListenerParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationListenerParser#factors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactors(LanguageTranslationListenerParser.FactorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageTranslationListenerParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LanguageTranslationListenerParser.FactorContext ctx);
}