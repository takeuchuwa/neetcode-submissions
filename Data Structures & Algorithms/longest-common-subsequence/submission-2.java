class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for (int[] c: cache) {
            Arrays.fill(c, -1);
        }
        return dfsHelper(text1, text2, 0, 0, cache);
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
