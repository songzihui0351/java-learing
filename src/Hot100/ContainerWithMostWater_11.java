package Hot100;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int length = height.length - 1;
        int left = 0, right = length, area;
        area = length * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
        }

        return area;
    }
}
