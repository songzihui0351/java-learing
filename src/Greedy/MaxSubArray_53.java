package Greedy;

public class MaxSubArray_53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum < 0 ? nums[i] : sum + nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
