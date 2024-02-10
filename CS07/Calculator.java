import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final MyStack stack;
    private final Register a;
    private final Register b;
    private final List<String> result;

    public Calculator(MyStack stack, Register a, Register b) {
        this.stack = stack;
        this.a = a;
        this.b = b;
        result = new ArrayList<>();
    }

    public void popA() {
        if (stack.getTop() == -1) {
            result.add("EMPTY");
            return;
        }
        a.addValue(stack.pop());
    }

    public void popB() {
        if (stack.getTop() == -1) {
            result.add("EMPTY");
            return;
        }
        b.addValue(stack.pop());
    }

    public void add() {
        if (a.getValue() == -1 || b.getValue() == -1) {
            result.add("ERROR");
            return;
        }
        stack.push(a.getValue() + b.getValue());
    }

    public void sub() {
        if (a.getValue() == -1 || b.getValue() == -1) {
            result.add("ERROR");
            return;
        }
        stack.push(a.getValue() - b.getValue());
    }

    public void push(int value) {
        if (value > 3) {
            handleException();
            return;
        }
        if (stack.isFull()) {
            result.add("OVERFLOW");
            return;
        }
        stack.push(value);
    }

    public void swap() {
        if (a.getValue() == -1 || b.getValue() == -1) {
            result.add("ERROR");
            return;
        }
        int tem = a.getValue();
        a.addValue(b.getValue());
        b.addValue(tem);
    }

    public void print() {
        if (stack.getTop() == -1) {
            result.add("EMPTY");
            return;
        }
        result.add(String.valueOf(stack.pop()));
    }

    public void handleException() {
        result.add("UNKNOWN");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==> return [");
        for (String value : result) {
            sb.append("\"")
                    .append(value)
                    .append("\"")
                    .append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
