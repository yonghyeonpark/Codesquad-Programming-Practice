import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Convertor {

    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
    
        printBinResult(dec2bin(inputDec()));
        printDecResult(bin2dec(inputBin()));
    }

    private static int inputDec() throws IOException {
        System.out.print("10진수 입력 = ");
        return Integer.parseInt(br.readLine());
    }

    private static boolean[] inputBin() throws IOException {
        System.out.print("2진수 입력 = ");
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
        int count = st.countTokens();
        boolean[] input2 = new boolean[count];
        for (int i = 0; i < count; i++) {
            input2[i] = Boolean.valueOf(st.nextToken());
        }
        return input2;
    }

    private static boolean[] dec2bin(int dec) {
        List<Boolean> list = new ArrayList<>();
        while (dec != 0) {
            if (dec % 2 == 1) {
                list.add(true);
            }
            if (dec % 2 == 0) {
                list.add(false);
            }
            dec /= 2;
        }

        boolean[] bin = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bin[i] = list.get(i);
        }
        return bin;
    }

    private static int bin2dec(boolean[] bin) {
        int dec = 0;
        for (int i = 0; i < bin.length; i++) {
            if (bin[i]) {
                dec += Math.pow(2, i);
            }
        }
        return dec;
    }

    private static void printBinResult(boolean[] bin) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < bin.length; i++) {
            sb.append(bin[i] + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println("결과 = " + sb);
    }

    private static void printDecResult(int dec) {
        System.out.println("결과 = " + dec);
    }
}
