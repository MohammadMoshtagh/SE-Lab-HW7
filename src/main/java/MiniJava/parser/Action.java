package MiniJava.parser;

public abstract class Action {
    public act action;
    //if action = shift : number is state
    //if action = reduce : number is number of rule
    public int number;

    public Action(act action, int number) {
        this.action = action;
        this.number = number;
    }

    public abstract String toString();
}

class AcceptAction extends Action {
    public AcceptAction(act action, int number) {
        super(action, number);
    }

    public String toString() {
        return "acc";
    }
}

class ShiftAction extends Action {

    public ShiftAction(act action, int number) {
        super(action, number);
    }

    public String toString() {
        return "s" + number;
    }
}

class ReduceAction extends Action {

    public ReduceAction(act action, int number) {
        super(action, number);
    }

    public String toString() {
        return "r" + number;
    }
}

class DefaultAction extends Action {

    public DefaultAction(act action, int number) {
        super(action, number);
    }

    public String toString() {
        return action.toString() + number;
    }
}

enum act {
    shift, reduce, accept
}