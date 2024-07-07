class Solution {
    int rows;
    int cols;

    class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int bfs(int[][] grid, int r, int c) {
        int[] deltaRow = { -1, 0, 1, 0 };
        int[] deltaCol = { 0, 1, 0, -1 };
        int result = 0;
        grid[r][c] = 2;
        Deque<Coordinate> queue = new ArrayDeque<>();
        Coordinate startNode = new Coordinate(r, c);
        queue.addLast(startNode);
        while (queue.size() > 0) {
            Coordinate node = queue.removeFirst();
            result++;
            for (int k = 0; k < 4; k++) {
                int nR = node.row + deltaRow[k];
                int nC = node.col + deltaCol[k];
                if (nR >= 0 && nR < rows && nC >= 0 && nC < cols && grid[nR][nC] == 1) {
                    grid[nR][nC] = 2;
                    Coordinate neighbor = new Coordinate(nR, nC);
                    queue.addLast(neighbor);
                }
            }
        }
        return result;
    }

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, bfs(grid, i, j));
                }
            }
        }
        return result;
    }
}