import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDifficulty = 0;
        for (int diff : difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }

        int[] bestProfit = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            bestProfit[difficulty[i]] = Math.max(bestProfit[difficulty[i]], profit[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < bestProfit.length; i++) {
            if (bestProfit[i] > maxProfit) {
                maxProfit = bestProfit[i];
            }
            bestProfit[i] = maxProfit;
        }

        int result = 0;
        for (int w : worker) {
            if (w > maxDifficulty) {
                result += bestProfit[maxDifficulty];
            } else {
                result += bestProfit[w];
            }
        }
        return result;
    }

    public int binarySearch(Integer[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l == arr.length) {
            return l - 1;
        }
        if (arr[l] == target) {
            return l;
        }
        return l - 1;
    }

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = difficulty.length;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(difficulty[i])) {
                map.put(difficulty[i], Math.max(map.get(difficulty[i]), profit[i]));
            } else {
                map.put(difficulty[i], profit[i]);
            }
        }

        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(keys);

        for (int i = 1; i < keys.length; i++) {
            if (map.get(keys[i]) < map.get(keys[i - 1])) {
                map.put(keys[i], map.get(keys[i - 1]));
            }
        }

        int res = 0;

        for (int person : worker) {
            int val = binarySearch(keys, person);
            if (val != -1) {
                res += map.get(keys[val]);
            }
        }

        return res;
    }
}