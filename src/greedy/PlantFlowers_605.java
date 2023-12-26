package greedy;

/*
    判断边界条件时可以使用三元表达式来简化代码
 */
public class PlantFlowers_605 {
    public static void main(String[] args) {
        int[] flowered = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowered, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; n > 0 && i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }
}
