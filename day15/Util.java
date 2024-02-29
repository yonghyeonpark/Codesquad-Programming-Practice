import java.util.List;

public class Util {

    public static int getLength(String[][] QR, List<Point> points) {
        return convertBinToDec(getBin(QR, points));
    }

    private static String getBin(String[][] QR, List<Point> points) {
        StringBuilder result = new StringBuilder();
        for (Point point : points) {
            result.append(QR[point.getRow()][point.getColumn()]);
        }
        return result.toString();
    }

    public static String decodingData(String[][] QR, List<Point> points) {
        int code = convertBinToDec(getBin(QR, points));
        return convertCodeToCharacter(code);
    }

    private static int convertBinToDec(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private static String convertCodeToCharacter(int code) {
        for (Code codeEnum : Code.values()) {
            if (codeEnum.getCode() == code) {
                return codeEnum.getCharacter();
            }
        }
        return "";
    }

    public static String decodingError(String[][] QR, List<Point> points) {
        return convertBinToHex(getBin(QR, points));
    }

    private static String convertBinToHex(String binary) {
        return Integer.toHexString(convertBinToDec(binary)).toUpperCase();
    }
}
