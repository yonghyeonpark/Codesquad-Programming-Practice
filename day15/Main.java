public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new DecodingDataFactory(), new Moving());
        controller.run();
    }
}
