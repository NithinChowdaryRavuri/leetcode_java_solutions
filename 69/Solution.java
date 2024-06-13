class Solution {
    public int mySqrt(int n) {
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) / 2;
            if ((long) m * m < (long) n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l * l == n) {
            return l;
        }
        return l - 1;
    }
}