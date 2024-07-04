import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] curr = word.toCharArray();
            Arrays.sort(curr);

            String sortedStr = String.valueOf(curr);

            map.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(sortedStr);
        }

        return new ArrayList<>(map.values());
    }
}