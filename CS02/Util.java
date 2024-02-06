import java.util.StringTokenizer;

public class Util {

    public static StringTokenizer splitString(String score) {
        score = score.substring(1, score.length() - 1);
        return new StringTokenizer(score, ", ");
    }
}
