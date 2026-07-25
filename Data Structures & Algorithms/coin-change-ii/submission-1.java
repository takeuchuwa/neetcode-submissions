class Solution {
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length][amount + 1];
        return dfsHelper(0, amount, coins, cache);
    }

    private int dfsHelper(int i, int amount, int[] coins, int[][] cache) {
        if (i == coins.length) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (cache[i][amount] != 0) {
            return cache[i][amount];
        }

        cache[i][amount] += dfsHelper(i + 1, amount, coins, cache);
        int newAmount = amount - coins[i];
        if (newAmount >= 0) {
            cache[i][amount] += dfsHelper(i, newAmount, coins, cache);
        }

        return cache[i][amount];
    }
}
