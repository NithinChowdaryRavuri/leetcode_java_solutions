import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longStreak = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;

                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longStreak = Math.max(currentStreak, longStreak);
            }
        }

        return longStreak;
    }
}