class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int numPlants = plantTime.length;
        Integer[] indices = new Integer[numPlants];
        for (int i = 0; i < numPlants; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) -> growTime[j] - growTime[i]);

        int maxDays = 0;
        int totalPlantTime = 0;

        for (int i : indices) {
            totalPlantTime += plantTime[i];
            maxDays = Math.max(maxDays, totalPlantTime + growTime[i]);
        }

        return maxDays;
    }
}