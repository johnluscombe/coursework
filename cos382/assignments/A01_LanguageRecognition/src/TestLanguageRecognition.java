import org.antlr.v4.runtime.*;

import java.io.FileInputStream;

public class TestLanguageRecognition {
    public static void main(String[] args) throws Exception {
        FileInputStream inputstream = new FileInputStream("test.txt");
        ANTLRInputStream input = new ANTLRInputStream(inputstream);
        LanguageRecognitionLexer lexer = new LanguageRecognitionLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageRecognitionParser parser = new LanguageRecognitionParser(tokens);
        parser.s();
    }
}