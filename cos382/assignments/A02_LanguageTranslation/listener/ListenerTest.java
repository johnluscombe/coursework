import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;

public class ListenerTest {
    public static void main(String[] args) throws Exception {
        FileInputStream inputstream = new FileInputStream("src/input.txt");
        ANTLRInputStream input = new ANTLRInputStream(inputstream);
        LanguageTranslationListenerLexer lexer = new LanguageTranslationListenerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageTranslationListenerBaseListener listener = new LanguageTranslationListenerBaseListener();
        LanguageTranslationListenerParser parser = new LanguageTranslationListenerParser(tokens);
        parser.addParseListener(listener);
        parser.start();
    }
}
