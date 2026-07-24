class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int coin: coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    int prev = dp[i - coin];
                    int val = prev == -1 ? -1 : 1 + dp[i - coin];
                    if (val != -1) {
                        dp[i] = dp[i] == -1 ? val : Math.min(dp[i], val);
                    }
                }
            }
        }

        return dp[amount];
    }
}
