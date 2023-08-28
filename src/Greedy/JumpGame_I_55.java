package Greedy;

/*
    Greedy: 遍历数组一次, 更新每个i所能到达的最远距离, 判断是否到达终点
 */
public class JumpGame_I_55 {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
