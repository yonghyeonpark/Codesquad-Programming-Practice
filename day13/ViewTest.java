import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restore() {
        System.setOut(standardOut);
        System.out.println(outputStream.toString());
    }

    @Test   
    void 예제1_출력결과() {
        Processor processor = new Processor();
        processor.setUp("1");
        processor.process();

        String[] view = outputStream.toString().split(System.lineSeparator());

        assertThat(view).containsExactly(
                "[\"0x08000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                "\"0x18000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                "\"0x08000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                "\"0x08000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                "\"0x08000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                "\"0x08000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                "\"0x08000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                "\"0x1C000000\", \"0x00000000\", \"0x00000000\", \"0x00000000\"]");
    }

    @Test
    void 예제2_출력결과() {
        Processor processor = new Processor();
        processor.setUp("*23");
        processor.process();

        String[] view = outputStream.toString().split(System.lineSeparator());

        assertThat(view).containsExactly(
                "[\"0x003C7E00\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00428100\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00810200\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00021C00\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x001C0200\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00200100\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00408100\", \"0x00000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00FF7E00\", \"0x00000000\", \"0x00000000\", \"0x00000000\"]");
    }

    @Test
    void 예제3_출력결과() {
        Processor processor = new Processor();
        processor.setUp("45678");
        processor.process();

        String[] view = outputStream.toString().split(System.lineSeparator());

        assertThat(view).containsExactly(
                "[\"0x04FF7E7F\", \"0x7E000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x0C808002\", \"0x81000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x14808004\", \"0x81000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x24FC8008\", \"0x7E000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x4402FE10\", \"0x81000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x84018120\", \"0x81000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0xFF818140\", \"0x81000000\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x047E7E00\", \"0x7E000000\", \"0x00000000\", \"0x00000000\"]");
    }

    @Test
    void 예제4_출력결과() {
        Processor processor = new Processor();
        processor.setUp("*9*2*3*4");
        processor.process();

        String[] view = outputStream.toString().split(System.lineSeparator());

        assertThat(view).containsExactly(
                "[\"0x007E003C\", \"0x007E0004\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00810042\", \"0x0081000C\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00810081\", \"0x00020014\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00810002\", \"0x001C0024\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00FF001C\", \"0x00020044\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00010020\", \"0x00010084\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x00010040\", \"0x008100FF\", \"0x00000000\", \"0x00000000\", \n" +
                        "\"0x007E00FF\", \"0x007E0004\", \"0x00000000\", \"0x00000000\"]");
    }

    @Test
    void 예제5_출력결과() {
        Processor processor = new Processor();
        processor.setUp("*111*222*333*444*555*666*777*888");
        processor.process();

        String[] view = outputStream.toString().split(System.lineSeparator());

        assertThat(view).containsExactly(
                "[\"0x00080808\", \"0x003C3C3C\", \"0x007E7E7E\", \"0x00040404\", \n" +
                        "\"0x00181818\", \"0x00424242\", \"0x00818181\", \"0x000C0C0C\", \n" +
                        "\"0x00080808\", \"0x00818181\", \"0x00020202\", \"0x00141414\", \n" +
                        "\"0x00080808\", \"0x00020202\", \"0x001C1C1C\", \"0x00242424\", \n" +
                        "\"0x00080808\", \"0x001C1C1C\", \"0x00020202\", \"0x00444444\", \n" +
                        "\"0x00080808\", \"0x00202020\", \"0x00010101\", \"0x00848484\", \n" +
                        "\"0x00080808\", \"0x00404040\", \"0x00818181\", \"0x00FFFFFF\", \n" +
                        "\"0x001C1C1C\", \"0x00FFFFFF\", \"0x007E7E7E\", \"0x00040404\", \n" +
                        "\"0x00FFFFFF\", \"0x007E7E7E\", \"0x007F7F7F\", \"0x007E7E7E\", \n" +
                        "\"0x00808080\", \"0x00808080\", \"0x00020202\", \"0x00818181\", \n" +
                        "\"0x00808080\", \"0x00808080\", \"0x00040404\", \"0x00818181\", \n" +
                        "\"0x00FCFCFC\", \"0x00808080\", \"0x00080808\", \"0x007E7E7E\", \n" +
                        "\"0x00020202\", \"0x00FEFEFE\", \"0x00101010\", \"0x00818181\", \n" +
                        "\"0x00010101\", \"0x00818181\", \"0x00202020\", \"0x00818181\", \n" +
                        "\"0x00818181\", \"0x00818181\", \"0x00404040\", \"0x00818181\", \n" +
                        "\"0x007E7E7E\", \"0x007E7E7E\", \"0x00000000\", \"0x007E7E7E\"]");
    }
}
