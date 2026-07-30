class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = t.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    // public int numDistinct(String s, String t) {
    //     int[][] cache = new int[s.length()][t.length()];
    //     for (int[] c: cache) {
    //         Arrays.fill(c, -1);
    //     }
    //     return dfsHelper(s, t, 0, 0, cache);
    // }

    // private int dfsHelper(String s, String t, int i1, int i2, int[][] cache) {
    //     if (i2 == t.length()) {
    //         return 1;
    //     }
    //     if (i1 == s.length()) {
    //         return 0;
    //     }
    //     if (cache[i1][i2] != -1) {
    //         return cache[i1][i2];
    //     }
        
    //     cache[i1][i2] = 0;
    //     if (s.charAt(i1) == t.charAt(i2)) {
    //         cache[i1][i2] = dfsHelper(s, t, i1 + 1, i2 + 1, cache);
    //     }
    //     cache[i1][i2] += dfsHelper(s, t, i1 + 1, i2, cache);

    //     return cache[i1][i2];
    // }
}
