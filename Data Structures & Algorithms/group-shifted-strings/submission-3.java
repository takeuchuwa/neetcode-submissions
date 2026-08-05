class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        int n = strings.length;
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int strLength = strings[i].length();
            sb.append(strLength);
            sb.append('_');
            for (int j = 1; j < strLength; j++) {
                sb.append((strings[i].charAt(j) - strings[i].charAt(j - 1) + 26) % 26);
                sb.append('_');
            }
            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(strings[i]);
            sb.setLength(0);
        }

        return new ArrayList<>(map.values());

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
