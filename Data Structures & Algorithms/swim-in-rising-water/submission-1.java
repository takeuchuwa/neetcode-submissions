class Solution {
    public int swimInWater(int[][] grid) {
        int[][] neighbours = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int n = grid.length;
        int max = -1;
        min.offer(new int[] {grid[0][0], 0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!min.isEmpty()) {
            int[] edge = min.poll();
            max = Math.max(edge[0], max);
            if (edge[1] == n - 1 && edge[2] == n - 1) {
                return max;
            }
            visited[edge[1]][edge[2]] = true;
            for (int[] neighbour : neighbours) {
                int row = edge[1] + neighbour[0];
                int column = edge[2] + neighbour[1];
                if (row >= 0 && column >= 0 && Math.max(row, column) < n 
                        && !visited[row][column]) {
                    min.offer(new int[] {grid[row][column], row, column});
                }
            }

        }

        return -1;
    }
}
