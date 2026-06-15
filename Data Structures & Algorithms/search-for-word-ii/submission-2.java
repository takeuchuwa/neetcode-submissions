class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }
        
        Set<String> output = new HashSet<>();
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                output.addAll(dfs(trie.root, board, i, j, new int[ROWS][COLS]));
            }
        }

        return new ArrayList<>(output);
    }

    private Set<String> dfs(TrieNode curr, char[][] board, int r, int c, int[][] visited) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (r == ROWS || c == COLS || r < 0 || c < 0 ||
            visited[r][c] == 1 || !curr.children.containsKey(board[r][c])) 
            return new HashSet<>();

        visited[r][c] = 1;
        curr = curr.children.get(board[r][c]);
        Set<String> output = new HashSet<>();
        if (curr.isEnd) {
            output.add(curr.word);
        }

        output.addAll(dfs(curr, board, r + 1, c, visited));
        output.addAll(dfs(curr, board, r - 1, c, visited));
        output.addAll(dfs(curr, board, r, c + 1, visited));
        output.addAll(dfs(curr, board, r, c - 1, visited));
        visited[r][c] = 0;

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
                if (curr.children.get(c) == null) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
            curr.word = word;
        }
    }

    class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean isEnd;
        private String word;
    }
}
