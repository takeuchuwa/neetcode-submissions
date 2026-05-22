class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        
        for (int i = 0; i < n; i++) {
            String iWord = words.get(i);
            if (words.get(i).length() > n) {
                return false;
            }
            for (int j = i + 1; j < n; j++) {
                String jWord = words.get(j);
                if (charAt(iWord, j) != charAt(jWord, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public char charAt(String word, int index) {
        return index < word.length() ? word.charAt(index) : '0';
    }
}
