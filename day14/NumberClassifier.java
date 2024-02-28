import java.util.HashSet;
import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface NumberClassifier {

    boolean classify(int number);

    static NumberClassifier perfectClassifier() {
        return number -> sum(Common.factors(number)) - number == number;
    }

    static NumberClassifier abundantClassifier() {
        return number -> sum(Common.factors(number)) - number > number;
    }

    static NumberClassifier deficientClassifier() {
        return number -> sum(Common.factors(number)) - number < number;
    }

    static NumberClassifier primeClassifier() {
        return number -> number > 1 && Common.factors(number).equals(new HashSet<>(List.of(1, number)));
    }

    static NumberClassifier squaredClassifier() {
        return number -> Math.pow((int) Math.sqrt(number), 2) == number;
    }

    private static int sum(Set<Integer> factors) {
        return factors.stream()
                .reduce(0, Integer::sum);
    }
}
