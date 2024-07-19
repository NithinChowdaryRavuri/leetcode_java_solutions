class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] minInRows = new int[m];
        int[] maxInCols = new int[n];

        Arrays.fill(minInRows, Integer.MAX_VALUE);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                minInRows[i] = Math.min(minInRows[i], matrix[i][j]);
                maxInCols[j] = Math.max(maxInCols[j], matrix[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (minInRows[i] == maxInCols[j]) result.add(minInRows[i]);
            }
        }

        return result;
    }
}