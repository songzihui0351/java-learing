package greedy;

import java.util.Arrays;

/*
    1.排序
    2.若是胃口大于尺寸，那么寻找下一个尺寸，直到胃口<=尺寸为止
 */

public class AssignCookies_455 {

    public static void main(String[] args) {
        int[] cookies = {1, 2};
        int[] kids = {1, 2, 3};
        System.out.println(findContentChildren(cookies, kids));
    }

    public static int findContentChildren(int[] kids, int[] cookies) {
        Arrays.sort(kids);
        Arrays.sort(cookies);
        int count = 0, i = 0, j = 0;
        while (i < kids.length && j < cookies.length) {
            if (kids[i] <= cookies[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }

        return count;
    }
}
