class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int curLen = dfs(grid, visited, i, j);
                    maxLength = Math.max(maxLength, curLen);
                }
            }
        }

        return maxLength;
    }

    public int dfs(int[][] grid, int[][] visited, int r, int c) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (Math.min(r, c) < 0 || r == rows || c == columns || visited[r][c] == 1 || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = 1;
        int count = 1;
        count += dfs(grid, visited, r + 1, c);
        count += dfs(grid, visited, r - 1, c);
        count += dfs(grid, visited, r, c + 1);
        count += dfs(grid, visited, r, c - 1);

        return count;
    }
}
