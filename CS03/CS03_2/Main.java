import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int size = s.length();
            char[] answer = new char[size];
            for (int j = 0; j < size; j++) {
                answer[j] = s.charAt(j);
            }
            int score = 0;
            int count = 0;
            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == 'O') {
                    count++;
                    score += count;
                }
                if (answer[j] == 'X') {
                    count = 0;
                }
            }
            System.out.println(score);
        }
    }
}
