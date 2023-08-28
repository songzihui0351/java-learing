package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
    判断ab和ba的大小, 注意string转int的越界问题!
*/
public class LargestNumber_179 {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array, (a, b) -> {
            long i = Long.parseLong("" + a + b);
            long j = Long.parseLong("" + b + a);
            return (int) (j - i);
        });

        StringBuilder res = new StringBuilder();
        for (Integer i : array) {
            res.append(i);
        }

        return array[0] == 0 ? "0" : res.toString();
    }
}
