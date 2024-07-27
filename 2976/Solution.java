import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final int INFINITY = 1 << 29;
        int[][] graph = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(graph[i], INFINITY);
            graph[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int fromIndex = original[i] - 'a';
            int toIndex = changed[i] - 'a';
            int changeCost = cost[i];
            graph[fromIndex][toIndex] = Math.min(graph[fromIndex][toIndex], changeCost);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int sourceIndex = source.charAt(i) - 'a';
            int targetIndex = target.charAt(i) - 'a';
            if (sourceIndex != targetIndex) {
                if (graph[sourceIndex][targetIndex] >= INFINITY) {
                    return -1;
                }
            }
            totalCost += graph[sourceIndex][targetIndex];
        }

        return totalCost;
    }
}