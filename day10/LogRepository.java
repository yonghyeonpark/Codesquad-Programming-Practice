import java.util.*;

public class LogRepository {

    private final List<Log> logs;
    private Set<String> logLevels;
    private Set<String> processes;

    public LogRepository() {
        this.logs = new ArrayList<>();
        this.logLevels = new HashSet<>();
        this.processes = new HashSet<>();
    }

    public void addLog(Log log) {
        logs.add(log);
        logLevels.add(log.getLogLevel());
        processes.add(log.getProcess());
    }

    public List<Log> getLogs() {
        return logs;
    }

    public Set<String> getLogLevels() {
        return logLevels;
    }

    public Set<String> getProcesses() {
        return processes;
    }
}
