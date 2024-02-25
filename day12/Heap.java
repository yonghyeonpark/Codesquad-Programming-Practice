import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Heap {

    private static final int BASE_ADDRESS = 0x0000;

    private final Map<String, Integer> types;
    private final List<Data> data;
    private boolean[] isFull;

    public Heap() {
        this.types = new HashMap<>();
        this.data = new ArrayList<>();
    }

    public int init(int heapSize) {
        isFull = new boolean[heapSize / 8];
        return BASE_ADDRESS;
    }

    public void setSize(String type, int length) {
        validateLength(length);
        validateTypeDuplicate(type);
        this.types.put(type, length);
    }

    private void validateLength(int length) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (length != Math.pow(2, i)) {
                count++;
            }
        }
        if (count == 6) {
            throw new IllegalArgumentException("[ERROR] 길이는 2^0~5만 가능합니다.");
        }
    }

    private void validateTypeDuplicate(String type) {
        if (this.types.containsKey(type)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 타입입니다.");
        }
    }

    public int malloc(String type, int count) {
        validateTypeName(type);
        int length = this.types.get(type);
        if (length < 8) {
            length = 8;
        }
        int size = length * count;
        validateAllocateSize(size);

        Data data = new Data(type, size);
        int tem = size / 8;
        for (int i = 0; i < tem; i++) {
            for (int j = 0; j < isFull.length; j++) {
                if (!isFull[j]) {
                    data.addIndex(j);
                    isFull[j] = true;
                    break;
                }
            }
        }
        this.data.add(data);
        return data.getRelativeAddress();
    }

    private void validateTypeName(String type) {
        if (!this.types.containsKey(type)) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 타입입니다.");
        }
    }

    private void validateAllocateSize(int size) {
        if (size > isFull.length * 8) {
            throw new IllegalArgumentException("[ERROR] 힙 메모리 크기를 초과했습니다.");
        }
    }

    public void free(int pointer) {
        List<Data> tem = new ArrayList<>();
        for (Data data : data) {
            if (data.getRelativeAddress() == pointer) {
                for (int index : data.getIndexes()) {
                    isFull[index] = false;
                }
                tem.add(data);
            }
        }
        data.removeAll(tem);
    }

    // 힙 영역 전체크기, 사용중인 용량, 남은 용량을 순서대로 배열로 리턴
    public int[] usage() {
        int usingCapacity = 0;
        int remainedCapacity = 0;

        for (boolean isEmpty : isFull) {
            if (isEmpty) {
                usingCapacity++;
                continue;
            }
            remainedCapacity++;
        }
        return new int[]{isFull.length * 8, usingCapacity * 8, remainedCapacity * 8};
    }

    // 사용중인 데이터 출력
    // 타입, 크기 정보, 포인터 주소값 (절대 + 상대)
    public String[] heapDump() {
        String[] usingStatus = new String[data.size()];

        for (int i = 0; i < data.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("(")
                    .append(data.get(i).toString())
                    .append(", ")
                    .append(Integer.toHexString(BASE_ADDRESS + data.get(i).getRelativeAddress()))
                    .append(")");
            usingStatus[i] = sb.toString();
        }
        return usingStatus;
    }
}
