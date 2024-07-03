import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        int length = nums.length;

        if (length < 5)
            return 0;

        Arrays.sort(nums);
        long res = Long.MAX_VALUE;

        for (int left = 0; left < 4; left++) {
            int right = 3 - left;
            long diff = (long) nums[length - 1 - right] - nums[left];

            res = Math.min(res, diff);
        }

        return (int) res;
    }
}