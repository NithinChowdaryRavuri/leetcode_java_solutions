class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flips = new int[n + 1];
        int totalFlips = 0;
        int flipCount = 0;

        for (int i = 0; i < n; i++) {
            flipCount += flips[i];

            if (nums[i] % 2 == flipCount % 2) {
                if (i + k > n) {
                    return -1;
                }
                flips[i]++;
                flips[i + k]--;
                flipCount++;
                totalFlips++;
            }
        }
        return totalFlips;
    }
}