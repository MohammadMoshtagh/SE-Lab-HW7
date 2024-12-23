package MiniJava.parser;

import MiniJava.Log.Log;
import MiniJava.codeGenerator.CodeGenerator;
import MiniJava.errorHandler.ErrorHandler;
import MiniJava.scanner.lexicalAnalyzer;
import MiniJava.scanner.token.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class TransitionHandlerFacade {

    private Stack<Integer> parseStack;
    private lexicalAnalyzer lexicalAnalyzer;
    private ParseTable parseTable;
    private CodeGenerator codeGenerator;
    private ArrayList<Rule> rules;
    private Token lookAhead;

    public TransitionHandlerFacade() {
        this.codeGenerator = new CodeGenerator();

        initParseTable();
        initRules();
        initLexicalAnalyzer();
        initParseStack();
    }

    public void initLookAhead() {
        lookAhead = lexicalAnalyzer.getNextToken();
    }

    public boolean handleNextToken() {
        Log.print(lookAhead.toString() + "\t" + parseStack.peek());
        Action currentAction = parseTable.getActionTable(parseStack.peek(), lookAhead);
        Log.print(currentAction.toString());

        switch (currentAction.action) {
            case shift:
                parseStack.push(currentAction.number);
                lookAhead = lexicalAnalyzer.getNextToken();

                return false;
            case reduce:
                Rule rule = rules.get(currentAction.number);
                for (int i = 0; i < rule.RHS.size(); i++) {
                    parseStack.pop();
                }

                Log.print(parseStack.peek() + "\t" + rule.LHS);
                parseStack.push(parseTable.getGotoTable(parseStack.peek(), rule.LHS));
                Log.print(parseStack.peek() + "");
                try {
                    codeGenerator.semanticFunction(rule.semanticAction, lookAhead);
                } catch (Exception e) {
                    Log.print("Code Genetator Error");
                }
                return false;
            case accept:
                return true;
        }
        Log.print("");
        return false;
    }

    public void printMemory() {
        if (!ErrorHandler.hasError) codeGenerator.printMemory();
    }

    private void initParseTable() {
        try {
            parseTable = new ParseTable(Files.readAllLines(Paths.get("src/main/resources/parseTable")).get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initRules() {
        rules = new ArrayList<Rule>();
        try {
            for (String stringRule : Files.readAllLines(Paths.get("src/main/resources/Rules"))) {
                rules.add(new Rule(stringRule));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initParseStack() {
        this.parseStack = new Stack<>();
        parseStack.push(0);
    }

    private void initLexicalAnalyzer() {
        Scanner scanner = new Scanner(System.in);
        this.lexicalAnalyzer = new lexicalAnalyzer(scanner);
    }

}
