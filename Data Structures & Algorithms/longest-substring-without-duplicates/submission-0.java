class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] present = new boolean[256];
        int L = 0;
        int R = 0;
        int max = 0;
        char[] chars = s.toCharArray();

        
        while (R < chars.length) {
            if (present[chars[R]]) {
                max = Math.max(max, R - L);
                while (present[chars[R]]) {
                    present[chars[L]] = false;
                    L++;
                }
            }
            present[chars[R]] = true;
            R++;
        }

        return Math.max(max, R - L);
    }
}
