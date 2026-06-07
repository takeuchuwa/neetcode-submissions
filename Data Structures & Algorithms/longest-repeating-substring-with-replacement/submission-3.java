class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        
        int L = 0;
        int max = 0;
        int maxFreq = 0;
        for (int R = 0; R < s.length(); R++) {
            freq.merge(s.charAt(R), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(R)));
            if (R - L + 1 > maxFreq + k) {
                freq.merge(s.charAt(L), -1, Integer::sum);
                L++;
            }
            max = Math.max(max, R - L + 1);
        }

        return max;
    }
}
