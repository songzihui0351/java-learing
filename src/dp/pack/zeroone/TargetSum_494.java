package dp.pack.zeroone;

/*
    思路一: 正常0-1背包
        dp[i][j + sum] = dp[i - 1][j + sum - nums[i]] + dp[i - 1][j + sum + nums[i]]

    思路二: 转化为Subset Sum问题, 所有取正号或者是负号的元素和等于target, 然后用0-1背包求解
                          sum(P) - sum(N) = target
            sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       sum(P) = (target + sum(nums)) / 2

 */

public class TargetSum_494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays_1(nums, target));
        System.out.println(findTargetSumWays_2(nums, target));
    }

    private static int findTargetSumWays_2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int range = (sum + target) / 2;
        int[] dp = new int[range + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = range; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[range];
    }

    public static int findTargetSumWays_1(int[] nums, int target) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int range = 2 * sum + 1;
        int[][] dp = new int[length][range];
        //init
        dp[0][sum - nums[0]] += 1;
        dp[0][sum + nums[0]] += 1;

        for (int i = 1; i < length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (j + nums[i] > sum) {
                    dp[i][j + sum] = dp[i - 1][j + sum - nums[i]];
                } else if (j - nums[i] < -sum) {
                    dp[i][j + sum] = dp[i - 1][j + sum + nums[i]];
                } else {
                    dp[i][j + sum] = dp[i - 1][j + sum - nums[i]] + dp[i - 1][j + sum + nums[i]];
                }
            }
        }

        return dp[length - 1][sum + target];
    }
}
