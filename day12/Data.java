import java.util.ArrayList;
import java.util.List;

public class Data {

    private final String type;
    private final int size;
    private final List<Integer> indexes;

    public Data(String type, int size) {
        this.type = type;
        this.size = size;
        indexes = new ArrayList<>();
    }

    public void addIndex(int index) {
        indexes.add(index);
    }

    public int getRelativeAddress() {
        return indexes.getFirst() * 8;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type)
                .append(", ")
                .append(size);
        return sb.toString();
    }
}
