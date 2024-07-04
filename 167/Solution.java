class Solution {
    private int binarySearch(int[] numbers, int target) {
        int l = 0, r = numbers.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (numbers[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (l == numbers.length)
            return l - 1;
        return l;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            int value = target - numbers[i];
            int rightIndex = binarySearch(numbers, value);
            if (numbers[rightIndex] == value) {
                res[0] = i + 1;
                res[1] = rightIndex + 1;
                if (res[1] == res[0]) {
                    res[1] += 1;
                }
                return res;
            }
        }
        return null;
    }
}