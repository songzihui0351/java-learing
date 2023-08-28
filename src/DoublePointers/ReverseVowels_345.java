package DoublePointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
    翻转字符串中的元音
 */
public class ReverseVowels_345 {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] res = new char[s.length()];
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char low = s.charAt(left);
            char high = s.charAt(right);
            if (!vowels.contains(low)) {
                res[left++] = low;
            } else if (!vowels.contains(high)) {
                res[right--] = high;
            } else {
                res[left++] = high;
                res[right--] = low;
            }
        }
        return String.valueOf(res);
    }
}

/*
    1.ArrayList初始化: 调用Arrays.asList(), 或者新建空ArrayList后add一个一个加
    2.String是不可变的, 需要新建一个String来返回
    3.String.valueOf()方法可以将基础数据转为String
    4.Java中交换变量必须使用临时变量来协助, 不可以直接交换
 */
