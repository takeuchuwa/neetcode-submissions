class Solution {
    public int lengthOfLastWord(String s) {
        int cur = 0;
        int lastWord = 0;
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                cur = 0;
            } else {
                cur++;
                lastWord = cur;
            }
        }

        return lastWord;
    }
}