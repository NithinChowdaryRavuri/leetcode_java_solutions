class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int index = 0;
        int res = 0;
        while (miss <= n) {
            if (index < nums.length && nums[index] <= miss) {
                miss += nums[index];
                index++;
            } else {
                miss *= 2;
                res++;
            }
        }
        return res;
    }
}