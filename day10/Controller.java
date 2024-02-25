public class Controller {

    private final FileReader fileReader;
    private final LogManager logManager;
    private final InputView inputView;

    public Controller(FileReader fileReader, LogManager logManager, InputView inputView) {
        this.fileReader = fileReader;
        this.logManager = logManager;
        this.inputView = inputView;
    }

    public void run() {
        fileReader.readFile(logManager);

        while (true) {
            System.out.println("[안내 메시지] sort, search, count, exit(종료) 중 원하시는 명령어를 선택하세요.");
            String command1 = inputView.readCommand();
            System.out.println();

            processSort(command1);
            processSearch(command1);
            processCount(command1);
            if (isTerminate(command1)) {
                break;
            }
        }
        System.out.println("프로그램이 종료됩니다.");
    }

    private void processSort(String command1) {
        if (command1.equals("sort")) {
            System.out.println("[안내 메시지] recordtime, process 중 원하시는 정렬 기준을 선택하세요.");
            String command2 = inputView.readCommand();
            if (isRecordTime(command2)) {
                logManager.sortByRecordTime();
            }
            if (isProcess(command2)) {
                logManager.sortByProcess();
            }
        }
    }

    private void processSearch(String command1) {
        if (command1.equals("search")) {
            System.out.println("[안내 메시지] loglevel, process 중 원하시는 검색 요소를 선택하세요.");
            String command2 = inputView.readCommand();
            System.out.println();
            if (isLogLevel(command2)) {
                logManager.printLogLevels();
                String command3 = inputView.readCommand();
                System.out.println();
                logManager.filterLogLevel(command3);
            }
            if (isProcess(command2)) {
                logManager.printProcesses();
                String command3 = inputView.readCommand();
                System.out.println();
                logManager.filterProcess(command3);
            }
        }
    }

    private void processCount(String command1) {
        if (command1.equals("count")) {
            System.out.println("[안내 메시지] loglevel, process 중 원하시는 카운트 요소를 선택하세요.");
            String command2 = inputView.readCommand();
            System.out.println();
            if (isLogLevel(command2)) {
                logManager.countPerLogLevel();
            }
            if (isProcess(command2)) {
                logManager.countPerProcess();
            }
        }
    }

    private boolean isRecordTime(String command2) {
        return command2.equals("recordtime");
    }

    private boolean isLogLevel(String command2) {
        return command2.equals("loglevel");
    }

    private boolean isProcess(String command2) {
        return command2.equals("process");
    }

    private boolean isTerminate(String command1) {
        return command1.equals("exit");
    }
}
