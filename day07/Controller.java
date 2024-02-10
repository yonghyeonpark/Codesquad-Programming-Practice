public class Controller {

    private Calculator calculator;

    // [PRINT, PUSH0, PRINT, POPA]
    // [PUSH1, PUSH1, PUSH2, POPA, POPB, SWAP, ADD, PRINT, PRINT]
    // [PUSH3, PUSH2, PUSH1, POPA, POPB, SWAP, SUB, POPA, POPB, ADD, PRINT]
    // [ADD, PUSH3, PUSH1, PUSH0, PUSH2, PUSH1, PUSH3, PUSH2, PUSH0, PUSH3, PUSH4]

    public void run() {
        InputView inputView = new InputView();
        String[] commands = inputView.readCommands();
        calculator = new Calculator(new MyStack(), new Register(), new Register());

        for (String command : commands) {
            checkCommand(command);
        }
        System.out.println(calculator.toString());
    }

    private void checkCommand(String command) {
        if (command.equals("POPA")) {
            calculator.popA();
            return;
        }
        if (command.equals("POPB")) {
            calculator.popB();
            return;
        }
        if (command.equals("ADD")) {
            calculator.add();
            return;
        }
        if (command.equals("SUB")) {
            calculator.sub();
            return;
        }
        if (command.contains("PUSH")) {
            int pushValue = Character.getNumericValue(command.charAt(command.length() - 1));
            calculator.push(pushValue);
            return;
        }
        if (command.equals("SWAP")) {
            calculator.swap();
            return;
        }
        if (command.equals("PRINT")) {
            calculator.print();
            return;
        }
        calculator.handleException();
    }
}
