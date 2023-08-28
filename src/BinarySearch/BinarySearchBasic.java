package BinarySearch;

/*
    寻找左右边界: 都是left=mid+1, right=mid, 只是有无等于号
 */
public class BinarySearchBasic {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 4, 4, 5};
        int[] array3 = {10};
        int target = 4;
        System.out.println(search(array1, target));
        System.out.println(findLeftBoundary(array3, target));
        System.out.println(findRightBoundary(array3, target));
    }

    private static int findRightBoundary(int[] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private static int findLeftBoundary(int[] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int search(int [] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}

