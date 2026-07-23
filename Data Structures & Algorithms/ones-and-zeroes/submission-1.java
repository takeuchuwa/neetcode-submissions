class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str: strs) {
            int[] pair = count(str);
            int[][] nextDp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    nextDp[i][j] = dp[i][j];
                    if (i >= pair[0] && j >= pair[1]) {
                        nextDp[i][j] = Math.max(dp[i][j], 1 + dp[i - pair[0]][j - pair[1]]);
                    }
                }
            }
            dp = nextDp;
        }

        return dp[m][n];
    }

    private int[] count(String str) {
        int[] res = new int[2];
        for (char c: str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }
}