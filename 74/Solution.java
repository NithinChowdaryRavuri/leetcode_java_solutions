class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        boolean res = false;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return res;
        }
        int start = 0;
        while (matrix[start][col - 1] < target) {
            start += 1;
        }
        int l = 0, r = col;
        while (l < r) {
            int m = (l + r) / 2;
            if (matrix[start][m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l == col) {
            return res;
        }
        if (matrix[start][l] == target) {
            return true;
        }
        return res;
    }
}