class Solution {
    public String decodeString(String s) {
        Deque<Object> stack = new ArrayDeque<>();
        StringBuilder decodedString = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == ']') {
                List<String> temp = new ArrayList<>();
                while (stack.peek() instanceof String) {
                    String curr = (String) stack.pop();
                    if (!"[".equals(curr)) {
                        temp.add(curr);
                    }
                }
                System.out.println(temp);
                for (int i = temp.size() - 1; i >= 0; i--) {
                    decodedString.append(temp.get(i));
                }
                String curr = decodedString.toString();
                stack.push(curr.repeat((Integer) stack.pop()));
                decodedString.setLength(0);
            } else if (Character.isDigit(c)) {
                int number = 0;
                if (stack.peek() instanceof Integer) {
                    number = (Integer) stack.pop() * 10;
                }
                number += c - '0';
                stack.push(number);
            } else {
                stack.push(String.valueOf(c));
            }    
        }

        Iterator<Object> reverseIt = stack.descendingIterator();

        while (reverseIt.hasNext()) {
            decodedString.append((String) reverseIt.next());
        }

        return decodedString.toString();
    }
}