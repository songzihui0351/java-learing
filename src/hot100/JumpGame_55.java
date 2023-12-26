package hot100;

public class JumpGame_55 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (distance < i) {
                return false;
            }
            distance = Math.max(distance, i + nums[i]);
        }
        return true;
    }
}
