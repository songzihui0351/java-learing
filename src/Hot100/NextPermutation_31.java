package Hot100;

import java.util.Arrays;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int firstMin = 0, firstIndex = -1, secondMin = Integer.MAX_VALUE, secondIndex = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstMin = nums[i];
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = firstIndex + 1; i < length; i++) {
            if (nums[i] > firstMin && secondMin > nums[i]) {
                secondMin = nums[i];
                secondIndex = i;
            }
        }
        nums[firstIndex] = secondMin;
        nums[secondIndex] = firstMin;
        Arrays.sort(nums, firstIndex + 1, length);
    }
}
