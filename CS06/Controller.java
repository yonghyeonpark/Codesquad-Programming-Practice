import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {

    private final InputView inputView;
    private final Game game;

    public Controller(InputView inputView, Game game) {
        this.inputView = inputView;
        this.game = game;
    }

    public void run() {
        List<String> inputs = inputView.readThrowing();

        // 입력에 대한 예외 체크
        if (!isValidInputs(inputs)) {
            System.out.println("[\"ERROR\"]");
            return;
        }

        // 플레이어 리스트 초기화
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            players.add(new Player(inputs.get(i)));
        }

        // 출력 포맷 설정
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            game.move(player, stringsToInt(player.getInput()));

            List<String> location = player.getLocation();
            sb.append("\"")
                    .append(player.getScore())
                    .append(", ");

            if (player.getInput().length() != stringsToInt(player.getInput()).size()) {
                sb.append("ERR");
            } else {
                if (location.get(0).equals("Z") && location.get(1).equals("W") && location.get(2).equals("0")) {
                    sb.append("Z");
                } else {
                    sb.append(location.get(0))
                            .append(location.get(1))
                            .append(location.get(2));
                }
            }
            sb.append("\", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println(sb);
    }

    private boolean isValidInputs(List<String> inputs) {
        Set<Integer> sizeCheck = new HashSet<>();
        for (String input : inputs) {
            sizeCheck.add(input.length());
        }
        return sizeCheck.size() == 1 && inputs.size() >= 2;
    }

    private List<Integer> stringsToInt(String input) {
        List<Integer> throwing = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'D') {
                throwing.add(1);
            }
            if (c == 'K') {
                throwing.add(2);
            }
            if (c == 'G') {
                throwing.add(3);
            }
            if (c == 'U') {
                throwing.add(4);
            }
            if (c == 'M') {
                throwing.add(5);
            }
        }
        return throwing;
    }
}
