package Greedy;

/*
    Greedy: 遍历数组一次, 更新每个i所能到达的最远距离, 如果超过边界, 则迈一步, 步长为最远距离, 然后将边界更新为最远距离
 */
public class JumpGame_II_45 {
    public static void main(String[] args) {
        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int boundary = nums[0];
        int max = 0;
        int step = 1;
        for (int i = 0; i < nums.length; i++) {
            if (boundary >= nums.length - 1) {
                return step;
            }
            max = Math.max(max, i + nums[i]);
            if (i == boundary) {
                step++;
                boundary = max;
            }
        }
        return step;
    }
}

