class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            minCapital.add(new int[] {capital[i], i});
        }

        int curK = 0;
        int maxCapital = w;
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);
        while (curK < k) {
            if (!minCapital.isEmpty() && minCapital.peek()[0] <= maxCapital) {
                maxProfit.add(profits[minCapital.poll()[1]]);
            } else if (!maxProfit.isEmpty()) {
                maxCapital += maxProfit.poll();
                curK++;
            } else {
                break;
            }
        }

        return maxCapital;
    }
}