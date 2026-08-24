class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> paranthesis = new ArrayList<>();
        dfs(0, 0, n, paranthesis, new StringBuilder());
        return paranthesis;
    }

    private void dfs(int openN, int closedN, int n, List<String> paranthesis, StringBuilder curr) {
        if (openN == closedN && openN == n) {
            paranthesis.add(curr.toString());
            return;
        }

        if (openN < n) {
            curr.append('(');
            dfs(openN + 1, closedN, n, paranthesis, curr);
            curr.deleteCharAt(curr.length() - 1); 
        }
        
        if (closedN < openN) {
            curr.append(')');
            dfs(openN, closedN + 1, n, paranthesis, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
