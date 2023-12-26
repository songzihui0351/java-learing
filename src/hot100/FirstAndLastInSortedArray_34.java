package hot100;

import java.util.Arrays;

public class FirstAndLastInSortedArray_34 {
    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {1};
        int target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = length;
        int first, last;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        first = left < length && nums[left] == target ? left : -1;
        left = 0;
        right = length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        last = left > 0 && nums[left - 1] == target ? left - 1 : -1;

        return new int[]{first, last};
    }
}
