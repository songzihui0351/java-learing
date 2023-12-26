package dp.stock;

public class StockBestTime_III_123 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit2(int[] prices) {
        int buy1 = prices[0], buy2 = prices[0];
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            buy2 = Math.min(buy2, price - sell1);
            sell2 = Math.max(sell2, price - buy2);
        }
        return sell2;
    }

    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length][2][3]; //i,j,k: 第几天, 是否持股, 一共进行过几次交易
        int minVal = Integer.MIN_VALUE / 2;
        dp[0][1][0] = -prices[0];
        dp[0][0][1] = minVal;
        dp[0][0][2] = minVal;
        dp[0][1][1] = minVal;
        dp[0][1][2] = minVal;
        for (int i = 1; i < length; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            dp[i][1][2] = minVal;
        }

        return Math.max(0, Math.max(dp[length - 1][0][1], dp[length - 1][0][2]));
    }
}
