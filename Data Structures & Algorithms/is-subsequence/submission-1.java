class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int pointer = 0;
        int pointer2 = 0;
        while (pointer < s.length() && pointer2 < t.length()) {
            if (s.charAt(pointer) == t.charAt(pointer2)) {
                pointer++;
            }

            pointer2++;
        }

        return pointer == s.length();
    }
}