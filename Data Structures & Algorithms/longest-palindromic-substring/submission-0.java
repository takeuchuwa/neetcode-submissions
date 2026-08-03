class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int leftIndexResult = -1;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                int cur = r - l + 1;
                if (cur > max) {
                    max = cur;
                    leftIndexResult = l;
                }
                l--;
                r++;
            }
            
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                int cur = r - l + 1;
                if (cur > max) {
                    max = cur;
                    leftIndexResult = l;
                }
                l--;
                r++;
            }
        }

        return leftIndexResult == -1 ? "" : s.substring(leftIndexResult, leftIndexResult + max);
    }
}
