package greedy;

public class NonDecreasingArray_665 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 1, 8};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1 && count <= 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int pre = i == 0 ? nums[i + 1] : nums[i - 1];
                if (count == 0) {
                    if (pre <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                    count++;
                } else {
                    return false;
                }
            }
        }
        return count <= 1;
    }
}
