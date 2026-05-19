class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new int[grid.length][grid[0].length]);
    }

    public int dfs(int[][] grid, int r, int c, int[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (r >= rows || r < 0 || 
                c >= columns || c < 0 || 
                visited[r][c] == 1 || grid[r][c] == 1) {
            return 0;
        }

        if (r == rows - 1 && c == columns - 1) {
            return 1;
        }
        visited[r][c] = 1;
        int count = 0;
        count += dfs(grid, r, c + 1, visited);
        count += dfs(grid, r, c - 1, visited);
        count += dfs(grid, r - 1, c, visited);
        count += dfs(grid, r + 1, c, visited);
        visited[r][c] = 0;
        return count;
    }
}
