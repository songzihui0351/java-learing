package DoublePointers;

import java.util.Arrays;

/*
    非递减数组两数之和
 */

public class TwoSumII_167 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{++left, ++right};
            }
        }
        return new int[]{-1, -1};
    }
}

/*
    1.打印数组不可以直接打印, 这样的结果会是数组的首地址, 需要遍历或者调用 java.util.Arrays.toString()方法打印
    2.新建数组的三种方式:
          ① int[] array1 = {1,2,3}; 声明, 分配空间并赋值
          ② int[] array2; array2 = new int[]{1,2,3}; 先声明, 然后分配空间和赋值
          ③ int[] array3; array3 = new int[3]; 先声明, 然后分配空间没有赋值(初始值)
    3.静态方法只能调用静态方法
    4.声明多变量并赋值: int a = 0, b = 1; 不可以一个等号赋值多个变量, 多个变量分别赋值并用逗号分开
 */
