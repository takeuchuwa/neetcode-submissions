class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] cache = new int[profit.size()][capacity + 1];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return dfsHelper(0, profit, weight, capacity, cache);
    }

    public int dfsHelper(int i, List<Integer> profit, List<Integer> weight, int capacity, int[][] cache) {
        if (i == profit.size()) {
            return 0;
        }
        if (cache[i][capacity] != -1) {
            return cache[i][capacity];
        }

        cache[i][capacity] = dfsHelper(i + 1, profit, weight, capacity, cache);

        int newCapacity = capacity - weight.get(i);
        
        if (newCapacity >= 0) {
            int prof = profit.get(i) + dfsHelper(i + 1, profit, weight, newCapacity, cache);
            cache[i][capacity] = Math.max(cache[i][capacity], prof);
        }

        return cache[i][capacity];
    }
}
