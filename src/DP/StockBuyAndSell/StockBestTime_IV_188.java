package DP.StockBuyAndSell;

public class StockBestTime_IV_188 {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 7;
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (k >= length / 2) { //普通的股票问题
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][length];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0]; //上一轮完成了0次交易: 买入第一只股票
            for (int j = 1; j < length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]); //卖出或者不卖
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]); //找到买入最少的那天
            }
        }
        return dp[k][length - 1];
    }
}
