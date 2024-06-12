class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            if (num == 0) {
                zero += 1;
            } else if (num == 1) {
                one += 1;
            } else {
                two += 1;
            }
        }
        int index = 0;
        while (zero > 0) {
            nums[index] = 0;
            zero -= 1;
            index += 1;
        }
        while (one > 0) {
            nums[index] = 1;
            one -= 1;
            index += 1;
        }
        while (two > 0) {
            nums[index] = 2;
            two -= 1;
            index += 1;
        }
    }
}