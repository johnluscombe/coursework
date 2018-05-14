import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;

public class QuizGen {

    private static void checkArgs(String[] args) throws Exception {
        if (args.length < 3) { throw new Exception(); }
    }

    public static void main(String[] args) throws Exception {
        checkArgs(args);
        String fromFile = args[0];
        String toHTMLFile = args[1];
        String toJSFile = args[2];
        FileInputStream inputStream = new FileInputStream(fromFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        QuizGenLexer lexer = new QuizGenLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuizGenBaseListener listener = new QuizGenBaseListener(toHTMLFile, toJSFile);
        QuizGenParser parser = new QuizGenParser(tokens);
        parser.addParseListener(listener);
        parser.file();
    }
}
