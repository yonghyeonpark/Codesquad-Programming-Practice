public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new Processor());
        controller.run();
    }
}
