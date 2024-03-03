import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertFactory {

    private final Map<String, List<Point>> amOrPm;
    private final Map<Integer, List<Point>> hours;
    private final Map<Integer, List<Point>> minutesFirst;
    private final Map<Integer, List<Point>> minutesLast;
    private final Map<Integer, String> secondsFirst;
    private final Map<Integer, String> secondsLast;

    public ConvertFactory() {
        this.amOrPm = new HashMap<>();
        this.hours = new HashMap<>();
        this.minutesFirst = new HashMap<>();
        this.minutesLast = new HashMap<>();
        this.secondsFirst = new HashMap<>();
        this.secondsLast = new HashMap<>();
        setAmOrPm();
        setHours();
        setMinutesFirst();
        setMinutesLast();
        setSecondsFirst();
        setSecondsLast();
    }

    private void setAmOrPm() {
        amOrPm.put("오전", List.of(new Point(0, 0), new Point(0, 1)));
        amOrPm.put("오후", List.of(new Point(0, 0), new Point(0, 2)));
    }

    private void setHours() {
        hours.put(0, List.of(new Point(0, 3)));
        hours.put(1, List.of(new Point(1, 1)));
        hours.put(2, List.of(new Point(1, 2)));
        hours.put(3, List.of(new Point(1, 3)));
        hours.put(4, List.of(new Point(2, 0)));
        hours.put(5, List.of(new Point(2, 1), new Point(2, 3)));
        hours.put(6, List.of(new Point(2, 2), new Point(2, 3)));
        hours.put(7, List.of(new Point(3, 0), new Point(3, 1)));
        hours.put(8, List.of(new Point(3, 2), new Point(3, 3)));
        hours.put(9, List.of(new Point(4, 0), new Point(4, 1)));
        hours.put(10, List.of(new Point(1, 0)));
        hours.put(11, List.of(new Point(1, 0), new Point(1, 1)));
        hours.put(12, List.of(new Point(1, 0), new Point(1, 2)));
    }

    // 십의 자리 일의 자리 나눠서
    private void setMinutesFirst() {
        minutesFirst.put(1, List.of(new Point(6, 0)));
        minutesFirst.put(2, List.of(new Point(5, 0), new Point(6, 0)));
        minutesFirst.put(3, List.of(new Point(5, 1), new Point(6, 0)));
        minutesFirst.put(4, List.of(new Point(5, 2), new Point(6, 0)));
        minutesFirst.put(5, List.of(new Point(5, 3), new Point(6, 0)));
    }

    private void setMinutesLast() {
        minutesLast.put(1, List.of(new Point(6, 1)));
        minutesLast.put(2, List.of(new Point(6, 2)));
        minutesLast.put(3, List.of(new Point(6, 3)));
        minutesLast.put(4, List.of(new Point(7, 0)));
        minutesLast.put(5, List.of(new Point(7, 1)));
        minutesLast.put(6, List.of(new Point(7, 2)));
        minutesLast.put(7, List.of(new Point(7, 3)));
        minutesLast.put(8, List.of(new Point(8, 0)));
        minutesLast.put(9, List.of(new Point(8, 1)));
    }

    private void setSecondsFirst() {
        secondsFirst.put(0, "");
        secondsFirst.put(1, "십");
        secondsFirst.put(2, "이십");
        secondsFirst.put(3, "삼십");
        secondsFirst.put(4, "사십");
        secondsFirst.put(5, "오십");
    }

    private void setSecondsLast() {
        secondsLast.put(0, "");
        secondsLast.put(1, "일");
        secondsLast.put(2, "이");
        secondsLast.put(3, "삼");
        secondsLast.put(4, "사");
        secondsLast.put(5, "오");
        secondsLast.put(6, "육");
        secondsLast.put(7, "칠");
        secondsLast.put(8, "팔");
        secondsLast.put(9, "구");
    }

    public Map<String, List<Point>> getAmOrPm() {
        return amOrPm;
    }

    public Map<Integer, List<Point>> getHours() {
        return hours;
    }

    public Map<Integer, List<Point>> getMinutesFirst() {
        return minutesFirst;
    }

    public Map<Integer, List<Point>> getMinutesLast() {
        return minutesLast;
    }

    public Map<Integer, String> getSecondsFirst() {
        return secondsFirst;
    }

    public Map<Integer, String> getSecondsLast() {
        return secondsLast;
    }
}
