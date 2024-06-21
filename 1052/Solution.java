class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int total = 0, totalGrumpy = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                totalGrumpy += customers[i];
            }
            total += customers[i];
        }

        int maxGrumpy = 0, tempGrumpy = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                tempGrumpy += customers[i];
            }
            if (i >= minutes) {
                if (grumpy[i - minutes] == 1) {
                    tempGrumpy -= customers[i - minutes];
                }
            }

            maxGrumpy = Math.max(maxGrumpy, tempGrumpy);
        }

        return total - totalGrumpy + maxGrumpy;
    }
}