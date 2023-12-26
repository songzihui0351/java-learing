package greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
    贪心: 先计算最多能组成的不重叠区间个数, 然后用区间总个数减去不重叠区间的个数
    等同于9101中的最少发电站问题, 都是按照最小的右边界来找
 */

public class NoneOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99},
                {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int lower = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lower) {
                continue;
            }
            lower = intervals[i][1];
            count++;
        }

        return intervals.length - count;
    }
}
