import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    private static final String PATH = "C:\\Users\\pyh\\Desktop\\codesquad\\day10\\log\\LogRecord.log";

    public void readFile(LogManager logManager) {
        try {
            Stream<String> lines = Files.lines(Paths.get(PATH));
            lines.forEach(logManager::storeLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
