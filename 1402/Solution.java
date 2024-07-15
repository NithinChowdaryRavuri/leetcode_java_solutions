class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int totalSatisfaction = 0;
        int cumulativeSatisfaction = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            cumulativeSatisfaction += satisfaction[i];

            if (cumulativeSatisfaction <= 0)
                break;

            totalSatisfaction += cumulativeSatisfaction;
        }

        return totalSatisfaction;
    }
}