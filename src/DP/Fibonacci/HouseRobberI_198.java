package DP.Fibonacci;

/*
    Fib相关的题目都不需要存储所有的中间值, 只记录需要的前两个就行
 */
public class HouseRobberI_198 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int pre1 = 0, pre2 = 0, curr = 0;
        for (int num : nums) {
            curr = Math.max(pre1 + num, pre2);
            pre1 = pre2;
            pre2 = curr;
        }
        return curr;
    }
}
