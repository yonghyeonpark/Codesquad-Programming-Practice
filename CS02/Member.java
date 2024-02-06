import java.util.ArrayList;
import java.util.List;

public class Member {

    private List<Integer> result;
    private int score;

    public Member() {
        this.result = new ArrayList<>();
        this.score = 0;
    }

    public void addResult(List<Integer> nums) {
        result.addAll(nums);
    }

    public void addResult(int num) {
        result.add(num);
    }

    public int calculateScore(int[] scoreTable) {
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) >= 0 && result.get(i) < scoreTable.length) {
                score += scoreTable[result.get(i)];
            }
        }
        return score;
    }
}
