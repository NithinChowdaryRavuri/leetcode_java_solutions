class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int result = 0, temp = 0;
        for (int val : nums) {
            temp += val & 1;
            if (temp - k >= 0) {
                result += count[temp - k];
            }
            count[temp]++;
        }
        return result;
    }
}