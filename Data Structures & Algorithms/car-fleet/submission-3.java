class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for (int[] p : pair) {
            double turns = (double) (target - p[0]) / p[1];
            if (!stack.isEmpty() &&
                turns <= stack.peek()) {
                turns = Math.max(stack.pop(), turns);
            }
            stack.push(turns);
        }

        return stack.size();
    }
}
