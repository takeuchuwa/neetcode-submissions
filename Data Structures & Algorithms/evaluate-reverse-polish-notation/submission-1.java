class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> operations = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+-*/".contains(tokens[i])) {
                int b = operations.pop();
                int a = operations.pop();
                
                operations.push(switch (tokens[i]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new IllegalArgumentException();
                });
            } else {
                operations.push(Integer.parseInt(tokens[i]));
            }
        }

        return Integer.valueOf(operations.pop());
    }
}
