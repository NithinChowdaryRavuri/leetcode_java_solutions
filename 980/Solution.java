class Solution {
    private int rowCount;
    private int columnCount;
    private int emptyCellCount;
    private int[][] grid;
    private boolean[][] visited;

    public int uniquePathsIII(int[][] grid) {
        rowCount = grid.length;
        columnCount = grid[0].length;
        this.grid = grid;

        int startX = 0, startY = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] == 0) {
                    emptyCellCount++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        visited = new boolean[rowCount][columnCount];
        visited[startX][startY] = true;

        return dfs(startX, startY, 0);
    }

    private int dfs(int x, int y, int visitedCellCount) {
        if (grid[x][y] == 2) {
            return visitedCellCount == emptyCellCount + 1 ? 1 : 0;
        }

        int pathCount = 0;
        int[] directions = { -1, 0, 1, 0, -1 };

        for (int d = 0; d < 4; d++) {
            int nextX = x + directions[d];
            int nextY = y + directions[d + 1];

            if (nextX >= 0 && nextX < rowCount && nextY >= 0 && nextY < columnCount && !visited[nextX][nextY]
                    && grid[nextX][nextY] != -1) {
                visited[nextX][nextY] = true;

                pathCount += dfs(nextX, nextY, visitedCellCount + 1);

                visited[nextX][nextY] = false;
            }
        }

        return pathCount;
    }
}