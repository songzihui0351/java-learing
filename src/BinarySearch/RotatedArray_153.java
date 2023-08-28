package BinarySearch;

public class RotatedArray_153 {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {5, 6, 7, 0, 1, 2, 3, 4};
        int[] nums3 = {11, 13, 15, 17};
        int[] nums4 = {2, 1};
        int[] nums5 = {1, 2};

        System.out.println(findMin(nums1));
        System.out.println(findMin(nums2));
        System.out.println(findMin(nums3));
        System.out.println(findMin(nums4));
        System.out.println(findMin(nums5));

        System.out.println(findMax(nums1));
        System.out.println(findMax(nums2));
        System.out.println(findMax(nums3));
        System.out.println(findMax(nums4));
        System.out.println(findMax(nums5));
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static int findMax(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}

/*
  根据三种情况来判断mid的比较: 求最小值时需要注意right不要越界

              1.        右       2. 左             3.       中
                    中                     右          左
                左                     中                      右

 */
