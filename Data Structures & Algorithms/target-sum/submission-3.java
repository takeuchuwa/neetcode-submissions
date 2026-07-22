class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        int t = 2 * sum + 1;
        int[] dp = new int[t];
        dp[sum] = 1;

        for (int num: nums) {
            int[] nextDp = new int[t];
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] != 0) {
                    int total = i - sum;
                    int count = dp[i];
                    nextDp[i + num] += count;
                    nextDp[i - num] += count;
                }
            }
            dp = nextDp;
        }   

        int i = sum + target;
        return i < t ? dp[i] : 0;
    }
}