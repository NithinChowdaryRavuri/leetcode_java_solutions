import java.util.Arrays;

class Solution {
    public boolean feasible(int[] piles, int h, int m) {
        int res = 0;
        for (int pile : piles) {
            res += (pile + m - 1) / m;
        }
        return res > h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        if (h == n) {
            return piles[n - 1];
        }
        int l = 1, r = piles[n - 1];
        while (l < r) {
            int m = (l + r) / 2;
            if (feasible(piles, h, m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}