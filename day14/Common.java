import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Common {

    public static boolean isFactor(int number, int potentialFactor) {
        return number % potentialFactor == 0;
    }

    // 불변성 객체 반환
    public static Set<Integer> factors(int number) {
        // vs range() => 마지막 인덱스 포함 여부 차이
        return IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(pod -> isFactor(number, pod))
                .flatMap(pod -> IntStream.of(pod, number / pod))
                .boxed().collect(Collectors.toUnmodifiableSet());
    }
}
