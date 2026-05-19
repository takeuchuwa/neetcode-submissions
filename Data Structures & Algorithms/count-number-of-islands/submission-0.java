class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1' && visited[r][c] == 0) {
                    count++;
                    dfs(grid, r, c, visited);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c, int[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (Math.min(r,c) < 0 || r == rows || c == columns || grid[r][c] == '0' || visited[r][c] == 1) {
            return;
        }
        visited[r][c] = 1;
        dfs(grid, r + 1, c, visited);
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c + 1, visited);
        dfs(grid, r, c - 1, visited);
        
    }
}
