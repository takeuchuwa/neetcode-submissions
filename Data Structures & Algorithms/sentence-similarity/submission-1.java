class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<Integer>> similarityMap = new HashMap<>();
        for (int i = 0; i < similarPairs.size(); i++) {
            for (String string: similarPairs.get(i)) {
                similarityMap.computeIfAbsent(string, k -> new HashSet<>()).add(i);
            }
        }

        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (!word1.equals(word2) &&
                    !(similarityMap.get(word1) != null && similarityMap.get(word2) != null &&
                        !Collections.disjoint(similarityMap.get(word1), similarityMap.get(word2)))) {
                return false;
            }
        }

        return true;
    }
}
