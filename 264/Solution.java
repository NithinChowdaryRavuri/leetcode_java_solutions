class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; i++) {
            int next2 = uglyNumbers[index2] * 2;
            int next3 = uglyNumbers[index3] * 3;
            int next5 = uglyNumbers[index5] * 5;

            uglyNumbers[i] = Math.min(next2, Math.min(next3, next5));

            if (uglyNumbers[i] == next2) {
                index2++;
            }
            if (uglyNumbers[i] == next3) {
                index3++;
            }
            if (uglyNumbers[i] == next5) {
                index5++;
            }
        }

        return uglyNumbers[n-1];
    }
}