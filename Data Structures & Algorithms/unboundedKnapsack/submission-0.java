class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[] dp = new int[capacity + 1];
        int n = profit.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j >= weight.get(i)) {
                    dp[j] = Math.max(dp[j], profit.get(i) + dp[j - weight.get(i)]);
                }
            }
        }

        return dp[capacity];
    }
}
