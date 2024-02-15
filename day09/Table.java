import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {

    private static final String COLUMN_COUNT_RANGE_ERROR_MESSAGE = "[ERROR] 컬럼 개수는 1~9까지 입니다.";
    private static final String COLUMN_AND_DATA_NON_MATCHING_ERROR_MESSAGE = "[ERROR] 컬럼과 데이터가 정확히 매치되지 않습니다.";
    private static final String COLUMN_COUNT_ERROR_MESSAGE = "[ERROR] 테이블의 컬럼 개수와 일치하지 않습니다.";
    private static final String COLUMN_NAME_ERROR_MESSAGE = "[ERROR] 테이블의 컬럼명과 일치하지 않습니다.";
    private static final String NO_DATA_FOR_CONDITION_ERROR_MESSAGE = "[ERROR] 조건에 맞는 데이터가 존재하지 않습니다.";

    private final String name;
    private final List<String> columns;
    private final List<List<Object>> data;
    private int id;

    public Table(String name, List<String> columns) {
        validateColumnCountRange(columns);
        this.name = name;
        this.columns = new ArrayList<>();
        this.data = new ArrayList<>();
        id = 1;
        setUp(columns);
    }

    // 컬럼 개수 범위 체크
    private void validateColumnCountRange(List<String> columns) {
        if (columns.isEmpty() || columns.size() > 9) {
            throw new IllegalArgumentException(COLUMN_COUNT_RANGE_ERROR_MESSAGE);
        }
    }

    // 컬럼 리스트에 "id"를 추가
    private void setUp(List<String> columns) {
        columns.addFirst("id");
        this.columns.addAll(columns);
    }

    public void insertData(List<String> columns, List<Object> row) {
        validateColumnsAndRowMatching(columns, row);
        columns.addFirst("id");
        validateColumnCount(columns);
        validateColumnName(columns);

        row.addFirst(id);
        this.data.add(row);
        printInsertResult(row);
        id++;
    }

    private void validateColumnsAndRowMatching(List<String> columns, List<Object> row) {
        if (columns.size() != row.size()) {
            throw new IllegalArgumentException(COLUMN_AND_DATA_NON_MATCHING_ERROR_MESSAGE);
        }
    }

    private void validateColumnCount(List<String> columns) {
        if (this.columns.size() != columns.size()) {
            throw new IllegalArgumentException(COLUMN_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateColumnName(List<String> columns) {
        if (!this.columns.equals(columns)) {
            throw new IllegalArgumentException(COLUMN_NAME_ERROR_MESSAGE);
        }
    }

    private void printInsertResult(List<Object> row) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERTED ")
                .append("(")
                .append(resultToString(row));
        sb.delete(sb.length() - 2, sb.length());
        sb.append(")");
        System.out.print(sb);
    }

    private String resultToString(List<Object> row) {
        StringBuilder sb = new StringBuilder();
        for (Object value : row) {
            if (value instanceof String) {
                sb.append("\"")
                        .append(value)
                        .append("\"")
                        .append(", ");
            }
            if (value instanceof Integer) {
                sb.append(value)
                        .append(", ");
            }
        }
        return sb.toString();
    }

    public List<List<Object>> deleteData(String columnName, Object value) {
        List<List<Object>> deletedData = getRowsThatMeet(columnName, value);
        if (data.removeAll(deletedData)) {
            printDeleteResult(deletedData);
            return deletedData;
        }
        throw new IllegalArgumentException(NO_DATA_FOR_CONDITION_ERROR_MESSAGE);
    }

    private List<List<Object>> getRowsThatMeet(String columnName, Object value) {
        int columnIndex = columns.indexOf(columnName);

        List<List<Object>> rows = new ArrayList<>();
        Iterator<List<Object>> iterator = data.iterator();
        while (iterator.hasNext()) {
            List<Object> row = iterator.next();
            if (row.get(columnIndex).equals(value)) {
                rows.add(row);
            }
        }
        return rows;
    }

    private void printDeleteResult(List<List<Object>> data) {
        StringBuilder sb = new StringBuilder();
        for (List<Object> row : data) {
            sb.append("DELETED ")
                    .append("(")
                    .append(resultToString(row));
            sb.delete(sb.length() - 2, sb.length());
            sb.append(")")
                    .append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public String getName() {
        return name;
    }
}
