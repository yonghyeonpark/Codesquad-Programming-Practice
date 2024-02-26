import java.util.ArrayList;
import java.util.List;

public class Processor {

    private final List<List<BitMapFont>> numbers;
    private final List<List<String>> lines;
    private final List<List<String>> result;
    private int unit;

    public Processor() {
        this.numbers = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    public void setUp(String word) {
        clear();
        int length = word.length();
        List<BitMapFont> numbersLine = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (BitMapFont font : BitMapFont.values()) {
                if (font.getName() == word.charAt(i)) {
                    numbersLine.add(font);
                }
            }
            if ((i + 1) % 16 == 0 || i == length - 1) {
                numbers.add(numbersLine);
                numbersLine = new ArrayList<>();
            }
        }
        setLines();
    }

    private void clear() {
        numbers.clear();
        lines.clear();
        result.clear();
    }

    // 입력된 word에 대해 1~8의 전체 라인을 각각 저장
    private void setLines() {
        for (List<BitMapFont> numbersLine : numbers) {
            for (int i = 0; i < 8; i++) {
                List<String> line = new ArrayList<>();
                for (int j = 0; j < numbersLine.size(); j++) {
                    line.addAll(numbersLine.get(j).getContent().get(i));
                }
                lines.add(line);
            }
        }
    }

    public void process() {
        for (List<String> line : lines) {
            StringBuilder sb = new StringBuilder();
            line.stream()
                    .map(this::binaryToHex)
                    .toList()
                    .forEach(sb::append);
            // 32 = 8칸(4바이트를 의미) x 4 => 기준이 16바이트
            for (int i = 0; i < 32 - line.size(); i++) {
                sb.append(0);
            }
            result.add(format(sb.toString()));
        }
        printResult();
    }

    private List<String > format(String line) {
        List<String> interimFinding = new ArrayList<>();
        for (int i = 0; i < line.length(); i += 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("\"0x")
                    .append(line.substring(i, Math.min(i + 8, line.length())))
                    .append("\"");
            interimFinding.add(sb.toString());
        }
        return interimFinding;
    }

    // 2진수 => 10진수 => 16진수로 변환
    private String binaryToHex(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.toHexString(decimal).toUpperCase();
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<String> line : result) {
            for (String element : line) {
                sb.append(element)
                        .append(", ");
            }
            sb.append("\n");
        }
        sb.delete(sb.length() - 3, sb.length());
        sb.append("]");
        System.out.println(sb);
    }
}
