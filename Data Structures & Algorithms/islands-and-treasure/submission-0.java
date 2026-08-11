class Solution {

    private static int[][] neighbors = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int pathLength = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] neighbor : neighbors) {
                int neighborRow = row + neighbor[0];
                int neighborCol = col + neighbor[1];

                if (neighborRow >= 0 && neighborRow < rows && 
                        neighborCol >= 0 && neighborCol < cols && 
                        grid[neighborRow][neighborCol] == Integer.MAX_VALUE) {
                    grid[neighborRow][neighborCol] = grid[row][col] + 1;
                    queue.offer(new int[]{neighborRow, neighborCol});
                }
            }
        }
    }
}
