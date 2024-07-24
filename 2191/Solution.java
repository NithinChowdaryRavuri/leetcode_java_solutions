class Solution {
    class Entry {
        int num;
        int mappedNum;
        int index;

        public Entry(int num, int mappedNum, int index) {
            this.num = num;
            this.mappedNum = mappedNum;
            this.index = index;
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Entry> values = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0, value = 0;
            if (num == 0)
                value = mapping[0];
            while (num > 0) {
                int lastDigit = num % 10;
                value += mapping[lastDigit] * Math.pow(10, count);
                ++count;
                num = (int) num / 10;
            }
            values.add(new Entry(nums[i], value, i));
        }

        values.sort((a, b) -> a.mappedNum == b.mappedNum ? a.index - b.index : a.mappedNum - b.mappedNum);

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = values.get(i).num;
        }

        return result;
    }
}