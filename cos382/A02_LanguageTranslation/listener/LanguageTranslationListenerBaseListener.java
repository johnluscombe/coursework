import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Enumeration;
import java.util.Hashtable;

public class LanguageTranslationListenerBaseListener implements LanguageTranslationListenerListener {

    private Hashtable<String, String> symbolTable = new Hashtable<>();

	@Override public void enterStart(LanguageTranslationListenerParser.StartContext ctx) { }

	@Override public void exitStart(LanguageTranslationListenerParser.StartContext ctx) {
	    System.out.println("eof");

	    if (!symbolTable.isEmpty()) {
            Enumeration<String> keys = symbolTable.keys();
            StringBuilder symbolTableString = new StringBuilder();

            while (keys.hasMoreElements()) {
                symbolTableString.append(keys.nextElement());
                symbolTableString.append(", ");
            }

            int deleteStart = symbolTableString.length() - 2;
            int deleteEnd = symbolTableString.length();
            symbolTableString.delete(deleteStart, deleteEnd);
            System.out.println("Symbol Table: " + symbolTableString.toString());

            System.out.println();
        }
    }

	@Override public void enterList(LanguageTranslationListenerParser.ListContext ctx) {
	    if (!ctx.getParent().isEmpty()) System.out.println(';');
    }

	@Override public void exitList(LanguageTranslationListenerParser.ListContext ctx) { }

	@Override public void enterExpr(LanguageTranslationListenerParser.ExprContext ctx) { }

	@Override public void exitExpr(LanguageTranslationListenerParser.ExprContext ctx) { }

	@Override public void enterTerms(LanguageTranslationListenerParser.TermsContext ctx) { }

	@Override public void exitTerms(LanguageTranslationListenerParser.TermsContext ctx) {
	    String part = ctx.getText();
	    if (!part.equals("")) {
	        System.out.print(part.charAt(0));
	        System.out.print(" ");
        }
    }

	@Override public void enterTerm(LanguageTranslationListenerParser.TermContext ctx) { }

	@Override public void exitTerm(LanguageTranslationListenerParser.TermContext ctx) { }

	@Override public void enterFactors(LanguageTranslationListenerParser.FactorsContext ctx) { }

	@Override public void exitFactors(LanguageTranslationListenerParser.FactorsContext ctx) {
	    String part = ctx.getText();
	    if (!part.equals("")) {
	        if (part.length() >= 3 && part.substring(0, 3).equals("MOD"))
	            System.out.print(part.substring(0, 3) + " ");
	        else {
	            System.out.print(part.charAt(0));
	            System.out.print(" ");
            }
        }
    }

	@Override public void enterFactor(LanguageTranslationListenerParser.FactorContext ctx) { }

	@Override public void exitFactor(LanguageTranslationListenerParser.FactorContext ctx) {
        String part = ctx.getText();
        if (ctx.ID() != null || ctx.NUM() != null) System.out.print(part + " ");
        if (ctx.ID() != null) symbolTable.put(part, "");
    }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }

	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }

	@Override public void visitErrorNode(ErrorNode node) { }
}