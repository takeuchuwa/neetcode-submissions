class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie(strs[0]);
        String max = strs[0];
        for (int i = 1; i < strs.length; i++) {
            max = trie.maxCommon(strs[i]);
        }

        return max;

    }

    class Trie {
        TrieNode root;

        Trie(String word) {
            root = new TrieNode();
            TrieNode curr = root;
            for (char c: word.toCharArray()) {
                curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.stop = true;
        }

        private String maxCommon(String word) {
            int i = 0;
            TrieNode curr = root;
            while (i < word.length() && !curr.stop && curr.children[word.charAt(i) - 'a'] != null) {
                curr = curr.children[word.charAt(i) - 'a'];
                i++;
            }

            curr.stop = true;

            return word.substring(0, i);
        }
    }

    class TrieNode {
        private TrieNode[] children;
        private boolean stop;
        
        TrieNode() {
            children = new TrieNode[26];
        }
    }
}