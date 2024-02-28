import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String result = IntStream.rangeClosed(2, 100)
                .mapToObj(number -> String.format("%d : %s", number, getResultString(number)))
                .reduce("", (prev, next) -> prev + "\n" + next);
        System.out.println(result);
    }

    private static String getResultString(int number) {
        StringBuilder result = new StringBuilder();
        if (NumberClassifier.perfectClassifier().classify(number)) {
            result.append("perfect, ");
        }
        if (NumberClassifier.abundantClassifier().classify(number)) {
            result.append("abundant, ");
        }
        if (NumberClassifier.deficientClassifier().classify(number)) {
            result.append("deficient, ");
        }
        if (NumberClassifier.primeClassifier().classify(number)) {
            result.append("prime, ");
        }
        if (NumberClassifier.squaredClassifier().classify(number)) {
            result.append("squared, ");
        }
        if (!result.isEmpty()) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }
}
