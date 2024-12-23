package MiniJava.parser;

public class Parser {
    private TransitionHandlerFacade transitionHandlerFacade;

    public Parser() {
        transitionHandlerFacade = new TransitionHandlerFacade();
    }

    public void startParse(java.util.Scanner sc) {
        boolean finish = false;
        transitionHandlerFacade.initLookAhead();
        while (!finish) {
            try {
                finish = transitionHandlerFacade.handleNextToken();
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
        transitionHandlerFacade.printMemory();
    }
}
