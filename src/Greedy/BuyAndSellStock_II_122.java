package Greedy;

public class BuyAndSellStock_II_122 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {
                profit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return profit;
    }
}
