import java.util.List;

public class Clock {

    private String[][] clock;

    public void setClock(Convert convert) {
        init();
        applyTime(convert.getCurrentState());
        applySunOrMoon(convert.getSunOrMoon());
        applyHangulSeconds(convert.getHangulSeconds());
    }

    private void init() {
        clock = new String[][] {
                {"오", "전", "후", "영"},
                {"열", "한", "두", "세"},
                {"네", "다", "여", "섯"},
                {"일", "곱", "여", "덟"},
                {"아", "홉", "시", "--"},
                {"이", "삼", "사", "오"},
                {"십", "일", "이", "삼"},
                {"사", "오", "육", "칠"},
                {"팔", "구", "분", "--"}
        };
    }

    private void applyTime(List<Point> currentState) {
        for (Point point : currentState) {
            clock[point.getRow()][point.getColumn()] += "❗";
        }
    }

    private void applySunOrMoon(String sunOrMoon) {
        clock[4][3] = sunOrMoon;
    }

    private void applyHangulSeconds(String hangulSeconds) {
        clock[8][3] = hangulSeconds;
    }

    public String[][] getClock() {
        return clock;
    }
}
