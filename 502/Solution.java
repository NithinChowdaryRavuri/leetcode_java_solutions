import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length, maxCapital = 0;

        for (int c : capital) {
            maxCapital = Math.max(maxCapital, c);
        }
        if (maxCapital <= w) {
            PriorityQueue<Integer> profitHeap = new PriorityQueue<>();

            for (int profit : profits) {
                profitHeap.add(profit);
            }

            while (profitHeap.size() > k) {
                profitHeap.poll();
            }

            for (int h : profitHeap) {
                w += h;
            }
            return w;
        }

        for (int i = 0; i < Math.min(k, n); i++) {
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (w >= capital[j] && (index == -1 || profits[index] < profits[j])) {
                    index = j;
                }
            }
            if (index == -1)
                break;

            w += profits[index];

            capital[index] = Integer.MAX_VALUE;
        }
        return w;
    }
}