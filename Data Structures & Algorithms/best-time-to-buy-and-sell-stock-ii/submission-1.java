class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int r = 1; r < n; r++) {
            if (prices[r] > prices[r - 1]) {
                profit += prices[r] - prices[r - 1];
            }
        }

        return profit;
    }
}