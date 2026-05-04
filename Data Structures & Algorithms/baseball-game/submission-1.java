class Solution {
    public int calPoints(String[] operations) {
        List<Integer> stack = new ArrayList<>();
        for (String op : operations) {
            switch (op) {
                case "D" -> {
                    Integer number = stack.remove(stack.size() - 1);
                    Integer multiplication = 2 * number;
                    stack.add(number);
                    stack.add(multiplication);
                }
                case "C" -> {
                    stack.remove(stack.size() - 1);
                }
                case "+" -> {
                    Integer secondNumber = stack.remove(stack.size() - 1);
                    Integer firstNumber = stack.remove(stack.size() - 1);
                    Integer sum = firstNumber + secondNumber;
                    stack.add(firstNumber);
                    stack.add(secondNumber);
                    stack.add(sum);
                }
                default -> {
                    stack.add(Integer.parseInt(op));
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}