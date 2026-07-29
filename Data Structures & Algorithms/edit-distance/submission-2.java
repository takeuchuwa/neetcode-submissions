class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[n][m];
    }

    private int dfsHelper(String word1, String word2, int i1, int i2, int[][] cache) {
        if (i1 == word1.length() || i2 == word2.length()) {
            int val1 = word1.length() - i1;
            int val2 = word2.length() - i2;
            return  val1 > val2 ? val1 : val2;
        }
        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        }

        if (word1.charAt(i1) == word2.charAt(i2)) {
            cache[i1][i2] = dfsHelper(word1, word2, i1 + 1, i2 + 1, cache);
        } else {
            cache[i1][i2] = 1 + Math.min(dfsHelper(word1, word2, i1 + 1, i2 + 1, cache), 
                        Math.min(dfsHelper(word1, word2, i1 + 1, i2, cache), 
                            dfsHelper(word1, word2, i1, i2 + 1, cache)));
        }

        return cache[i1][i2];
    }
}