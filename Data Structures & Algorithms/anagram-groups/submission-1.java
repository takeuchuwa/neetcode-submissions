class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++; 
            }
            String key = new String(count);
            
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
