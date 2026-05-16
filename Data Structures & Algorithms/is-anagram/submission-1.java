class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;

        if (s.length() != t.length()) return false;

        Map<Character, Integer> characters = new HashMap<>();
        for (char c : s.toCharArray()) {
            characters.merge(c, 1, Integer::sum); 
        }

        for (char c : t.toCharArray()) {
            Integer count = characters.get(c);
            if (count == null || count == 0) {
                return false;
            } else {
                characters.put(c, --count);
            }
        }

        return true;

    }
}
