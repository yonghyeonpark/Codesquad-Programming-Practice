import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogManager {

    private static final String REGEX = "([^\t]+)\\t([^\t]+)\\t([^\t]+)\\t(.+)";

    private final LogRepository logRepository;

    public LogManager(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void storeLog(String log) {
        Matcher matcher = Pattern.compile(REGEX).matcher(log);
        if (matcher.find()) {
            String logLevel = matcher.group(1);
            String recordTime = matcher.group(2);
            String process = matcher.group(3);
            String record = matcher.group(4);
            logRepository.addLog(new Log(logLevel, recordTime, process, record));
        }
    }

    public void filterLogLevel(String logLevel) {
        List<Log> logs = logRepository.getLogs();
        for (Log log : logs) {
            if (log.isMatchLogLevel(logLevel)) {
                System.out.println(log);
            }
        }
        System.out.println();
    }

    public void filterProcess(String process) {
        List<Log> logs = logRepository.getLogs();
        for (Log log : logs) {
            if (log.isMatchProcess(process)) {
                System.out.println(log);
            }
        }
        System.out.println();
    }

    public void sortByRecordTime() {
        List<Log> logs = logRepository.getLogs();
        logs.stream()
                .sorted(Comparator.comparing(Log::getRecordTime))
                .toList()
                .forEach(System.out::println);
        System.out.println();
    }

    public void sortByProcess() {
        List<Log> logs = logRepository.getLogs();
        logs.stream()
                .sorted(Comparator.comparing(Log::getProcess)) // 내림차순은 .reversed
                .toList()
                .forEach(System.out::println);
        System.out.println();
    }

    public void countPerLogLevel() {
        Map<String, Integer> totalCount = new HashMap<>();
        Set<String> logLevels = logRepository.getLogLevels();
        List<Log> logs = logRepository.getLogs();

        for (String logLevel : logLevels) {
            int count = 0;
            for (Log log : logs) {
                if (log.getLogLevel().equals(logLevel)) {
                    count++;
                }
            }
            totalCount.put(logLevel, count);
        }

        for (Map.Entry<String, Integer> entry : totalCount.entrySet()) {
            System.out.println(entry.getKey() + "의 개수는 " + entry.getValue() + "입니다.");
        }
        System.out.println();
    }

    public void countPerProcess() {
        Map<String, Integer> totalCount = new HashMap<>();
        Set<String> processes = logRepository.getProcesses();
        List<Log> logs = logRepository.getLogs();

        for (String process : processes) {
            int count = 0;
            for (Log log : logs) {
                if (log.getProcess().equals(process)) {
                    count++;
                }
            }
            totalCount.put(process, count);
        }

        for (Map.Entry<String, Integer> entry : totalCount.entrySet()) {
            System.out.println(entry.getKey() + "의 개수는 " + entry.getValue() + "입니다.");
        }
        System.out.println();
    }

    public void printLogLevels() {
        StringBuilder sb = new StringBuilder();
        sb.append("[안내 메시지] 검색 가능한 로그 레벨은 ")
                .append(String.join(", ", logRepository.getLogLevels()))
                .append(" 입니다.");
        System.out.println(sb);
    }

    public void printProcesses() {
        StringBuilder sb = new StringBuilder();
        sb.append("[안내 메시지] 검색 가능한 프로세스 이름은 ")
                .append(String.join(", ", logRepository.getProcesses()))
                .append(" 입니다.");
        System.out.println(sb);
    }
}
