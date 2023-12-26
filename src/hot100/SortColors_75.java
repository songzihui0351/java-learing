package hot100;

import java.util.Arrays;

public class SortColors_75 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int length = nums.length;
        int first = 0, last = length - 1, i = 0;
        while (i <= last) {
            if (nums[i] == 0) {
                swap(nums, i++, first++);
            } else if (nums[i] == 2) {
                swap(nums, i, last--);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
