class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone: stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        int j = 0;
        for (int stone: stones) {
            int[] nextDp = new int[target + 1];
            for (int i = 0; i <= target; i++) {
                int skip = dp[i];
                int val = 0;
                if (i >= stone) {
                    val = stone + dp[i - stone];
                }
                nextDp[i] = Math.max(val, skip);
            }
            dp = nextDp;
        }

        return sum - 2 * dp[target];
    }
}