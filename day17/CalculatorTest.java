import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator calculator = new Calculator(new DateFactory());

    @Test
    void testEarthDay() {
        assertThat(calculator.calculateEarthDay("2024-01-01")).isEqualTo(738901);
        assertThat(calculator.calculateEarthDay("2024-02-01")).isEqualTo(738932);
        assertThat(calculator.calculateEarthDay("2024-03-01")).isEqualTo(738961);
        assertThat(calculator.calculateEarthDay("2025-03-01")).isEqualTo(739326);
    }

    @Test
    void testMarsDate() {
        assertThat(calculator.calculateMarsDate(738901)).isEqualTo(List.of(1105, 8, 14));
        assertThat(calculator.calculateMarsDate(738902)).isEqualTo(List.of(1105, 8, 15));
        assertThat(calculator.calculateMarsDate(739103)).isEqualTo(List.of(1105, 15, 21));
        assertThat(calculator.calculateMarsDate(739403)).isEqualTo(List.of(1106, 2, 14));
    }
}
