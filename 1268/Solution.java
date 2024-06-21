import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();

        int l = 0, r = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != searchWord.charAt(i))) {
                l++;
            }
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != searchWord.charAt(i))) {
                r--;
            }
            List<String> current = new ArrayList<>();

            for (int j = l; j <= Math.min(r, l + 2); j++) {
                current.add(products[j]);
            }

            result.add(current);
        }
        return result;
    }
}