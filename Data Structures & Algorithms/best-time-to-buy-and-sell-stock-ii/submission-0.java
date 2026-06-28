class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int l = 0;
        int n = prices.length;
        for (int r = 1; r < n; r++) {
            if (prices[r - 1] > prices[r]) {
                profit += prices[r - 1] - prices[l];
                l = r;
            }
        }

        if (n > l && prices[n - 1] > prices[l]) {
            profit += prices[n - 1] - prices[l];
        }

        return profit;
    }
}