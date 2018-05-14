// Generated from /Users/johnluscombe/Documents/COS382/A01/LanguageRecognition.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageRecognitionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageRecognitionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(LanguageRecognitionParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitB(LanguageRecognitionParser.BContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(LanguageRecognitionParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(LanguageRecognitionParser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(LanguageRecognitionParser.CContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#v}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitV(LanguageRecognitionParser.VContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#l}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitL(LanguageRecognitionParser.LContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(LanguageRecognitionParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#o}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitO(LanguageRecognitionParser.OContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#d}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitD(LanguageRecognitionParser.DContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageRecognitionParser#n}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN(LanguageRecognitionParser.NContext ctx);
}