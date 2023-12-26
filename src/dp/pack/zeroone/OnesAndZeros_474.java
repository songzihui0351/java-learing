package dp.pack.zeroone;

/*
    初始化时根据题意来判断, 不一定要初始化
    一维法时注意逆序边界, 不是零!
 */

public class OnesAndZeros_474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm_1(strs, m, n));
        System.out.println(findMaxForm_2(strs, m, n));
    }

    private static int findMaxForm_2(String[] strs, int m, int n) {
        int length = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] nums = countNum(str);
            int zeros, ones;
            zeros = nums[0];
            ones = nums[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static int findMaxForm_1(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] nums = countNum(strs[i - 1]);
            int zeros, ones;
            zeros = nums[0];
            ones = nums[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    private static int[] countNum(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }
}
