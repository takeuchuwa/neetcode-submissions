class Solution {
    public int change(int amount, int[] coins) {
        int a = amount + 1;
        int[] dp = new int[a];
        dp[0] = 1;
        

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 1; j < a; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[amount];
    }
}
