package MiniJava.scanner.token;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherFacade {

    public boolean checkPattern(String patternString, String input) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

}
