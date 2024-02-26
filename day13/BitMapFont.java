import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum BitMapFont {

    ONE('1', setUpOne()),
    TWO('2', setUpTwo()),
    THREE('3', setUpThree()),
    FOUR('4', setUpFour()),
    FIVE('5', setUpFive()),
    SIX('6', setUpSix()),
    SEVEN('7', setUpSeven()),
    EIGHT('8', setUpEight()),
    NINE('9', setUpNine()),
    ZERO('0', setUpZero()),
    SPACE('*', setUpSpace());

    private final char name;
    private final Map<Integer, List<String>> content;

    BitMapFont(char name, Map<Integer, List<String>> content) {
        this.name = name;
        this.content = content;
    }

    private static Map<Integer, List<String>> setUpOne() {
        Map<Integer, List<String>> one = new HashMap<>();
        one.put(0, List.of("0000", "1000"));
        one.put(1, List.of("0001", "1000"));
        one.put(2, List.of("0000", "1000"));
        one.put(3, List.of("0000", "1000"));
        one.put(4, List.of("0000", "1000"));
        one.put(5, List.of("0000", "1000"));
        one.put(6, List.of("0000", "1000"));
        one.put(7, List.of("0001", "1100"));
        return one;
    }

    private static Map<Integer, List<String>> setUpTwo() {
        Map<Integer, List<String>> two = new HashMap<>();
        two.put(0, List.of("0011", "1100"));
        two.put(1, List.of("0100", "0010"));
        two.put(2, List.of("1000", "0001"));
        two.put(3, List.of("0000", "0010"));
        two.put(4, List.of("0001", "1100"));
        two.put(5, List.of("0010", "0000"));
        two.put(6, List.of("0100", "0000"));
        two.put(7, List.of("1111", "1111"));
        return two;
    }

    private static Map<Integer, List<String>> setUpThree() {
        Map<Integer, List<String>> three = new HashMap<>();
        three.put(0, List.of("0111", "1110"));
        three.put(1, List.of("1000", "0001"));
        three.put(2, List.of("0000", "0010"));
        three.put(3, List.of("0001", "1100"));
        three.put(4, List.of("0000", "0010"));
        three.put(5, List.of("0000", "0001"));
        three.put(6, List.of("1000", "0001"));
        three.put(7, List.of("0111", "1110"));
        return three;
    }

    private static Map<Integer, List<String>> setUpFour() {
        Map<Integer, List<String>> four = new HashMap<>();
        four.put(0, List.of("0000", "0100"));
        four.put(1, List.of("0000", "1100"));
        four.put(2, List.of("0001", "0100"));
        four.put(3, List.of("0010", "0100"));
        four.put(4, List.of("0100", "0100"));
        four.put(5, List.of("1000", "0100"));
        four.put(6, List.of("1111", "1111"));
        four.put(7, List.of("0000", "0100"));
        return four;
    }

    private static Map<Integer, List<String>> setUpFive() {
        Map<Integer, List<String>> five = new HashMap<>();
        five.put(0, List.of("1111", "1111"));
        five.put(1, List.of("1000", "0000"));
        five.put(2, List.of("1000", "0000"));
        five.put(3, List.of("1111", "1100"));
        five.put(4, List.of("0000", "0010"));
        five.put(5, List.of("0000", "0001"));
        five.put(6, List.of("1000", "0001"));
        five.put(7, List.of("0111", "1110"));
        return five;
    }

    private static Map<Integer, List<String>> setUpSix() {
        Map<Integer, List<String>> six = new HashMap<>();
        six.put(0, List.of("0111", "1110"));
        six.put(1, List.of("1000", "0000"));
        six.put(2, List.of("1000", "0000"));
        six.put(3, List.of("1000", "0000"));
        six.put(4, List.of("1111", "1110"));
        six.put(5, List.of("1000", "0001"));
        six.put(6, List.of("1000", "0001"));
        six.put(7, List.of("0111", "1110"));
        return six;
    }
    private static Map<Integer, List<String>> setUpSeven() {
        Map<Integer, List<String>> seven = new HashMap<>();
        seven.put(0, List.of("0111", "1111"));
        seven.put(1, List.of("0000", "0010"));
        seven.put(2, List.of("0000", "0100"));
        seven.put(3, List.of("0000", "1000"));
        seven.put(4, List.of("0001", "0000"));
        seven.put(5, List.of("0010", "0000"));
        seven.put(6, List.of("0100", "0000"));
        seven.put(7, List.of("0000", "0000"));
        return seven;
    }

    private static Map<Integer, List<String>> setUpEight() {
        Map<Integer, List<String>> eight = new HashMap<>();
        eight.put(0, List.of("0111", "1110"));
        eight.put(1, List.of("1000", "0001"));
        eight.put(2, List.of("1000", "0001"));
        eight.put(3, List.of("0111", "1110"));
        eight.put(4, List.of("1000", "0001"));
        eight.put(5, List.of("1000", "0001"));
        eight.put(6, List.of("1000", "0001"));
        eight.put(7, List.of("0111", "1110"));
        return eight;
    }

    private static Map<Integer, List<String>> setUpNine() {
        Map<Integer, List<String>> nine = new HashMap<>();
        nine.put(0, List.of("0111", "1110"));
        nine.put(1, List.of("1000", "0001"));
        nine.put(2, List.of("1000", "0001"));
        nine.put(3, List.of("1000", "0001"));
        nine.put(4, List.of("1111", "1111"));
        nine.put(5, List.of("0000", "0001"));
        nine.put(6, List.of("0000", "0001"));
        nine.put(7, List.of("0111", "1110"));
        return nine;
    }

    private static Map<Integer, List<String>> setUpZero() {
        Map<Integer, List<String>> zero = new HashMap<>();
        zero.put(0, List.of("0011", "1100"));
        zero.put(1, List.of("0100", "0010"));
        zero.put(2, List.of("1000", "0001"));
        zero.put(3, List.of("1000", "0001"));
        zero.put(4, List.of("1000", "0001"));
        zero.put(5, List.of("1000", "0001"));
        zero.put(6, List.of("0100", "0010"));
        zero.put(7, List.of("0011", "1100"));
        return zero;
    }

    private static Map<Integer, List<String>> setUpSpace() {
        Map<Integer, List<String>> space = new HashMap<>();
        space.put(0, List.of("0000", "0000"));
        space.put(1, List.of("0000", "0000"));
        space.put(2, List.of("0000", "0000"));
        space.put(3, List.of("0000", "0000"));
        space.put(4, List.of("0000", "0000"));
        space.put(5, List.of("0000", "0000"));
        space.put(6, List.of("0000", "0000"));
        space.put(7, List.of("0000", "0000"));
        return space;
    }

    public char getName() {
        return name;
    }

    public Map<Integer, List<String>> getContent() {
        return content;
    }
}
