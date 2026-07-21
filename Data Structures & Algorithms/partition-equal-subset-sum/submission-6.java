class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        boolean[] nextDp = new boolean[target + 1];
        dp[0] = true;
        

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    nextDp[j] = dp[j] || dp[j - nums[i]];
                } else {
                    nextDp[j] = dp[j];
                }
            }
            boolean[] temp = dp;
            dp = nextDp;
            nextDp = temp;
            
        }

        return dp[target];
    }

    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for (int num: nums) {
    //         sum += num;
    //     }
    //     if (sum % 2 != 0) {
    //         return false;
    //     }
    //     Boolean[][] cache = new Boolean[nums.length][sum + 1];
    //     return dfsHelper(0, nums, sum / 2, cache);
    // }

    // private boolean dfsHelper(int i, int[] nums,int target, Boolean[][] cache) {
    //     if (target < 0) {
    //         return false;
    //     }
    //     if (target == 0) {
    //         return true;
    //     }
    //     if (i == nums.length) {
    //         return false;
    //     }
    //     if (cache[i][target] != null) {
    //         return cache[i][target];
    //     }

    //     cache[i][target] = dfsHelper(i + 1, nums, target, cache) ||
    //                         dfsHelper(i + 1, nums, target - nums[i], cache);
    //     return cache[i][target];
    // }
}
