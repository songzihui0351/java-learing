package DP.Pack.CompletePack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break; //有一个就够
                }
            }
        }
        return dp[length];
    }
}
