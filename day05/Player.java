import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final String name;
    private final List<Card> cards;
    private int score;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
        score = 0;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void sortCards() {
        cards.sort(Comparator.comparing(Card::getNum));
    }

    public void addScore() {
        score += 1;
    }

    // 가장 큰 수를 찾고 해당하는 카드들을 제거 및 반환
    public List<Card> drawMaxCards() {
        int maxValue = cards.stream()
                .max(Comparator.comparing(Card::getNum))
                .map(Card::getNum)
                .orElse(-1);

        List<Card> selectedCards = cards.stream()
                .filter(card -> card.getNum() == maxValue)
                .collect(Collectors.toList());
        cards.removeAll(selectedCards);
        return selectedCards;
    }

    // 가장 작은 수를 찾고 해당하는 카드들을 제거 및 반환
    public List<Card> drawMinCards() {
        int minValue = cards.stream()
                .min(Comparator.comparing(Card::getNum))
                .map(Card::getNum)
                .orElse(-1);

        List<Card> selectedCards = cards.stream()
                .filter(card -> card.getNum() == minValue)
                .collect(Collectors.toList());
        cards.removeAll(selectedCards);
        return selectedCards;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" : ")
                .append(score)
                .append(" ");

        if (cards.isEmpty()) {
            sb.append("[ ]");
            return sb.toString();
        }

        sb.append("[");
        for (Card card : cards) {
            sb.append(card.toString())
                    .append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
