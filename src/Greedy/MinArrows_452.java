package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrows_452 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int arrow = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arrow) {
                continue;
            }
            count++;
            arrow = points[i][1];
        }
        return count;
    }
}
