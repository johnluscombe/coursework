// Generated from /home/johnluscombe/Documents/COS382/P03_Translator/src/QuizGen.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuizGenParser}.
 */
public interface QuizGenListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(QuizGenParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(QuizGenParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#o_block}.
	 * @param ctx the parse tree
	 */
	void enterO_block(QuizGenParser.O_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#o_block}.
	 * @param ctx the parse tree
	 */
	void exitO_block(QuizGenParser.O_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#more_options}.
	 * @param ctx the parse tree
	 */
	void enterMore_options(QuizGenParser.More_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#more_options}.
	 * @param ctx the parse tree
	 */
	void exitMore_options(QuizGenParser.More_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(QuizGenParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(QuizGenParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#q_blocks}.
	 * @param ctx the parse tree
	 */
	void enterQ_blocks(QuizGenParser.Q_blocksContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#q_blocks}.
	 * @param ctx the parse tree
	 */
	void exitQ_blocks(QuizGenParser.Q_blocksContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#q_block}.
	 * @param ctx the parse tree
	 */
	void enterQ_block(QuizGenParser.Q_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#q_block}.
	 * @param ctx the parse tree
	 */
	void exitQ_block(QuizGenParser.Q_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#i_choices}.
	 * @param ctx the parse tree
	 */
	void enterI_choices(QuizGenParser.I_choicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#i_choices}.
	 * @param ctx the parse tree
	 */
	void exitI_choices(QuizGenParser.I_choicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#i_choice}.
	 * @param ctx the parse tree
	 */
	void enterI_choice(QuizGenParser.I_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#i_choice}.
	 * @param ctx the parse tree
	 */
	void exitI_choice(QuizGenParser.I_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#c_choice}.
	 * @param ctx the parse tree
	 */
	void enterC_choice(QuizGenParser.C_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#c_choice}.
	 * @param ctx the parse tree
	 */
	void exitC_choice(QuizGenParser.C_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(QuizGenParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(QuizGenParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(QuizGenParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(QuizGenParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuizGenParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(QuizGenParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuizGenParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(QuizGenParser.StringContext ctx);
}