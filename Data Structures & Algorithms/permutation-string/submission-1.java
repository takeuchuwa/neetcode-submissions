class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];
        for (int i = 0; i < n; i++) {
            s1Chars[s1.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Chars[i] == s2Chars[i]) {
                matches++;
            }
        }
        int left = 0;
        for (int right = n; right < m; right++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(right) - 'a';
            if (s1Chars[index] == s2Chars[index]) {
                matches--;
            }
            s2Chars[index]++;
            if (s1Chars[index] == s2Chars[index]) {
                matches++;
            }

            index = s2.charAt(left) - 'a';
            if (s1Chars[index] == s2Chars[index]) {
                matches--;
            }
            s2Chars[index]--;
            if (s1Chars[index] == s2Chars[index]) {
                matches++;
            }
            left++;
        }
        

        return matches == 26;
    }
}
