package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
    满足所有: 左排序
    最少: 右排序
 */

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= right) {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            } else {
                res.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
