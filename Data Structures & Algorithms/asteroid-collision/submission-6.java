class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            
            while (!stack.isEmpty() && (current < 0 && stack.peek() > 0)) {
                int collision = stack.pop();
                if (collision + current != 0) {
                    current = Math.abs(collision) > Math.abs(current) ? collision : current;
                } else {
                    current = 0;
                }
            }

            if (current != 0) {
                stack.push(current);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}