import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int gap = position[position.length - 1] - position[0];
        int res = 1;
        int l = 1, r = gap / (m - 1);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (feasible(mid, position, m)) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    boolean feasible(int mid, int[] arr, int m) {
        int start = 1;
        int last = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - last >= mid) {
                start++;
                last = arr[i];
            }
            if (start >= m) {
                return true;
            }
        }
        return false;
    }
}