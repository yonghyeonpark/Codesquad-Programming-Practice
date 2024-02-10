import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private final List<Card> deck;

    public CardDeck() {
        this.deck = new ArrayList<>();
    }

    public void generate(int playerCount) {
        deck.clear();
        if (playerCount == 3) {
            for (CardType cardType : CardType.values()) {
                for (int i = 1; i <= 11; i++) {
                    addCards(new Card(cardType, i));
                }
            }
        }
        if (playerCount == 4 || playerCount == 5) {
            for (CardType cardType : CardType.values()) {
                for (int i = 1; i <= 12; i++) {
                    addCards(new Card(cardType, i));
                }
            }
        }
        shuffle();
    }

    private void addCards(Card card) {
        deck.add(card);
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    // 덱의 첫 번째 카드를 제거 후 반환
    public Card drawCard() {
        return deck.removeFirst();
    }

    public int checkCountOfCardRemaining() {
        return deck.size();
    }
}
