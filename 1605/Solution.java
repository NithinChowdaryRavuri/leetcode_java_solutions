class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;

        int[][] result = new int[rows][cols];

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                int value = Math.min(rowSum[row], colSum[col]);
                result[row][col] = value;

                rowSum[row] -= value;
                colSum[col] -= value;
            }
        }

        return result;
    }
}