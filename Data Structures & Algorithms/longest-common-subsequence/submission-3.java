class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[n][m];
    }

    private int dfsHelper(String text1, String text2, int i1, int i2, int[][] cache) {
        if (i1 == text1.length() || i2 == text2.length()) {
            return 0;
        }
        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        }

        if (text1.charAt(i1) == text2.charAt(i2)) {
            cache[i1][i2] = 1 + dfsHelper(text1, text2, i1 + 1, i2 + 1, cache);
        } else {
            cache[i1][i2] = Math.max(dfsHelper(text1, text2, i1 + 1, i2, cache), dfsHelper(text1, text2, i1, i2 + 1, cache));
        }

        return cache[i1][i2];
    }
}
