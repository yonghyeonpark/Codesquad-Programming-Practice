public class Controller {

    private final InputView inputView;
    private final Processor processor;

    public Controller(InputView inputView, Processor processor) {
        this.inputView = inputView;
        this.processor = processor;
    }

    public void run() {
        processor.setUp(inputView.readWord());
        processor.process();
    }
}
