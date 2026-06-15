class PrefixTree {
    TrieNode root;

    public PrefixTree() {
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
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (Character c : word.toCharArray()) {
            if (curr.children.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (Character c : prefix.toCharArray()) {
            if (curr.children.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }

    class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean word;
    }
}
