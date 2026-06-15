class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }
        
        List<String> output = new ArrayList<>();
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                output.addAll(dfs(trie.root, board, i, j, new int[ROWS][COLS]));
            }
        }

        return output;
    }

    private List<String> dfs(TrieNode curr, char[][] board, int r, int c, int[][] visited) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (r == ROWS || c == COLS || r < 0 || c < 0 ||
            visited[r][c] == 1 || curr.children[board[r][c] - 'a'] == null) 
            return Collections.emptyList();

        visited[r][c] = 1;
        List<String> output = new ArrayList<>();
        TrieNode child = curr.children[board[r][c] - 'a'];
        if (child.word != null) {
            output.add(child.word);
            child.word = null;
        }

        output.addAll(dfs(child, board, r + 1, c, visited));
        output.addAll(dfs(child, board, r - 1, c, visited));
        output.addAll(dfs(child, board, r, c + 1, visited));
        output.addAll(dfs(child, board, r, c - 1, visited));
        visited[r][c] = 0;

        boolean isEmpty = true;
        for (int i = 0; i < 26; i++) {
            if (child.children[i] != null) {
                isEmpty = false;
                break;
            }
        }
        
        if (isEmpty) {
            curr.children[board[r][c] - 'a'] = null;
        }

        return output;
    }

    class Trie {

        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (Character c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
    }

    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private String word;
    }
}
