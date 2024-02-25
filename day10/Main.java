public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new FileReader(), new LogManager(new LogRepository()), new InputView());
        controller.run();
    }
}
