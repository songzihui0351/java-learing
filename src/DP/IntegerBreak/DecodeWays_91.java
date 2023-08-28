package DP.IntegerBreak;

/*
    和分治类似, dp也是将问题转化为多个小问题, 然后在小问题之间寻找等式
 */
public class DecodeWays_91 {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecoding(s));
        System.out.println(numDecodingFib(s));
    }

    private static int numDecodingFib(String s) {
        int n = s.length();
        int a = 0, b = 1, curr = 0;
        for (int i = 1; i <= n; i++) {
            curr = 0;
            if (s.charAt(i - 1) != '0') {
                curr += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                curr += a;
            }
            a = b;
            b = curr;
        }

        return curr;
    }

    public static int numDecoding(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

}
