package sort;

import java.util.Arrays;

public class QuickSort {

    public static void _quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partitionSort(array, left, right);
            _quickSort(array, left, pivot);
            _quickSort(array, pivot + 1, right);
        }
    }

    private static int partitionSort(int[] array, int left, int right) {
        int pivot = left;
        int index = left;
        for (int i = left + 1; i < right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, pivot);
                pivot = i;
                index++;
            }
        }
        swap(array, pivot, index);
        return index;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void main(String[] args) {
        int[] array = {3, 1, 4, 2, 6, 5};
        _quickSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}

/*
    1.递归里不需要for/while循环, 直接递归调用方法即可
    2.快排逻辑为分治, 找出一个基准值然后不断的swap, 使得基准值为分割位
      需要统计swap的数量, 和最后一次交换的+1位置再swap, 保证基准值的左边都是比自己小的
 */
