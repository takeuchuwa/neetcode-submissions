class Solution {

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minute = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coordinates = queue.poll();
                int r = coordinates[0];
                int c = coordinates[1];

                for (int[] direction : directions) {
                    int nR = r + direction[0];
                    int nC = c + direction[1];

                    if (Math.min(nR, nC) < 0 || nR == n || nC == m || grid[nR][nC] != 1) {
                        continue;
                    }

                    grid[nR][nC] = 2;
                    freshCount--;
                    queue.add(new int[]{nR, nC});
                }
            }
            minute++;
        }
        
        return freshCount == 0 ? Math.max(0, minute) : -1;
    }
}
