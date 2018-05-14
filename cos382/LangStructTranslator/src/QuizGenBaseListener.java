import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Random;

public class QuizGenBaseListener implements QuizGenListener {

    private String mJSFilePath;

    private BufferedWriter mHTMLBufferedWriter;
    private BufferedWriter mJSBufferedWriter;

    private ArrayList<Integer> mQuestionNumbers;
	private ArrayList<String> mQuestionTexts;
	private ArrayList<ArrayList<String>> mChoiceTexts;
	private ArrayList<Character> mCorrectChoices;

	private int mCurrentQuestion;
	private ArrayList<String> mCurrentChoiceTexts;
	private char mCurrentChoice;

	// Options
    private String mQuizTitle;
	private boolean mScrambleQuestions;
	private boolean mScrambleChoices;
	private int mQuestionCount;

	public QuizGenBaseListener(String htmlFilePath, String jsFilePath) {
        FileWriter htmlFileWriter = getFileWriter(htmlFilePath);
        if (htmlFileWriter != null) {
            mHTMLBufferedWriter = new BufferedWriter(htmlFileWriter);
        }

        mJSFilePath = jsFilePath;
        FileWriter jsFileWriter = getFileWriter(mJSFilePath);
        if (jsFileWriter != null) {
            mJSBufferedWriter = new BufferedWriter(jsFileWriter);
        }

        mQuestionNumbers = new ArrayList<>();
        mQuestionTexts = new ArrayList<>();
        mChoiceTexts = new ArrayList<>();
        mCorrectChoices = new ArrayList<>();

        mCurrentQuestion = 1;
        mCurrentChoiceTexts = new ArrayList<>();
        mCurrentChoice = 'a';

        // Set default options
        mQuizTitle = "Untitled";
        mScrambleChoices = false;
        mScrambleQuestions = false;
    }

    private FileWriter getFileWriter(String filePath) {
        try {
            return new FileWriter(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override public void enterFile(QuizGenParser.FileContext ctx) {
        try {
            mHTMLBufferedWriter.write("<!DOCTYPE html>\n");
            mHTMLBufferedWriter.write("<html>\n");
            mHTMLBufferedWriter.write("<head>\n");
            mHTMLBufferedWriter.write(String.format("\t<script src=\"%s\"></script>\n", mJSFilePath));
            mHTMLBufferedWriter.write("\t<meta charset=\"utf-8\">\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override public void exitFile(QuizGenParser.FileContext ctx) {
        int idx;
        String question;
        ArrayList<String> choices;

        if (mScrambleQuestions) { shuffleArrayList(mQuestionNumbers); }
        if (mScrambleChoices) { shuffle2DArrayList(mChoiceTexts); }

        for (int questionNum : mQuestionNumbers) {
            idx = questionNum - 1;
            question = mQuestionTexts.get(idx);
            choices = mChoiceTexts.get(idx);
            writeQuestion(questionNum, question, choices);
        }

        try {
            mHTMLBufferedWriter.write("\t<input type=\"submit\" id=\"submit\" onClick=\"submitQuiz();\">\n");
            mHTMLBufferedWriter.write("</body>\n");
            mHTMLBufferedWriter.write("</html>\n");

            writeJavascript();

            mHTMLBufferedWriter.close();
            mJSBufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeQuestion (int questionNum, String question, ArrayList<String> choices) {
        try {
            char currentChoice = 'a';
            mHTMLBufferedWriter.write("\t<div>\n");
            mHTMLBufferedWriter.write(String.format("\t\t<p>%s</p>\n", question));

            for (String choice : choices) {
                mHTMLBufferedWriter.write(String.format(
                        "\t\t<input type=\"radio\" name=\"mc%s\" value=\"%s\">\n", questionNum, currentChoice
                ));

                mHTMLBufferedWriter.write(String.format(
                        "\t\t<label>%s</label><br>\n", choice
                ));

                currentChoice++;
            }

            mHTMLBufferedWriter.write("\t</div><br>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJavascript() {
        writeProblemNumbersArray();
        writeCorrectAnswersArray();
        writeCalcScoreFunction();
        writeSubmitQuizFunction();
    }

    private void writeProblemNumbersArray() {
        try {
            mJSBufferedWriter.write("var problemNumbers = [");

            for (int i = 0; i < mQuestionNumbers.size(); i++) {
                mJSBufferedWriter.write(Integer.toString(mQuestionNumbers.get(i)));
                if (i != mQuestionNumbers.size()-1) {
                    mJSBufferedWriter.write(", ");
                }
            }

            mJSBufferedWriter.write("];\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCorrectAnswersArray() {
	    try {
	        mJSBufferedWriter.write("var correctAnswers = [");

	        for (int i = 0; i < mCorrectChoices.size(); i++) {
	            mJSBufferedWriter.write("'");
	            mJSBufferedWriter.write(Character.toString(mCorrectChoices.get(i)));
	            mJSBufferedWriter.write("'");
	            if (i != mQuestionNumbers.size()-1) {
	                mJSBufferedWriter.write(", ");
                }
            }

            mJSBufferedWriter.write("];\n");
        } catch (IOException e) {
	        e.printStackTrace();
        }
    }

    private void writeCalcScoreFunction() {
        try {
            mJSBufferedWriter.write("\nfunction calcScore() {\n");
            mJSBufferedWriter.write("\tvar numCorrect = 0;\n\n");
            mJSBufferedWriter.write("\tfor (var i = 0; i < problemNumbers.length; i++) {\n");
            mJSBufferedWriter.write("\t\tvar idx = problemNumbers[i]-1;\n");
            mJSBufferedWriter.write("\t\tvar correctAnswer = correctAnswers[idx];\n\n");
            mJSBufferedWriter.write("\t\tvar selectedElement;\n");
            mJSBufferedWriter.write("\t\tvar correctElement;\n");
            mJSBufferedWriter.write("\t\tvar choices = document.getElementsByName(\"mc\"+problemNumbers[i]);\n");
            mJSBufferedWriter.write("\t\tfor (var j = 0; j < choices.length; j++) {\n");
            mJSBufferedWriter.write("\t\t\tif (choices[j].checked) {\n");
            mJSBufferedWriter.write("\t\t\t\tselectedElement = choices[j];\n");
            mJSBufferedWriter.write("\t\t\t}\n\n");
            mJSBufferedWriter.write("\t\t\tif (choices[j].value === correctAnswer) {\n");
            mJSBufferedWriter.write("\t\t\t\tcorrectElement = choices[j];\n");
            mJSBufferedWriter.write("\t\t\t}\n");
            mJSBufferedWriter.write("\t\t}\n\n");
            mJSBufferedWriter.write("\t\tif (selectedElement.value === correctAnswer) {\n");
            mJSBufferedWriter.write("\t\t\tselectedElement.nextElementSibling.style.color = \"green\";\n");
            mJSBufferedWriter.write("\t\t\tnumCorrect++;\n");
            mJSBufferedWriter.write("\t\t} else {\n");
            mJSBufferedWriter.write("\t\t\tselectedElement.nextElementSibling.style.color = \"red\";\n");
            mJSBufferedWriter.write("\t\t\tcorrectElement.nextElementSibling.style.color = \"lightgreen\";\n");
            mJSBufferedWriter.write("\t\t}\n");
            mJSBufferedWriter.write("\t}\n\n");
            mJSBufferedWriter.write("\treturn numCorrect;\n}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeSubmitQuizFunction() {
        try {
            mJSBufferedWriter.write("\nfunction submitQuiz() {\n");
            mJSBufferedWriter.write("\tvar numCorrect = calcScore();\n");
            mJSBufferedWriter.write("\tvar total = problemNumbers.length;\n");
            mJSBufferedWriter.write("\tvar percent = Math.round(numCorrect/total*100);\n");
            mJSBufferedWriter.write("\tdocument.getElementById(\"grade\").innerHTML = `Your grade: ${numCorrect}/${total} (${percent}%)`;\n");
            mJSBufferedWriter.write("\tdocument.getElementById(\"gradeSection\").removeAttribute(\"hidden\");\n");
            mJSBufferedWriter.write("\tdocument.getElementById(\"submit\").style.visibility = \"hidden\"\n}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override public void enterO_block(QuizGenParser.O_blockContext ctx) { }

	@Override public void exitO_block(QuizGenParser.O_blockContext ctx) {
        try {
            mHTMLBufferedWriter.write(String.format("\t<title>%s</title>\n", mQuizTitle));
            mHTMLBufferedWriter.write("</head>\n\n");
            mHTMLBufferedWriter.write("<body>\n");
            mHTMLBufferedWriter.write(String.format("\t<h1>%s</h1>\n\n", mQuizTitle));
            mHTMLBufferedWriter.write("\t<div id=\"gradeSection\" hidden>\n");
            mHTMLBufferedWriter.write("\t\t<h3 id=\"grade\"></h3>\n");
            mHTMLBufferedWriter.write("\t</div>\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override public void enterMore_options(QuizGenParser.More_optionsContext ctx) { }

	@Override public void exitMore_options(QuizGenParser.More_optionsContext ctx) { }

	@Override public void enterOption(QuizGenParser.OptionContext ctx) { }

	@Override public void exitOption(QuizGenParser.OptionContext ctx) {
	    switch (ctx.key().getText()) {
            case "TITLE":
                mQuizTitle = ctx.value().getText();
                break;
            case "SCRAMBLE_CHOICES":
                mScrambleChoices = convertStringToBoolean("SCRAMBLE_CHOICES", ctx.value().getText());
                break;
            case "SCRAMBLE_QUESTIONS":
                mScrambleQuestions = convertStringToBoolean("SCRAMBLE_QUESTIONS", ctx.value().getText());
                break;
            case "QUESTION_COUNT":
                mQuestionCount = convertStringToInt("QUESTION_COUNT", ctx.value().getText());
                break;
        }
    }

    private boolean convertStringToBoolean(String key, String string) {
	    switch (string) {
            case "True":
                return true;
            case "False":
                return false;
            default:
                System.out.println(
                        String.format("WARNING: Invalid value \"%s\" for option %s. Ignoring option.", string, key)
                );
                return false;
        }
    }

    private int convertStringToInt(String key, String string) {
	    try {
	        int integer = Integer.parseInt(string);

	        if (integer < 1) {
	            System.out.println("WARNING: Question count cannot be less than 1. Ignoring option.");
	            return 0;
            } else {
	            return integer;
            }

        } catch (Exception e) {
            System.out.println(
                    String.format("WARNING: Invalid value \"%s\" for option %s. Ignoring option.", string, key)
            );
            return 0;
        }
    }

	@Override public void enterQ_blocks(QuizGenParser.Q_blocksContext ctx) { }

	@Override public void exitQ_blocks(QuizGenParser.Q_blocksContext ctx) { }

	@Override public void enterQ_block(QuizGenParser.Q_blockContext ctx) { }

	@Override public void exitQ_block(QuizGenParser.Q_blockContext ctx) {
	    if (mQuestionCount == 0 || mQuestionNumbers.size() < mQuestionCount) {
            mQuestionNumbers.add(mCurrentQuestion);
            mQuestionTexts.add(ctx.string().getText());
            mChoiceTexts.add(mCurrentChoiceTexts);
            mCurrentChoiceTexts = new ArrayList<>();
            mCurrentQuestion++;
            mCurrentChoice = 'a';
        }
    }

    private void shuffle2DArrayList(ArrayList<ArrayList<String>> arrayList2D) {
	    for (ArrayList arrayList : arrayList2D) {
	        shuffleArrayList(arrayList);
        }
    }

    private void shuffleArrayList(ArrayList arrayList) {
	    int size = arrayList.size();
	    int toIndex;
        Random random = new Random();

        for (int fromIndex = 0; fromIndex < size; fromIndex++) {
            toIndex = random.nextInt(size);
            swap(arrayList, fromIndex, toIndex);
        }
    }

    private void swap(ArrayList arrayList, int fromIndex, int toIndex) {
	    Object temp = arrayList.get(fromIndex);
	    arrayList.set(fromIndex, arrayList.get(toIndex));
	    arrayList.set(toIndex, temp);
    }

	@Override public void enterI_choices(QuizGenParser.I_choicesContext ctx) { }

	@Override public void exitI_choices(QuizGenParser.I_choicesContext ctx) { }

	@Override public void enterI_choice(QuizGenParser.I_choiceContext ctx) { }

	@Override public void exitI_choice(QuizGenParser.I_choiceContext ctx) {
        mCurrentChoiceTexts.add(ctx.string().getText());
	    mCurrentChoice++;
    }

	@Override public void enterC_choice(QuizGenParser.C_choiceContext ctx) { }

	@Override public void exitC_choice(QuizGenParser.C_choiceContext ctx) {
        mCurrentChoiceTexts.add(ctx.string().getText());
	    mCorrectChoices.add(mCurrentChoice);
        mCurrentChoice++;
    }

	@Override public void enterKey(QuizGenParser.KeyContext ctx) { }

	@Override public void exitKey(QuizGenParser.KeyContext ctx) { }

	@Override public void enterValue(QuizGenParser.ValueContext ctx) { }

	@Override public void exitValue(QuizGenParser.ValueContext ctx) { }

	@Override public void enterString(QuizGenParser.StringContext ctx) { }

	@Override public void exitString(QuizGenParser.StringContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }

	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }

	@Override public void visitErrorNode(ErrorNode node) { }
}