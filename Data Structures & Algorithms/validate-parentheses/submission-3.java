class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of('}', '{', ']', '[', ')', '(');
        List<Character> stack = new ArrayList<>(s.length() / 2 + 1);
         for(char c: s.toCharArray()) {
            if(brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.remove(stack.size() - 1) != brackets.get(c)) {
                    return false;
                }
            } else {
                stack.add(c);
            }
         }

        return stack.isEmpty();
    }
}
