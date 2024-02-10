public class MyStack {

    private final int[] stack;
    private int top;

    public MyStack() {
        this.stack = new int[8];
        top = -1;
    }

    public void push(int value) {
        top++;
        stack[top] = value;
    }

    public int pop() {
        int value = stack[top];
        stack[top] = 0;
        top--;
        return value;
    }

    public boolean isFull() {
        return top == 7;
    }

    public int getTop() {
        return top;
    }
}
