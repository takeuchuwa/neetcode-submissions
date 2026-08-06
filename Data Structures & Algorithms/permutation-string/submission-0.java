class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] s1Chars = new int[26];
        for (char c : s1.toCharArray()) {
                s1Chars[c - 'a']++;
            }

        int j = n - 1;
        int i = 0;
        while (j < m) {
            int[] s2Chars = new int[26];
            for (char c : s2.substring(i, j + 1).toCharArray()) {
                s2Chars[c - 'a']++;
            }
            boolean match = true;
            for (int k = 0; k < 26; k++) {
                match &= s1Chars[k] == s2Chars[k]; 
            }
            if (match) {
                return match;
            }
            i++;
            j++;
        }

        return false;
    }
}
