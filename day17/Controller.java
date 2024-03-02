import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public Controller(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        String date = inputView.readDate();
        try {
            CompletableFuture<Integer> earthDayFuture = CompletableFuture.runAsync(outputView::printProgressBar)
                    .thenApplyAsync(result -> calculator.calculateEarthDay(date));
            CompletableFuture<Void> marsDateFuture = earthDayFuture
                    .thenApplyAsync(calculator::calculateMarsDate)
                    .thenAcceptAsync(marsDate -> outputView.printResult(earthDayFuture.join(), marsDate));
            marsDateFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}
