package SlidingWindow;

import java.util.HashMap;

/*
    滑动窗口: 注意左边界是取最大值!
 */

public class LongestSubstrWithoutRepeat_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                start = Math.max(start, map.get(key) + 1);
            }
            map.put(key, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
