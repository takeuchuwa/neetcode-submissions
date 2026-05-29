class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[m];

        for (int i = n - 1; i >= 0; i--) {
            int[] curRow = new int[m];
            curRow[m - 1] = 1;
            for (int j = m - 2; j >= 0; j--) {
                curRow[j] = curRow[j + 1] + prevRow[j];
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}
