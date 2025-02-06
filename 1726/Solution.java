class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int product = nums[i] * nums[j];
                count.merge(product, 1, Integer::sum);
            }
        }

        int answer = 0;
        for (int frequency : count.values()) {
            answer += frequency * (frequency - 1);
        }

        return answer << 2;
    }
}