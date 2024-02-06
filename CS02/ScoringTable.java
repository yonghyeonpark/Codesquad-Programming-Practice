import java.util.StringTokenizer;

public class ScoringTable {

    private final int size;
    private final int[] score;

    public ScoringTable(int size, String inputScore) {
        this.size = size;
        this.score = generateScoringTable(size, inputScore);
    }

    private int[] generateScoringTable(int size, String score) {
        int[] tem = new int[size + 2];

        StringTokenizer st = Util.splitString(score);

        for (int i = 0; i < size; i++) {
            tem[i] = Integer.parseInt(st.nextToken());
        }
        tem[size] = tem[0];
        tem[size + 1] = tem[1];
        return tem;
    }

    public int[] getScore() {
        return score;
    }
}
