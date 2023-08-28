package DP.SubSequence;

/*
    DP: 一个dp数组不够可以使用多个;
        up: 当前元素比上一个大时的dp数组
        down: 当前元素比上一个小时的dp数组

    Greedy: 两个变量已经记录的总数
        up: 上一个上升时的总数
        down: 上一下下降时的总数
 */
public class WiggleSubSequence_376 {
    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(dp(nums));
        System.out.println(greedy(nums));
    }

    private static int greedy(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums [i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up  +1;
            }
        }
        return Math.max(up, down);
    }

    public static int dp(int[] nums) {
        int length = nums.length;
        int[] up = new int[length];
        int[] down = new int[length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[length - 1], down[length - 1]);
    }
}
