class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        max[0] = nums[0];
        max[1] = nums[1];
        max[2] = nums[0] + nums[2];
        int ans = Math.max(max[1], max[2]);
        for (int i = 3; i < n; i++) {
            max[i] = Math.max(max[i - 3], max[i - 2]) + nums[i];
            ans = Math.max(max[i], ans);
        }

        return ans;
    }
}
