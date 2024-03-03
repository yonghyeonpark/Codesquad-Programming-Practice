public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new ConvertFactory(), new Clock(), new OutputView());
        controller.run();
    }
}
