public enum MarsCalendar {

    TO_28("Su Lu Ma Me Jo Ve Sa\n" +
            " 1  2  3  4  5  6  7\n" +
            " 8  9 10 11 12 13 14\n" +
            "15 16 17 18 19 20 21\n" +
            "22 23 24 25 26 27 28"),
    TO_27("Su Lu Ma Me Jo Ve Sa\n" +
            " 1  2  3  4  5  6  7\n" +
            " 8  9 10 11 12 13 14\n" +
            "15 16 17 18 19 20 21\n" +
            "22 23 24 25 26 27");

    private String calendar;

    MarsCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getCalendar() {
        return calendar;
    }
}
