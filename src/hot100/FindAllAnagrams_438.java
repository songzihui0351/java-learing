package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams_438 {
    public static void main(String[] args) {
        FindAllAnagrams_438 solution = new FindAllAnagrams_438();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return new ArrayList<>();
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pLength; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (Arrays.equals(pCount, sCount)) {
            list.add(0);
        }
        for (int i = 0; i < sLength - pLength; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLength) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
