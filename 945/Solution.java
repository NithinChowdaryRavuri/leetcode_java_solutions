class Solution {
    // Below code uses sorting and greedy
    /*
     * public int minIncrementForUnique(int[] nums) {
     * Arrays.sort(nums);
     * int val = nums[0], res = 0;
     * for (int i = 1; i < nums.length; i++) {
     * while (nums[i] == val) {
     * res += 1;
     * nums[i] += 1;
     * }
     * val = nums[i];
     * }
     * return res;
     * }
     */

    // Below code uses counting sort
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] frequency = new int[n + max];

        for (int num : nums) {
            frequency[num] += 1;
        }
        int res = 0;
        for (int i = 0; i < n + max; i++) {
            if (frequency[i] <= 1)
                continue;
            int duplicates = frequency[i] - 1;
            frequency[i + 1] += duplicates;
            res += duplicates;
        }
        return res;
    }
}