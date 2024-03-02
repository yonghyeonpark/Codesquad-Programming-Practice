import java.util.HashMap;
import java.util.Map;

public class DateFactory {

    private final Map<Integer, Integer> earthDate;
    private final Map<Integer, Integer> marsDate;

    public DateFactory() {
        this.earthDate = new HashMap<>();
        this.marsDate = new HashMap<>();
        setUpEarthDate();
        setUpMarsDate();
    }

    private void setUpEarthDate() {
        earthDate.put(1, 31);
        earthDate.put(2, 28);
        earthDate.put(3, 31);
        earthDate.put(4, 30);
        earthDate.put(5, 31);
        earthDate.put(6, 30);
        earthDate.put(7, 31);
        earthDate.put(8, 31);
        earthDate.put(9, 30);
        earthDate.put(10, 31);
        earthDate.put(11, 30);
        earthDate.put(12, 31);
    }

    private void setUpMarsDate() {
        marsDate.put(1, 28);
        marsDate.put(2, 28);
        marsDate.put(3, 28);
        marsDate.put(4, 28);
        marsDate.put(5, 28);
        marsDate.put(6, 27);
        marsDate.put(7, 28);
        marsDate.put(8, 28);
        marsDate.put(9, 28);
        marsDate.put(10, 28);
        marsDate.put(11, 28);
        marsDate.put(12, 27);
        marsDate.put(13, 28);
        marsDate.put(14, 28);
        marsDate.put(15, 28);
        marsDate.put(16, 28);
        marsDate.put(17, 28);
        marsDate.put(18, 27);
        marsDate.put(19, 28);
        marsDate.put(20, 28);
        marsDate.put(21, 28);
        marsDate.put(22, 28);
        marsDate.put(23, 28);
        marsDate.put(24, 27);
    }

    public int getNumberOfEarthDays(int month) {
        return earthDate.get(month);
    }

    public int getNumberOfMarsDays(int month) {
        return marsDate.get(month);
    }
}
