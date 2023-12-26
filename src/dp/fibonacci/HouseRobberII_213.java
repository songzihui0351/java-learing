package dp.fibonacci;

/*
    Fib相关的题目都不需要存储所有的中间值, 只记录需要的前两个就行
 */
public class HouseRobberII_213 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rangeRob(nums, 0, nums.length - 1), rangeRob(nums, 1, nums.length));
    }

    private static int rangeRob(int[] nums, int start, int end) {
        int pre1 = 0, pre2 = 0, curr = 0;
        for (int i = start; i < end; i++) {
            curr = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = curr;
        }
        return curr;
    }
}
