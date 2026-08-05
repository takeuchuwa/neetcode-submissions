class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        int n = strings.length;
        boolean[] visited = new boolean[n];
        List<List<String>> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                List<String> sequence = new ArrayList<>();
                sequence.add(strings[i]);
                for (int j = i; j < n; j++) {
                    if (!visited[j] && isSameSequence(strings[i], strings[j])) {
                        sequence.add(strings[j]);
                        visited[j] = true;
                    }
                }
                output.add(sequence);
            }
        }

        return output;

    }

    private boolean isSameSequence(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int space = (string1.charAt(0) - string2.charAt(0) + 26) % 26;
        for (int i = 1; i < string1.length(); i++) {
            int currentSpace = (string1.charAt(i) - string2.charAt(i) + 26) % 26;
            if (currentSpace != space) {
                return false;
            }
        }

        return true;
    }

    // abc -> xyz  x - a == y - b == z - c
}
