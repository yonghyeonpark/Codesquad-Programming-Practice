import java.util.List;

public class Controller {

    private final InputView inputView;
    private Game game;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        while (true) {
            try {
                int playerCount = inputView.readPlayerCount();
                CardDeck cardDeck = new CardDeck();
                cardDeck.generate(playerCount);
                game = new Game(cardDeck);
                List<Player> players = game.getPlayers();

                // 카드 덱, 플레이어 객체 생성 및 카드 분배
                game.start(playerCount);

                System.out.print("[안내] 게임의 참가자는 ( ");
                for (Player player : players) {
                    System.out.print(player.getName() + " ");
                }
                System.out.println(") " + playerCount + "명 입니다.");
                System.out.println("[안내] 가장 작은 수의 카드 뭉치를 선택하는 명령어는 'min', 가장 큰 수의 카드 뭉치를 나타내는 명령어는 'max'입니다. ");
                game.print();
                // 게임 진행
                play(players);
                System.out.println("[안내] 게임이 종료되었습니다.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void play(List<Player> players) {
        while (true) {
            for (Player player : players) {
                if (player.getCards().isEmpty()) {
                    continue;
                }
                // 턴마다 예외 처리
                while (true) {
                    try {
                        System.out.println(player.getName() + "의 턴입니다.");
                        String choiceOfPlayer = inputView.readChoiceOfPlayer();
                        game.turn(player, choiceOfPlayer);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                // 매 턴마다 종료 조건 확인
                if (game.isGameOver()) {
                    return;
                }
            }
        }
    }
}
