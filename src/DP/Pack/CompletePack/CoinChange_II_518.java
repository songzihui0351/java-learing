package DP.Pack.CompletePack;

/*
    完全背包问题: 每件物品可以使用多次
        和01背包类似, 二维是减去k个物品, 一维是正序
 */

public class CoinChange_II_518 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
