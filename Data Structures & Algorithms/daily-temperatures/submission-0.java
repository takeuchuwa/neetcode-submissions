class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().getKey()) {
                Pair<Integer, Integer> prev = stack.pop();
                int prevTemp = prev.getKey();
                int prevIndex = prev.getValue();
                result[prevIndex] = i - prevIndex; 
            }

            stack.push(new Pair(temperatures[i], i));
        }

        return result;
    }
}
