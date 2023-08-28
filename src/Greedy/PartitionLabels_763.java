package Greedy;

import java.util.*;

/*
    Java:
        1.字符串的处理可以通过新建int[26], 然后通过 string.charAt(i) - 'a' 来赋值
        2.char的本质是Unicode两位无符号整数, 所以可以进行加减乘除
 */

public class PartitionLabels_763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
        System.out.println(partitionLabelsNoSort(s));
    }

    private static ArrayList<Integer> partitionLabelsNoSort(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> array = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, last[s.charAt(i) - 'a']);
            if (i == right) {
                array.add(right - left + 1);
                left = right + 1;
            }
        }
        return array;
    }

    public static List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.get(key) == null) {
                map.put(key, new int[]{i, i});
            } else {
                map.get(key)[1] = i;
            }
        }

        int[][] array = map.values().toArray(new int[0][]);
        Arrays.sort(array, (Comparator.comparingInt(o -> o[0])));

        ArrayList<Integer> res = new ArrayList<>();
        int pre = -1, upper = array[0][1];
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] > upper) {
                res.add(upper - pre);
                pre = upper;
            }
            upper = Math.max(upper, array[i][1]);
        }
        res.add(upper - pre);

        return res;
    }
}
