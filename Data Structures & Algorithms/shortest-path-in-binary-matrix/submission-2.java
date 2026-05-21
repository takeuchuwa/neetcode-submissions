class Solution {
    static int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        
        Queue<int[]> queue = new ArrayDeque<>(n);
        queue.add(new int[]{0, 0});

        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coordinates = queue.poll();
                int r = coordinates[0];
                int c = coordinates[1];
                if (r == n - 1 && c == n - 1) {
                    return length;
                }

                
                for (int[] direction: directions) {
                    int newR = r + direction[0];
                    int newC = c + direction[1];
                    if (Math.min(newR, newC) < 0 || newR == n || newC == n || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(new int[]{newR, newC});
                    grid[newR][newC] = 1;
                }
            }
            length++;
        }

        return -1;
    }
}