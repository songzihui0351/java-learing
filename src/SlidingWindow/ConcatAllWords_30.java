package SlidingWindow;

import java.util.*;


public class ConcatAllWords_30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int length = wordLen * words.length;
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            Integer count = wordMap.getOrDefault(word, 0) + 1;
            wordMap.put(word, count);
        }
        HashMap<String, Integer> validation = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - length; i++) {
            String pattern = s.substring(i, i + length);
            for (int j = 0; j < pattern.length(); j += wordLen) {
                String word = pattern.substring(j, j + wordLen);
                if (wordMap.containsKey(word)) {
                    Integer count = validation.getOrDefault(word, 0) + 1;
                    validation.put(word, count);
                }
            }
            boolean flag = true;
            for (String word : words) {
                if (!validation.getOrDefault(word, 0).equals(wordMap.get(word))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
            validation.clear();
        }

        return res;
    }
}
