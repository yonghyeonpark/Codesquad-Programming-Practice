import java.util.List;

public class OutputView {

    public void printProgressBar() {
        double progress = 0;
        try {
            for (int i = 0; i <= 100; i += 10) {
                progress = i / 100.0;

                StringBuilder progressBar = new StringBuilder();
                int completed = (int) (progress * 10);
                int remaining = 10 - completed;

                progressBar.append("\r")
                        .append("⚫".repeat(Math.max(0, completed)))
                        .append("⚪".repeat(Math.max(0, remaining)))
                        .append(" 화성까지 여행 ")
                        .append((int) (progress * 100)).append("%");
                System.out.print(progressBar);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public void printResult(int earthDay, List<Integer> marsDate) {
        int year = marsDate.getFirst();
        int month = marsDate.get(1);
        int day = marsDate.getLast();

        StringBuilder result = new StringBuilder();
        result.append("지구날은 ")
                .append(earthDay)
                .append(" => ")
                .append(year)
                .append(" 화성년 ")
                .append(month)
                .append("월 ")
                .append(day)
                .append("일\n\n")
                .append("     " + year + "년 " + month + "월\n");
        if (month % 6 != 0 || (year % 2 == 0 && month == 24)) {
            result.append(MarsCalendar.TO_28.getCalendar());
            System.out.println(result);
            return;
        }
        result.append(MarsCalendar.TO_27.getCalendar());
        System.out.println(result);
    }
}
