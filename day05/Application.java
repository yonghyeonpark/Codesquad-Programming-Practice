public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Controller controller = new Controller(inputView);
        controller.run();
    }
}
