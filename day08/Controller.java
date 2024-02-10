public class Controller {

    private static final String DRV = "    [DRV]";
    private static final String DISPLAY = "+-------+\n|       |\n|DISPLAY|\n|       |\n+-------+";
    private static final String COMPUTE = "+-------+\n|COMPUTE|\n+-------+";
    private static final String DESK_1_NAME = "1========";
    private static final String DESK_2_NAME = "2========";
    private static final String DESK_3_NAME = "3========";

    private Process process;
    private int inputStep;

    public void run() {
        InputView inputView = new InputView();
        inputStep = inputView.readStep();

        Desk desk1 = new Desk(DESK_1_NAME);
        desk1.put(COMPUTE);
        desk1.put(DISPLAY);
        desk1.put(DRV);
        Desk desk2 = new Desk(DESK_2_NAME);
        Desk desk3 = new Desk(DESK_3_NAME);

        process = new Process();
        process.addDesk(desk1);
        process.addDesk(desk2);
        process.addDesk(desk3);

        if (inputStep == 1) {
            process.print();
            return;
        }
        computerTop(3, 1, 2, 3);
    }

    /**
     * N : 부품의 개수
     * start : 시작점
     * mid : 중간지점
     * to : 도착점
     **/
    private void computerTop(int N, int start, int mid, int to) {
        if (N == 0) {
            return;
        }
        computerTop(N - 1, start, to, mid);
        process.move(start, to);
        if (process.getStep() == inputStep) {
            process.print();
        }
        computerTop(N - 1, mid, start, to);
    }
}
