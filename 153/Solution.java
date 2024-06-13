class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length, last = nums.length - 1;
        if (nums[l] < nums[r - 1]) {
            return nums[l];
        }
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] <= nums[last]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}