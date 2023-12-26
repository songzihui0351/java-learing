package dp.subsequence;

import java.util.Arrays;
import java.util.Comparator;

/*
    Greedy: 遇到pair的时候可以考虑贪心, 本题使用a[1]来排序是为了让更多的pair算进来
 */

public class MaxLengthPairChain_646 {
    public static void main(String[] args) {
        int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        System.out.println(dp(pairs));
        System.out.println(greedy(pairs));
    }

    private static int greedy(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int count = 0, pivot = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > pivot) {
                count++;
                pivot = pair[1];
            }
        }

        return count;
    }

    public static int dp(int[][] pairs) {
        int length = pairs.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int maxVal = 1;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}
