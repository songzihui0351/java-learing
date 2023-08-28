package DP.Pack.ZeroOnePack;

/*
    0-1背包问题指的是有n个物品和容量为j的背包, weight数组中记录了n个物品的重量, 位置i的物品重量是weight[i], 
    value数组中记录了n个物品的价值, 位置i的物品价值是vales[i], 每个物品只能放一次到背包中, 问将那些物品装入背包, 使背包的价值最大

    0,1分别表示不选与选两种含义:
        i: 物品数量, v: 物品总价值, w: 物品重量
        不放就和上一次一样, 放就需要i-1件物品放入v-v[i]中再加上放入的这件物品重量之和
        f[i][v] = Max(f[i-1][v], f[i-1][v-v[i]]+w[i])

    二维降一维:
        每次用到的之和上一轮循环的结果有关, 所以只需要保存上一轮的结果即可
        使用逆序是因为需要用的上一轮, 如果正序那么f[i-1][v-v[i]]的值就不是上一轮的, 而是本轮的

    DP问题一定要注意for循环的边界条件!!! i = 1 -> i <= length
 */

public class PartitionSubsetSum_416 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 10, 6};
        System.out.println(canPartition_1(nums)); //一维
        System.out.println(canPartition_2(nums)); //二维
    }

    private static boolean canPartition_2(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = target; j >= 0; j--) {
                if (dp[target]) {
                    return true;
                }
                if (nums[i] <= j) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }

    public static boolean canPartition_1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        int row = nums.length;
        boolean[][] dp = new boolean[row][target + 1];
        //初始化, 定义只有一个元素时的情况
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= target; j++) {
                //不选本次的就相当于和上次的一样, 保证nums[i] > j时答案正确
                dp[i][j] = dp[i - 1][j];

                if (nums[i] <= j) {
                    if (nums[i] == j) {
                        dp[i][j] = true;
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[row - 1][target];
    }
}
