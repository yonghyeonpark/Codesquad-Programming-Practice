import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

// ["111111101000001111111", "100000101000001000001","101110100000001011101","101110100000001011101","101110101000001011101","100000101000001000001","111111101010101111111","000000000000000000000", "111010101000011101011", "110001000000000000101", "010011100000000000100", "000000001000000000001", "001100101000000000001", "000000001000000000100", "111111100000000001100", "100000101000000000010", "101110100000000000110", "101110100000000000100", "101110101000000000100", "100000101100000000000", "111111101010000110011"]
public class Controller {

    private final InputView inputView;
    private final DecodingDataFactory dataFactory;
    private final Moving moving;

    public Controller(InputView inputView, DecodingDataFactory dataFactory, Moving moving) {
        this.inputView = inputView;
        this.dataFactory = dataFactory;
        this.moving = moving;
    }

    public void run() {
        QrCode qrCodeObj = new QrCode(inputView.readQrCode());
        String[][] qrCode = qrCodeObj.getQrCode();
        if (qrCode.length == 0) {
            System.out.println(Arrays.toString(qrCode));
            return;
        }

        DecodingData lengthData = dataFactory.getLengthData().getFirst();
        int length = Util.getLength(qrCode, move(lengthData));
        List<DecodingData> data = dataFactory.getData();
        List<DecodingData> errors = dataFactory.getErrors();

        StringJoiner dataResult = new StringJoiner("", "\"", "\"");
        for (int i = 0; i < length; i++) {
            dataResult.add(Util.decodingData(qrCode, move(data.get(i))));
        }

        StringJoiner errorsResult = new StringJoiner("", "\"", "\"");
        for (DecodingData error : errors) {
            errorsResult.add(Util.decodingError(qrCode, move(error)));
        }

        printResult(dataResult.toString(), errorsResult.toString());
    }

    private List<Point> move(DecodingData decodingData) {
        if (decodingData.getDirection().equals(Direction.UP)) {
            return moving.moveUp(decodingData);
        }
        if (decodingData.getDirection().equals(Direction.DOWN)) {
            return moving.moveDown(decodingData);
        }
        if (decodingData.getDirection().equals(Direction.CLOCKWISE)) {
            return moving.moveClockwise(decodingData);
        }
        return moving.moveCounterclockwise(decodingData);
    }

    // StringJoiner 활용해보기
    private void printResult(String dataResult, String errorsResult) {
        StringBuilder result = new StringBuilder();
        result.append("data = ")
                .append(dataResult)
                .append(", ")
                .append("error = ")
                .append(errorsResult);

        StringJoiner result2 = new StringJoiner(", ", "[", "]");
        result2.add(dataResult)
                .add(errorsResult);

        System.out.println(result);
        System.out.println(result2);
    }
}
