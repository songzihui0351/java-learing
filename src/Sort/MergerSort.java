package Sort;

import java.util.Arrays;

public class MergerSort {
    public static void main(String[] args) {
        int[] array = {6, 3, 5, 1, 7, 4, 2};
        int[] res = sort(array);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = (int) Math.floor(array.length >> 1);
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[i + j] = left[i++];
            } else {
                res[i + j] = right[j++];
            }
        }
        if (i == left.length) {
            while (j < right.length) {
                res[i + j] = right[j++];
            }
        } else {
            while (i < left.length) {
                res[i + j] = left[i++];
            }
        }
        return res;
    }
}

/*
    使用递归的思路, 无限细分数组直至每个小数组只有一个元素, 然后开始递归的向上合并这些小数组
 */
