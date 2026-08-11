class Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int currNum = 0;
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
                continue;
            }
            switch (c) {
                case '[' -> {
                    countStack.push(currNum);
                    currNum = 0;
                    strStack.push(sb);
                    sb = new StringBuilder();
                }
                case ']' -> {
                    StringBuilder prev = strStack.pop();
                    int count = countStack.pop();
                    for (int i = 0; i < count; i++) {
                        prev.append(sb);
                    }
                    sb = prev;
                }
                default -> sb.append(c);
            }
        }

        return sb.toString();
    }
}