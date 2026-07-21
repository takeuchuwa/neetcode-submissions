class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Boolean[][] cache = new Boolean[nums.length][sum + 1];
        return dfsHelper(0, nums, sum / 2, cache);
    }

    private boolean dfsHelper(int i, int[] nums,int target, Boolean[][] cache) {
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (i == nums.length) {
            return false;
        }
        if (cache[i][target] != null) {
            return cache[i][target];
        }

        cache[i][target] = dfsHelper(i + 1, nums, target, cache) ||
                            dfsHelper(i + 1, nums, target - nums[i], cache);
        return cache[i][target];
    }
}
