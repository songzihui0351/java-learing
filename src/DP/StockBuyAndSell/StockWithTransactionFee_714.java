package DP.StockBuyAndSell;

/*
    股票买卖问题由二维转换为一维:
        只有买入和卖出两个状态, 不需要按照天数来新建dp数组
        返回值一定是最后一天不持股票, 否则一定会亏买入最后一只股票的价格
 */

public class StockWithTransactionFee_714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit1(prices, fee));
        System.out.println(maxProfit2(prices, fee)); //空间优化
    }

    public static int maxProfit2(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] - fee + prices[i]);
            dp[1] = Math.max(temp - prices[i], dp[1]);
        }

        return dp[0]; //最后一天持股一定会亏买入最后一只股票的价格
    }

    public static int maxProfit1(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - fee + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[length - 1][0];
    }
}
