package doublepointers;

import java.util.Arrays;

/*
    合并有序数组: nums1长度为m+n, nums2长度为n, 最后合并至nums1
 */

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0, n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, tail = m + n - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] < nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }
}

/*
    从小到大排会造成覆盖问题, 可以考虑从大到小来排, 注意边界问题!
 */