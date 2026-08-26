class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }

        int minLeft = -1;
        int minRight = Integer.MAX_VALUE - 1;

        Map<Character, Integer> charactersCount = new HashMap<>();
        for (char c: t.toCharArray()) {
            charactersCount.merge(c, 1, Integer::sum);
        }

        
        Map<Character, Integer> windowCharactersCount = new HashMap<>();
        int found = 0;
        int need = charactersCount.size();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            Integer currentCount = windowCharactersCount.merge(curr, 1, Integer::sum);
            Integer originalCount = charactersCount.get(curr);
            if (currentCount.equals(originalCount)) {
                found++;
            }

            while (found == need) {
                if (right - left < minRight - minLeft) {
                    minRight = right;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                int currCharCount = windowCharactersCount.merge(leftChar, -1, Integer::sum);
                if (charactersCount.containsKey(leftChar) && currCharCount < charactersCount.get(leftChar)) {
                    found--;
                }
                left++;
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minRight + 1);
    }
}
