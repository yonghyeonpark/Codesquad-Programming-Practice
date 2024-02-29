public class QrCode {

    private final String[][] qrCode;
    private boolean isValidate;

    public QrCode(String input) {
        String[][] qrcode = setUp(input);
        validate(qrcode);
        if (isValidate) {
            this.qrCode = qrcode;
        } else {
            this.qrCode = new String[0][0];
        }
    }

    private String[][] setUp(String input) {
        String[] split = input.substring(1, input.length() - 1).split(",\\s*");
        validateLength(split);

        String[][] qrCode = new String[21][21];
        for (int i = 0; i < split.length; i++) {
            String row = split[i].substring(1, split[i].length() - 1);
            for (int j = 0; j < row.length(); j++) {
                qrCode[i][j] = String.valueOf(row.charAt(j));
            }
        }
        return qrCode;
    }

    private void validate(String[][] qrCode) {
        if (isCorrectStartArea(qrCode) && isCorrectEndArea(qrCode)) {
            isValidate = true;
        }
    }

    private boolean isCorrectStartArea(String[][] qrCode) {
        return qrCode[20][20].equals("1") && qrCode[20][19].equals("1") && qrCode[19][20].equals("0") && qrCode[19][19].equals("0");
    }

    private boolean isCorrectEndArea(String[][] qrCode) {
        return qrCode[19][10].equals("0") && qrCode[19][9].equals("1") && qrCode[20][10].equals("1") && qrCode[20][9].equals("0");
    }

    private void validateLength(String[] split) {
        if (split.length != 21) {
            throw new IllegalArgumentException("[ERROR] QR 코드의 세로 길이는 21입니다. ");
        }
        for (String row : split) {
            if (row.length() != 23) {
                throw new IllegalArgumentException("[ERROR] QR 코드의 가로 길이는 21입니다.");
            }
        }
    }

    public String[][] getQrCode() {
        return qrCode;
    }
}
