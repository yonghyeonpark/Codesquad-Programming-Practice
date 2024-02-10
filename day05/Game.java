import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final List<String> playerNames = List.of("A", "B", "C", "D", "E");
    private static final String PLAYER_COUNT_ERROR_MESSAGE = "[ERROR] 플레이어 숫자는 3부터 5까지만 가능합니다.";

    private final CardDeck cardDeck;
    private final List<Player> players;
    private final List<Card> commonCards;
    private final List<Card> discardedCards;

    public Game(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
        players = new ArrayList<>();
        commonCards = new ArrayList<>();
        discardedCards = new ArrayList<>();
    }

    public void start(int playerCount) {
        validatePlayerCount(playerCount);
        cardDeck.generate(playerCount);
        // 플레이어 객체 생성
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(playerNames.get(i)));
        }

        // 플레이어 수에 따른 카드 분배 분기 설정
        if (playerCount == 3) {
            for (Player player : players) {
                for (int i = 0; i < 8; i++) {
                    player.addCard(cardDeck.drawCard());
                }
                player.sortCards();
            }
        }
        if (playerCount == 4) {
            for (Player player : players) {
                for (int i = 0; i < 7; i++) {
                    player.addCard(cardDeck.drawCard());
                }
                player.sortCards();
            }
        }
        if (playerCount == 5) {
            for (Player player : players) {
                for (int i = 0; i < 6; i++) {
                    player.addCard(cardDeck.drawCard());
                }
                player.sortCards();
            }
        }

        // 남은 카드는 바닥에 추가
        while (cardDeck.checkCountOfCardRemaining() != 0) {
            commonCards.add(cardDeck.drawCard());
        }
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < 3 || playerCount > 5) {
            throw new IllegalArgumentException(PLAYER_COUNT_ERROR_MESSAGE);
        }
    }

    public void turn(Player player, String choiceOfPlayer) {
        // 카드 리스트가 비어있는 플레이어는 패스
        if (player.getCards().isEmpty()) {
            print();
            return;
        }

        List<Card> cardsToDiscard = new ArrayList<>();
        // 선택에 따른 분기
        if (choiceOfPlayer.equals("max")) {
            List<Card> maxCards = player.drawMaxCards();
            List<Card> matchingCards = compareWithCommonCards(maxCards);
            if (!matchingCards.isEmpty()) {
                player.addScore();
            }
            cardsToDiscard.addAll(matchingCards);
            cardsToDiscard.addAll(maxCards);

        }
        if (choiceOfPlayer.equals("min")) {
            List<Card> minCards = player.drawMinCards();
            List<Card> matchingCards = compareWithCommonCards(minCards);
            if (!matchingCards.isEmpty()) {
                player.addScore();
            }
            cardsToDiscard.addAll(matchingCards);
            cardsToDiscard.addAll(minCards);
        }
        discardedCards.addAll(cardsToDiscard);
        print();
    }

    // 바닥 카드와 비교
    private List<Card> compareWithCommonCards(List<Card> cards) {
        int cardValue = cards.getFirst().getNum();
        List<Card> matchingCards = commonCards.stream()
                .filter(card -> card.getNum() == cardValue)
                .collect(Collectors.toList());
        commonCards.removeAll(matchingCards);
        return matchingCards;
    }

    public void print() {
        // 플레이어 정보 출력
        for (Player player : players) {
            System.out.println(player.toString());
        }

        // 바닥 카드와 제거된 카드 출력
        StringBuilder sb = new StringBuilder();
        sb.append("바닥")
                .append(" [");

        // 바닥 카드가 비어있을 때와 그렇지 않을 때의 분기
        if (commonCards.isEmpty()) {
            sb.append("]")
                    .append("\n");
        }
        if (!commonCards.isEmpty()) {
            for (Card commonCard : commonCards) {
                sb.append(commonCard.toString())
                        .append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            sb.append("\n");
        }

        // 버려진 카드 리스트가 비어있지 않을 때만 진행
        if (!discardedCards.isEmpty()) {
            sb.append("제거")
                    .append(" [");
            for (Card discardedCard : discardedCards) {
                sb.append(discardedCard.toString())
                        .append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]")
                    .append("\n");
        }
        System.out.println(sb);
    }

    /**
     * 게임 종료 조건
     * 1. 바닥 카드가 다 떨어졌을 때
     * 2. 플레이어 모두의 카드가 다 떨어졌을 때
     */
    public boolean isGameOver() {
        int gameOverPlayerCount = 0;
        for (Player player : players) {
            if (player.getCards().isEmpty()) {
                gameOverPlayerCount++;
            }
        }
        return commonCards.isEmpty() || gameOverPlayerCount == players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
