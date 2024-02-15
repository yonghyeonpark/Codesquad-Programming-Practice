import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SqlProcessor {

    private static final String COMMAND_REGEX = "(?i)\\b(CREATE|INSERT|DELETE)\\b";
    private static final String CREATE_TABLE_REGEX = "(?i)CREATE\\s+TABLE\\s+(\\w+)\\s+\\((.+)\\)";
    private static final String INSERT_DATA_REGEX = "(?i)INSERT\\s+INTO\\s+(\\w+)\\s+\\((.+)\\)\\s+VALUES\\s+\\((.+)\\)";
    private static final String DELETE_DATA_REGEX = "(?i)DELETE\\s+FROM\\s+(\\w+)\\s+WHERE\\s+(\\w+)\\s+=\\s+(.+)";
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 컬럼의 타입은 숫자(Numeric), 문자열(String)만 지원합니다.";

    private final Database database;
    private final FileManager fileManager;

    public SqlProcessor(Database database, FileManager fileManager) {
        this.database = database;
        this.fileManager = fileManager;
    }

    public void process(String sql) {
        Matcher matcher = Pattern.compile(COMMAND_REGEX).matcher(sql);

        if (matcher.find()) {
            if (matcher.group().equalsIgnoreCase("CREATE")) {
                System.out.println(">");
                processCreateTable(sql);
            }
            if (matcher.group().equalsIgnoreCase("INSERT")) {
                System.out.println(">");
                processInsertData(sql);
                System.out.println();
            }
            if (matcher.group().equalsIgnoreCase("DELETE")) {
                System.out.println(">");
                processDeleteData(sql);
                System.out.println();
            }
        }
    }

    private void processCreateTable(String sql) {
        Matcher matcher = Pattern.compile(CREATE_TABLE_REGEX).matcher(sql);

        List<String> columns = new ArrayList<>();
        if (matcher.find()) {
            String tableName = matcher.group(1);
            String[] columnsNameAndType = matcher.group(2).split(",\\s+");

            for (String column : columnsNameAndType) {
                String columnName = column.split("\\s+")[0];
                String columnType = column.split("\\s+")[1];
                validateColumnType(columnType);
                columns.add(columnName);
            }
            database.addTable(new Table(tableName, columns));
            fileManager.createFile(tableName, columns);
            return;
        }
        // sql 형식이 올바르지 않을 때
    }

    private void validateColumnType(String columnType) {
        if (!columnType.equals("Numeric") && !columnType.equals("String")) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private void processInsertData(String sql) {
        Matcher matcher = Pattern.compile(INSERT_DATA_REGEX).matcher(sql);
        if (matcher.find()) {
            String tableName = matcher.group(1);
            String[] columns = matcher.group(2).split(",\\s+");
            String[] row = matcher.group(3).split(",\\s+");
            Table findTable = database.findTable(tableName);

            // 문자열과 정수 구분
            List<Object> dataTem = new ArrayList<>();
            for (String element : row) {
                if (element.contains("\"")) {
                    dataTem.add(element.substring(1, element.length() - 1));
                    continue;
                }
                dataTem.add(Integer.parseInt(element));
            }
            findTable.insertData(Arrays.stream(columns).collect(Collectors.toList()), dataTem);
            fileManager.addData(tableName, dataTem);
            return;
        }
        // sql 형식이 올바르지 않을 때
    }

    private void processDeleteData(String sql) {
        Matcher matcher = Pattern.compile(DELETE_DATA_REGEX).matcher(sql);

        if (matcher.find()) {
            String tableName = matcher.group(1);
            String columnName = matcher.group(2);
            String value = matcher.group(3);

            List<List<Object>> deletedRows = new ArrayList<>();
            Table findTable = database.findTable(tableName);
            if (value.contains("\"")) {
                deletedRows = findTable.deleteData(columnName, value.substring(1, value.length() - 1));
            }
            if (!value.contains("\"")) {
                deletedRows = findTable.deleteData(columnName, Integer.parseInt(value));
            }
            for (List<Object> row : deletedRows) {
                fileManager.deleteData(tableName, row);
            }
            return;
        }
        // sql 형식이 올바르지 않을 때
    }

    public void deleteFiles() {
        List<Table> tables = database.getTables();
        for (Table table : tables) {
            fileManager.deleteFile(table.getName());
        }
    }
}
