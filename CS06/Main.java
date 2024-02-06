public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Game game = new Game();
        Controller controller = new Controller(inputView, game);
        controller.run();
    }
}