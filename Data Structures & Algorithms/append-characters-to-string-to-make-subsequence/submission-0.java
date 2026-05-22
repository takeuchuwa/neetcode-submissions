class Solution {
    public int appendCharacters(String s, String t) {
        int tPointer = 0;
        int sPointer = 0;
        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                tPointer++;
            }
            sPointer++;
        }
        
        return tPointer < t.length() ? t.substring(tPointer).length() : 0;
    }
}