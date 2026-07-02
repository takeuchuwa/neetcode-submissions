class Solution {

    static int[][] letters = {{'a', 'c'}, 
    {'d', 'f'}, 
    {'g', 'i'}, 
    {'j', 'l'}, 
    {'m', 'o'}, 
    {'p', 's'}, 
    {'t', 'v'}, 
    {'w', 'z'}} ;

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return Collections.emptyList();
        }
        List<String> output = new ArrayList<>();
        dfs(0, digits, output, new StringBuilder());
        return output;
    }

    public void dfs(int i, String digits, List<String> output, StringBuilder curComb) {
        if (i == digits.length()) {
            output.add(curComb.toString());
            return;
        }

        int index = digits.charAt(i) - '2';
        for (int j = letters[index][0]; j <= letters[index][1]; j++) {
            curComb.append((char) j);
            dfs(i + 1, digits, output, curComb);
            curComb.deleteCharAt(curComb.length() - 1);
        }
    }
}