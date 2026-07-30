class Solution {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()][t.length()];
        for (int[] c: cache) {
            Arrays.fill(c, -1);
        }
        return dfsHelper(s, t, 0, 0, cache);
    }

    private int dfsHelper(String s, String t, int i1, int i2, int[][] cache) {
        if (i2 == t.length()) {
            return 1;
        }
        if (i1 == s.length()) {
            return 0;
        }
        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        }
        cache[i1][i2] = 0;
        if (s.charAt(i1) == t.charAt(i2)) {
            cache[i1][i2] = dfsHelper(s, t, i1 + 1, i2 + 1, cache);
        }
        cache[i1][i2] += dfsHelper(s, t, i1 + 1, i2, cache);

        return cache[i1][i2];
    }
}
