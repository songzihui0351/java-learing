package dp.stock;

import java.util.Arrays;

/*
    股票买卖问题:
        二维dp数组, 第二维度存股票的状态, 买入, 持股, 卖出等
        初始化时需要初始化负数的第一只股票买入价格
 */

public class StockWithCoolDown_309 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][4];
        dp[0][0] = 0; //原来不持有股票, 也没卖出去, 现在不持有股票
        dp[0][1] = 0; //原来持有股票, 卖出去了, 现在不持有股票
        dp[0][2] = -prices[0]; //原来不持有股票, 今天买入, 现在持有股票
        dp[0][3] = -prices[0]; //原来持有股票, 今天不买入, 现在持有股票
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3]) + prices[i];
            dp[i][2] = dp[i - 1][0] - prices[i]; //冷冻期
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
