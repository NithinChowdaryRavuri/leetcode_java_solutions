class Solution {
    public class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int rows;
    public int cols;

    public void bfs(char[][] grid, int r, int c) {
        int[] deltaRow = { -1, 0, 1, 0 };
        int[] deltaCol = { 0, 1, 0, -1 };
        Deque<Coordinate> queue = new ArrayDeque<>();
        Set<Coordinate> visited = new HashSet<>();
        Coordinate startNode = new Coordinate(r, c);
        queue.addLast(startNode);
        visited.add(startNode);
        while (queue.size() > 0) {
            Coordinate node = queue.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nR = node.row + deltaRow[i];
                int nC = node.col + deltaCol[i];
                Coordinate newNode = new Coordinate(nR, nC);
                if (nR >= 0 && nR < rows && nC >= 0 && nC < cols && grid[nR][nC] == '1') {
                    if (visited.contains(newNode))
                        continue;
                    visited.add(newNode);
                    queue.addLast(newNode);
                    grid[nR][nC] = '0';
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }
}