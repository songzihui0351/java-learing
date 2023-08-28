package DP.IntegerBreak;

/*
    分割整数一般规律: 双层for循环, 寻找当期值和dp[x]的规律

    本题类似于2048小游戏, 不断的增加1, 直到有4个1合成一个4...
 */
public class PerfectSquares_279 {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int curr = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                curr = Math.min(curr, dp[i - j * j]);
            }
            dp[i] = curr + 1;
        }

        return dp[n];
    }
}
