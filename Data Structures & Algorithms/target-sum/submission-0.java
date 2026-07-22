class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        int[][] memo = new int[nums.length][sum * 2 + 1];
        for (int[] m: memo) {
            Arrays.fill(m, -1);
        }
        return dfsHelper(0, nums, 0, target, memo);
    }

    private int dfsHelper(int i, int[] nums, int sum, int target, int[][] memo) {
        if (i == nums.length) {
            return target == sum ? 1 : 0;
        }
        int memI = sum < 0 ? memo[0].length + sum : sum;
        if (memo[i][memI] != -1) {
            return memo[i][memI];
        }

        memo[i][memI] = dfsHelper(i + 1, nums, sum - nums[i], target, memo) + dfsHelper(i + 1, nums, sum + nums[i], target, memo);

        return memo[i][memI];
    }
}