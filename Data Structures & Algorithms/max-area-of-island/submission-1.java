class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int curLen = dfs(grid, i, j);
                    maxLength = Math.max(maxLength, curLen);
                }
            }
        }

        return maxLength;
    }

    public int dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (Math.min(r, c) < 0 || r == rows || c == columns || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int count = 1;
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r, c - 1);

        return count;
    }
}
