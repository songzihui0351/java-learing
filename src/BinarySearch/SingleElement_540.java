package BinarySearch;

public class SingleElement_540 {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 3, 3, 4, 8, 8};
        int[] array2 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] array3 = {1, 1, 2};
        System.out.println(singleNonDuplicate(array1));
        System.out.println(singleNonDuplicate(array2));
        System.out.println(singleNonDuplicate(array3));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

/*
    Java异或运算符: ^
    异或规则: 0^0=1, 0^x=x, x^x=0, 奇数 ^ 1 = 奇数 - 1, 偶数 ^ 1 = 偶数 + 1

    right初始取值/while中<=和<, 都需要防止数组越界
 */
