package dp.interval;

/*
    dp[i] = dp[i-1] + 1
    相当于给前面的每个子数组都加一个dp[i], 而dp[i]又能比dp[i-1]多一个[i-2,i]的子数组
 */
public class ArithmeticSlices_413 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        int[] dp = new int[length];
        int count = 0;
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            count += dp[i];
        }
        return count;
    }
}
