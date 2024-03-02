import java.util.List;

public class Calculator {

    private final DateFactory dateFactory;

    public Calculator(DateFactory dateFactory) {
        this.dateFactory = dateFactory;
    }

    public int calculateEarthDay(String date) {
        String[] dateElement = date.split("-");
        int year = Integer.parseInt(dateElement[0]);
        int month = Integer.parseInt(dateElement[1]);
        int day = Integer.parseInt(dateElement[2]);
        
        int earthDay = 0;
        earthDay += (year - 1) * 365;
        earthDay += (year - 1) / 4;
        earthDay += day;
        if (month >= 2) {
            for (int i = 1; i < month; i++) {
                earthDay += dateFactory.getNumberOfEarthDays(i);
                if (i == 2 && year % 4 == 0) {
                    earthDay++;
                }
            }
        }
        return earthDay;
    }

    public List<Integer> calculateMarsDate(int earthDay) {
        int year = 0;
        boolean isLeapYear = false;

        // year 계산
        while (true) {
            if (earthDay < 668) {
                isLeapYear = false;
                break;
            }
            earthDay -= 668;
            year++;
            if (earthDay < 669) {
                isLeapYear = true;
                break;
            }
            earthDay -= 669;
            year++;
        }

        // month, day 계산
        int month = 1;
        while (true) {
            int numberOfMarsDays = dateFactory.getNumberOfMarsDays(month);

            // 윤년일 때 1일 추가
            if (month == 24 && isLeapYear) {
                numberOfMarsDays++;
            }
            if (earthDay <= numberOfMarsDays) {
                break;
            }
            earthDay -= numberOfMarsDays;
            month++;
        }
        return List.of(year, month, earthDay);
    }
}