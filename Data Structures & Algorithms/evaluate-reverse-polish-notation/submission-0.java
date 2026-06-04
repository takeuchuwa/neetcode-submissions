class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> operations = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+" -> {
                    String op2 = operations.pop();
                    String op1 = operations.pop();
                    Integer result = Integer.valueOf(op1) + Integer.valueOf(op2);
                    operations.push(result.toString());
                } 
                case "-" -> {
                    String op2 = operations.pop();
                    String op1 = operations.pop();
                    Integer result = Integer.valueOf(op1) - Integer.valueOf(op2);
                    operations.push(result.toString());
                } 
                case "*" -> {
                    String op2 = operations.pop();
                    String op1 = operations.pop();
                    Integer result = Integer.valueOf(op1) * Integer.valueOf(op2);
                    operations.push(result.toString());
                } 
                case "/" -> {
                    String op2 = operations.pop();
                    String op1 = operations.pop();
                    Integer result = Integer.valueOf(op1) / Integer.valueOf(op2);
                    operations.push(result.toString());
                } 
                default -> operations.push(tokens[i]);
            }
        }

        return Integer.valueOf(operations.pop());
    }
}
