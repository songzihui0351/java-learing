package DoublePointers;

/*
    给定非负整数c, 使得a2 + b2 = c, 求a和b
 */
public class SquareSum_633 {
    public static void main(String[] args) {
        int c = 2147483600;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        long low = 0, upper = (long) Math.sqrt(c);
        while (low <= upper) {
            long powSum = low * low + upper * upper;
            if (powSum < c) {
                low++;
            } else if (powSum > c) {
                upper--;
            } else {
                return true;
            }
        }
        return false;
    }
}

/*
    1.强转: (int) double
    2.注意int的范围是: [-2^31,2^31-1], 如果强转时超出范围则会取最大值, 此时应当使用long或者更高的值
 */
