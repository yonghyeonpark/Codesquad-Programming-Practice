import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {

    private static final String TABLE_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 테이블명은 중복될 수 없습니다.";
    private static final String NO_TABLE_ERROR_MESSAGE = "[ERROR] 존재하지 않는 테이블입니다.";
    private static final String TABLE_CREATE_COMPLETE_MESSAGE = " 테이블이 생성되었습니다.";

    private final List<Table> tables;

    public Database() {
        this.tables = new ArrayList<>();
    }

    // 테이블 추가
    public void addTable(Table table) {
        validateTableNameDuplicate(table.getName());
        tables.add(table);
        System.out.println(table.getName() + TABLE_CREATE_COMPLETE_MESSAGE);
    }

    // 테이블명 중복 검사
    private void validateTableNameDuplicate(String tableName) {
        Iterator<Table> iterator = tables.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(tableName)) {
                throw new IllegalArgumentException(TABLE_NAME_DUPLICATE_ERROR_MESSAGE);
            }
        }
    }

    // 테이블 검색
    public Table findTable(String tableName) {
        for (Table table : tables) {
            if (table.getName().equals(tableName)) {
                return table;
            }
        }
        throw new IllegalArgumentException(NO_TABLE_ERROR_MESSAGE);
    }

    public List<Table> getTables() {
        return tables;
    }
}
