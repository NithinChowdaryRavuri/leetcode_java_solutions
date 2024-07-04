class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }

        int first = nums[0], last = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            res[i] *= first;
            res[nums.length - 1 - i] *= last;
            first *= nums[i];
            last *= nums[nums.length - 1 - i];
        }

        return res;
    }
}