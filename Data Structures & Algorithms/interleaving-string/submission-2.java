class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] cache = new Boolean[s1.length()][s2.length()]; 
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        return dfsHelper(s1, s2, s3, 0, 0, cache);
    }

    private boolean dfsHelper(String s1, String s2, String s3, int i1, int i2, Boolean[][] cache) {
        int i3 = i1 + i2;
        if (i1 == s1.length()) {
            while (i2 != s2.length()) {
                if (s2.charAt(i2) != s3.charAt(i3)) {
                    return false;
                }
                i2++;
                i3++;
            }

            return true;
        } else if (i2 == s2.length()) {
            while (i1 != s1.length()) {
                if (s1.charAt(i1) != s3.charAt(i3)) {
                    return false;
                }
                i1++;
                i3++;
            }

            return true;
        }

        if (cache[i1][i2] != null) {
            return cache[i1][i2];
        }
        cache[i1][i2] = false;
        if (s1.charAt(i1) == s3.charAt(i3)) {
            cache[i1][i2] |= dfsHelper(s1,s2,s3, i1 + 1, i2, cache);
        } 
        if (s2.charAt(i2) == s3.charAt(i3)) {
            cache[i1][i2] |= dfsHelper(s1,s2,s3, i1, i2 + 1, cache);
        }
        
        return cache[i1][i2];
    }
}
