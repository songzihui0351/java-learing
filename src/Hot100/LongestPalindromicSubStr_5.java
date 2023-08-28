package Hot100;

/*
    最长回文子串: dp[l][r], 遍历时先固定右边界!!!
 */

public class LongestPalindromicSubStr_5 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int max = 0, start = 0, end = 0;
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                dp[l][r] = (r - l <= 2 || dp[l + 1][r - 1]) && s.charAt(l) == s.charAt(r);
                if (dp[l][r] && (r - l + 1) > max) {
                    max = r - l + 1;
                    start = l;
                    end = r;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
