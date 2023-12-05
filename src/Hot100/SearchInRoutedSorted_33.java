package Hot100;

public class SearchInRoutedSorted_33 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {6, 7, 0, 1, 2, 3, 4, 5};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
