class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l == nums.length) {
            return -1;
        }
        if (nums[l] == target) {
            return l;
        }
        return -1;
    }
}