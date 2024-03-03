import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller {

    private final Convert convert;
    private final Clock clock;
    private final OutputView outputView;

    public Controller(ConvertFactory convertFactory, Clock clock, OutputView outputView) {
        this.convert = new Convert(convertFactory);
        this.clock = clock;
        this.outputView = outputView;
    }

    public void run() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> CompletableFuture.supplyAsync(LocalTime::now)
                .thenAcceptAsync((currentTime) -> {
                    convert.convert(currentTime);
                    clock.setClock(convert);
                    outputView.printClock(clock.getClock());
                }), 0, 1 , TimeUnit.SECONDS);
    }
}
