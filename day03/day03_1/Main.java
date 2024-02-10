import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 1. 정순, 역순 리스트를 직접 초기화
     * 2. 입력 받은 값으로 생성한 리스트를 정렬하여 원본과 비교
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> scale = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            scale.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> naturalOrdered = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> reverseOrdered = List.of(8, 7, 6, 5, 4, 3, 2, 1);

        String result;
        if (scale.equals(naturalOrdered)) {
            result = "ascending";
        } else if (scale.equals(reverseOrdered)) {
            result = "descending";
        } else {
            result = "mixed";
        }
        System.out.println(result);
    }
}
