class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (Character c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int index, String word, TrieNode curr) {
    for (int i = index; i < word.length(); i++) {
        char c = word.charAt(i);

        if (c == '.') {
            for (TrieNode child : curr.children.values()) {
                if (dfs(i + 1, word, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
    }
    return curr.word;
}

    class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean word;
    }
}
