class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] cache = new int[nums.length][sum + 1];
        return dfsHelper(0, nums, 0, sum / 2, cache);
    }

    private boolean dfsHelper(int i, int[] nums, int sum, int target, int[][] cache) {
        if (sum > target || i == nums.length) {
            return false;
        }
        if (target == sum) {
            return true;
        }
        if (cache[i][sum] != 0) {
            return cache[i][sum] == target;
        }

        cache[i][sum] = sum;
        boolean canPartition = dfsHelper(i + 1, nums, sum, target, cache);
        if (canPartition) return true;

        cache[i][sum] = sum + nums[i];
        return dfsHelper(i + 1, nums, sum + nums[i], target, cache);
    }
}
