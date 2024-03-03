import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Convert {

    private final ConvertFactory factory;
    private List<Point> currentState;
    private String sunOrMoon;
    private String hangulSeconds;

    public Convert(ConvertFactory factory) {
        this.factory = factory;
        this.currentState = new ArrayList<>();
    }

    /**
     * 1. 오전, 오후 판단
     * 2. Hours 조합
     * 3. 해, 달 판단 🌞 🌛
     * 4. Minutes 조합
     * 5. seconds 한글로 변환
     */
    public void convert(LocalTime currentTime) {
        init();
        int hours = currentTime.getHour();
        int minutes = currentTime.getMinute();
        int seconds = currentTime.getSecond();

        setMorningOrAfternoon(currentTime); //1.
        setHours(hours); //2.
        setSunOrMoon(hours); //3.
        setMinutes(minutes); //4.
        setSeconds(seconds); //5.
    }

    private void init() {
        currentState = new ArrayList<>();
    }

    private void setMorningOrAfternoon(LocalTime currentTime) {
        LocalTime noon = LocalTime.NOON;
        if (currentTime.isBefore(noon)) {
            // 오전
            currentState.addAll(factory.getAmOrPm().get("오전"));
        }
        if (currentTime.isAfter(noon) || currentTime.equals(noon)) {
            // 오후
            currentState.addAll(factory.getAmOrPm().get("오후"));
        }
    }

    private void setHours(int hours) {
        if (hours > 12) {
            currentState.addAll(factory.getHours().get(hours - 12));
        }
        if (hours <= 12) {
            currentState.addAll(factory.getHours().get(hours));
        }
        currentState.add(new Point(4, 2));
    }

    private void setSunOrMoon(int hours) {
        if (hours >= 7 && hours < 19) {
            // 해
            sunOrMoon = "\uD83C\uDF1E";
        }
        if (hours >= 19 || hours < 7) {
            // 달
            sunOrMoon = "\uD83C\uDF1B";
        }
    }

    private void setMinutes(int minutes) {
        int minutesFirst = minutes / 10;
        int minutesLast = minutes % 10;
        if (minutesFirst == 0 && minutesLast == 0) {
            return;
        }
        Optional.ofNullable(factory.getMinutesFirst().get(minutesFirst))
                .ifPresent(currentState::addAll);
        Optional.ofNullable(factory.getMinutesLast().get(minutesLast))
                .ifPresent(currentState::addAll);
        currentState.add(new Point(8, 2));
    }

    private void setSeconds(int seconds) {
        int secondsFirst = seconds / 10;
        int secondsLast = seconds % 10;
        if (secondsFirst == 0 && secondsLast == 0) {
            hangulSeconds = "영초";
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(factory.getSecondsFirst().get(secondsFirst))
                .append(factory.getSecondsLast().get(secondsLast))
                .append("초");
        hangulSeconds = sb.toString();
    }

    public List<Point> getCurrentState() {
        return currentState;
    }

    public String getSunOrMoon() {
        return sunOrMoon;
    }

    public String getHangulSeconds() {
        return hangulSeconds;
    }
}
