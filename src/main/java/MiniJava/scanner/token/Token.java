package MiniJava.scanner.token;

import MiniJava.scanner.type.Type;

public class Token {
    public Type type;
    public String value;

    private final static PatternMatcherFacade patternMatcherFacade;

    static {
        patternMatcherFacade = new PatternMatcherFacade();
    }

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", type.name(), value);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Token) {
            Token temp = (Token) o;
            if (temp.type == this.type) {
                return this.type != Type.KEYWORDS || this.value.equals(temp.value);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = type.hashCode();
        if (type == Type.KEYWORDS) result = prime * result + (value == null ? 0 : value.hashCode());
        return result;
    }

    public static Type getTyepFormString(String s) {
        for (Type t : Type.values()) {
            if (t.toString().equals(s)) return t;
        }
        for (Type t : Type.values()) {
            if (patternMatcherFacade.checkPattern(t.pattern, s)) return t;
        }

        throw new IllegalArgumentException();
    }
}
