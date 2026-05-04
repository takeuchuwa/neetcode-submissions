class Solution {
    public int calPoints(String[] operations) {
        List<String> stack = new ArrayList<>();
        for (String op : operations) {
            switch (op) {
                case "D" -> {
                    String number = stack.remove(stack.size() - 1);
                    String multiplication = String.valueOf(2 * Integer.valueOf(number));
                    stack.add(number);
                    stack.add(multiplication);
                }
                case "C" -> {
                    stack.remove(stack.size() - 1);
                }
                case "+" -> {
                    String secondNumber = stack.remove(stack.size() - 1);
                    String firstNumber = stack.remove(stack.size() - 1);
                    String sum = String.valueOf(Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber));
                    stack.add(firstNumber);
                    stack.add(secondNumber);
                    stack.add(sum);
                }
                default -> {
                    stack.add(op);
                }
            }
        }

        return stack.stream().mapToInt(Integer::parseInt).sum();
    }
}