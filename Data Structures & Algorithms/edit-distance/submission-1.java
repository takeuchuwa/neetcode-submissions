class Solution {
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        for (int[] c: cache) {
            Arrays.fill(c, -1);
        }
        return dfsHelper(word1, word2, 0, 0, cache);
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

// horse  
// ros -> hos -> hors -> horse


// 1 h == r -> ho == ro -> 2 hor == ros -> hors = ros[] 



