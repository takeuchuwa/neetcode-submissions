class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1 = 0;
        int i2 = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 < word1.length() && i2 < word2.length()) {
            if (i2 < i1) {
                sb.append(word2.charAt(i2));
                i2++;
            } else {
                sb.append(word1.charAt(i1));
                i1++;
            }
        }

        if (i1 < word1.length()) {
            sb.append(word1.substring(i1));
        }

        if (i2 < word2.length()) {
            sb.append(word2.substring(i2));
        }

        return sb.toString();
    }
}