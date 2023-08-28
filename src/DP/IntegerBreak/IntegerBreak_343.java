package DP.IntegerBreak;

/*
    将n拆成两个整数: i和j, 其中一个还可以继续拆分, 如果继续拆分就用到dp数组存储的值
    将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j*(i-j)
    将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j*dp[i-j]

    注意边界问题: n为整数时, 数组取int[n+1], 循环时i<=n
 */
public class IntegerBreak_343 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
