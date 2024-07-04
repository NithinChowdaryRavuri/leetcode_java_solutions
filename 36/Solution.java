class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] subgrids = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];

                if (currentChar == '.')
                    continue;

                int number = currentChar - '0' - 1;
                int subgridIndex = (i / 3) * 3 + j / 3;

                if (rows[i][number] || cols[j][number] || subgrids[subgridIndex][number])
                    return false;

                rows[i][number] = true;
                cols[j][number] = true;
                subgrids[subgridIndex][number] = true;
            }
        }

        return true;
    }
}