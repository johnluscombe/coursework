import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import java.io.FileInputStream;

public class ActionTest {
    public static void main(String[] args) throws Exception {
        FileInputStream inputstream = new FileInputStream("src/input.txt");
        ANTLRInputStream input = new ANTLRInputStream(inputstream);
        LanguageTranslationActionsLexer lexer = new LanguageTranslationActionsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageTranslationActionsParser parser = new LanguageTranslationActionsParser(tokens);
        parser.start();
    }
}
