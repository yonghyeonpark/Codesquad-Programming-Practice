public class Log {

    private final String logLevel;
    private final String recordTime;
    private final String process;
    private final String record;

    public Log(String logLevel, String recordTime, String process, String record) {
        this.logLevel = logLevel;
        this.recordTime = recordTime;
        this.process = process;
        this.record = record;
    }

    public boolean isMatchLogLevel(String logLevel) {
        return this.logLevel.equals(logLevel);
    }

    public boolean isMatchProcess(String process) {
        return this.process.equals(process);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(logLevel)
                .append("\t")
                .append(recordTime)
                .append("\t")
                .append(process)
                .append("\t")
                .append(record);
        return sb.toString();
    }

    public String getLogLevel() {
        return logLevel;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public String getProcess() {
        return process;
    }
}
