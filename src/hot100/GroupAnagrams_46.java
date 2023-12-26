package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_46 {
    public static void main(String[] args) {
//        String[] strs = {""};
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String word = Arrays.toString(charArray);
            ArrayList<String> list = map.getOrDefault(word, new ArrayList<>());
            list.add(str);
            map.put(word, list);
        }

        return new ArrayList<>(map.values());
    }

}
