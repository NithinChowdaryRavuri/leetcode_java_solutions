import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;

        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                ++i;
                ++j;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                ++i;
            }
        }

        int[] solution = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            solution[k] = result.get(k);
        }

        return solution;
    }
}