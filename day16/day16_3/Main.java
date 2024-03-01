public class Main {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int minLength = getMinLength(strs);
        return findCommonPrefix(strs, minLength);
    }

    private static int getMinLength(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < min) {
                min = str.length();
            }
        }
        return min;
    }

    private static String findCommonPrefix(String[] strs, int minLength) {
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            boolean isMatching = true;
            for (String str : strs) {
                if (currentChar != str.charAt(i)) {
                    isMatching =false;
                    break;
                }
            }
            if (!isMatching) {
                break;
            }
            commonPrefix.append(currentChar);
        }
        return commonPrefix.toString();
    }
}
