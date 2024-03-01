public class Main {

    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(-123));
        System.out.println(solution(120));
        System.out.println(solution(1534236469));
    }

    private static int solution(int x) {
        long reverse = reverse(x, getLength(x));
        if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE - 1) {
            return 0;
        }
        return (int) reverse;
    }

    private static int getLength(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        if (s.startsWith("-")) {
            return length - 1;
        }
        return length;
    }

    private static long reverse(long x, int length) {
        long sum = 0;
        int index = 1;
        while (x != 0) {
            sum += (long) Math.pow(10, length -index) * (x % 10);
            x /= 10;
            index++;
        }
        return sum;
    }
}
