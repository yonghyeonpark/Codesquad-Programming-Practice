public class Card {

    private final CardType type;
    private final int num;

    public Card(CardType type, int num) {
        this.type = type;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    // ex) (DOG)5
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("(")
                .append(type)
                .append(")")
                .append(num)
                .toString();
    }
}
