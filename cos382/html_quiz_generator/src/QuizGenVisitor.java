// Generated from /home/johnluscombe/Documents/COS382/P03_Translator/src/QuizGen.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuizGenParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuizGenVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(QuizGenParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#o_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitO_block(QuizGenParser.O_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#more_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMore_options(QuizGenParser.More_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(QuizGenParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#q_blocks}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQ_blocks(QuizGenParser.Q_blocksContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#q_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQ_block(QuizGenParser.Q_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#i_choices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_choices(QuizGenParser.I_choicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#i_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_choice(QuizGenParser.I_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#c_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC_choice(QuizGenParser.C_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(QuizGenParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(QuizGenParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuizGenParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(QuizGenParser.StringContext ctx);
}