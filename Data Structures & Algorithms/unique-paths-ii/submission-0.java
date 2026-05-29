class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] prevRow = new int[m];
        prevRow[m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            int[] curRow = new int[m];
            curRow[m - 1] = obstacleGrid[i][m - 1] == 1 ? 0 : prevRow[m - 1];
            for (int j = m - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    curRow[j] = 0;
                } else {
                    curRow[j] = curRow[j + 1] + prevRow[j];
                }
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}