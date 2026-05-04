class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');
        Stack<Character> stack = new Stack<>();
         for(char c: s.toCharArray()) {
            if(brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
         }

        return stack.isEmpty();
    }
}
