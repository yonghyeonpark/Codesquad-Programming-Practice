import java.util.ArrayList;
import java.util.List;

public class DecodingDataFactory {

    private final List<DecodingData> lengthData;
    private final List<DecodingData> data;
    private final List<DecodingData> errors;

    public DecodingDataFactory() {
        this.lengthData = new ArrayList<>();
        this.data = new ArrayList<>();
        this.errors = new ArrayList<>();
        setUpLengthData();
        setUpData();
        setUpErrors();
    }

    private void setUpLengthData() {
        lengthData.add(new DecodingData(new Point(18, 20), Direction.UP));
    }

    private void setUpData() {
        data.add(new DecodingData(new Point(14, 20), Direction.UP)); //1
        data.add(new DecodingData(new Point(10, 20), Direction.COUNTERCLOCKWISE)); //2
        data.add(new DecodingData(new Point(11, 18), Direction.DOWN)); //3
        data.add(new DecodingData(new Point(15, 18), Direction.DOWN)); //4
        data.add(new DecodingData(new Point(19, 18), Direction.CLOCKWISE)); //5
        data.add(new DecodingData(new Point(18, 16), Direction.UP)); //6
        data.add(new DecodingData(new Point(14, 16), Direction.UP)); //7
        data.add(new DecodingData(new Point(10, 16), Direction.COUNTERCLOCKWISE)); //8
        data.add(new DecodingData(new Point(11, 14), Direction.DOWN)); //9
        data.add(new DecodingData(new Point(15, 14), Direction.CLOCKWISE)); //10
        data.add(new DecodingData(new Point(19, 14), Direction.UP)); //11
        data.add(new DecodingData(new Point(18, 12), Direction.UP)); //12
        data.add(new DecodingData(new Point(14, 12), Direction.UP)); //13
        data.add(new DecodingData(new Point(10, 12), Direction.UP)); //14
        data.add(new DecodingData(new Point(5, 12), Direction.UP)); //15
        data.add(new DecodingData(new Point(1, 12), Direction.COUNTERCLOCKWISE)); //16
        data.add(new DecodingData(new Point(2, 10), Direction.DOWN)); //17
        data.add(new DecodingData(new Point(7, 10), Direction.DOWN)); //18
        data.add(new DecodingData(new Point(11, 10), Direction.DOWN)); //19
        data.add(new DecodingData(new Point(15, 10), Direction.DOWN)); //20
    }

    private void setUpErrors() {
        errors.add(new DecodingData(new Point(12, 8), Direction.UP));
        errors.add(new DecodingData(new Point(9, 5), Direction.DOWN));
        errors.add(new DecodingData(new Point(12, 3), Direction.UP));
        errors.add(new DecodingData(new Point(9, 1), Direction.DOWN));
    }

    public List<DecodingData> getLengthData() {
        return lengthData;
    }

    public List<DecodingData> getData() {
        return data;
    }

    public List<DecodingData> getErrors() {
        return errors;
    }
}
