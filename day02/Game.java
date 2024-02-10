import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private final InputView inputView;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        int[] scoringTable = getScoringTable();
        List<ArrayList<Integer>> list = inputView.readArray();
        int round = list.size();
        Member A = new Member();
        Member B = new Member();

        for (int i = 0; i < round; i++) {
            ArrayList<Integer> nRound = list.get(i);
            int standard = nRound.get(0);
            List<Integer> standards = new ArrayList<>();

            // 기준 인덱스가 범위를 벗어나 0으로 넘어가는지 체크
            int incr = 0;
            for (int j = 0; j < 3; j++) {
                standards.add(checkIndexRange(standard + incr));
                incr++;
            }

            // 보너스 점수 계산을 위해 단일 결과를 나타내는 리스트 사용
            List<Integer> singleResult = new ArrayList<>();
            for (int a = 1; a < 4; a++) {
                if (standards.contains(nRound.get(a))) {
                    singleResult.add(nRound.get(a));
                }
            }
            A.addResult(singleResult);
            checkIsBonus(singleResult, A);

            singleResult = new ArrayList<>();
            for (int b = 4; b < 7; b++) {
                if (standards.contains(nRound.get(b))) {
                    singleResult.add(nRound.get(b));
                }
            }
            B.addResult(singleResult);
            checkIsBonus(singleResult, B);
        }
        getResult(A.calculateScore(scoringTable), B.calculateScore(scoringTable));
    }

    private int[] getScoringTable() {
        ScoringTable scoringTableC = new ScoringTable(
                20, "[20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5]");
        return scoringTableC.getScore();
    }

    private int checkIndexRange(int index) {
        if (index == 20) {
            return 0;
        }
        if (index == 21) {
            return 1;
        }
        return index;
    }

    private void checkIsBonus(List<Integer> singleResult, Member m) {
        if (singleResult.size() == 3 && new HashSet<>(singleResult).size() == 1) {
            m.addResult(singleResult.get(0));
        }
    }

    private void getResult(int aScore, int bScore) {
        StringBuilder sb = new StringBuilder();
        sb.append(aScore);
        if (aScore > bScore) {
            sb.append(">");
        } else if (aScore == bScore) {
            sb.append("=");
        } else {
            sb.append("<");
        }
        sb.append(bScore);
        System.out.println(sb);
    }
}
