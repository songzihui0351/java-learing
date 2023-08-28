package DoublePointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    出现过的最长的字串
 */

public class LongestWord_524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        ArrayList<String> dictionary = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        System.out.println(findLongestWord(s, dictionary));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i++) == word.charAt(j)) {
                    j++;
                }
            }
            if (j == word.length()) {
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)){
                    res = word;
                }
            }
        }
        return res;
    }
}

/*
    1.String已经实现了Comparable接口的compareTo方法
    2.Comparable是在创建类时就需要实现的接口, 实现以后这个类就可以直接进行排序
      Comparator是为一个没有实现Comparable接口的类提供一个排序策略, 多用于Collections.sort(), Arrays.sort()方法或者TreeSet等排序类
    3.Arrays.sort()为数组排序; Collections.sort()为集合排序, 底层其实就是调用了Arrays.sort()
 */
