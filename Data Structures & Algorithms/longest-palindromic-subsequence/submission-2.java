class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] cache = new int[n][n];
        for (int[] c: cache) {
            Arrays.fill(c, -1);
        }
        return helper(s, 0, n - 1, n, cache);        
    }

    private int helper(String s,int i1, int i2, int length, int[][] cache) {
        if (i1 > i2) {
            cache[i1][i2] = 0;
            return cache[i1][i2];
        }
        if (i1 == i2) {
            cache[i1][i2] = 1;
            return cache[i1][i2];
        }
        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        }
        
        if(s.charAt(i1) == s.charAt(i2)) {
            cache[i1][i2] = 2 + helper(s, i1 + 1, i2 - 1, length, cache);
        } else {
            cache[i1][i2] = Math.max(helper(s, i1 + 1, i2, length, cache), helper(s, i1, i2 - 1, length, cache));
        }

        return cache[i1][i2];
    }
}