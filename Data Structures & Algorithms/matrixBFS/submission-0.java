class Solution {
    public int shortestPath(int[][] grid) {
        return dfs(grid);
    }

    public int dfs(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] visited = new int[rows][columns];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coordinates = queue.poll();
                int r = coordinates[0];
                int c = coordinates[1];
                
                if (r == rows - 1 && c == columns - 1) {
                    return length;
                }

                int[][] neighbours = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] direction : neighbours) {
                    int newR = r + direction[0];
                    int newC = c + direction[1];
                    if (Math.min(newR, newC) < 0 ||
                            newR == rows || newC == columns ||
                            visited[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }

                    queue.add(new int[]{newR, newC});
                    visited[newR][newC] = 1;
                }
            }
            length++;
        }

        return -1;
    }
}
