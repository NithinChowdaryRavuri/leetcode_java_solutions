class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: arr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word: arr) {
            if (map.get(word) == 1) {
                k--;
                if (k==0) return word;
            }
        }

        return "";
    }
}