class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int L = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int R = 0; R < s.length(); R++) {
            int rightCharIndex = s.charAt(R) - 'A';
            freq[rightCharIndex]++;
            
            maxFreq = Math.max(maxFreq, freq[rightCharIndex]);

            if (R - L + 1 > maxFreq + k) {
                int leftCharIndex = s.charAt(L) - 'A';
                freq[leftCharIndex]--;
                L++; 
            }

            maxLength = Math.max(maxLength, R - L + 1);
        }

        return maxLength;
    }
}
