class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int L = 0;
        int min = n + 1;
        
        for (int R = 0; R < n; R++) {
            sum += nums[R];
            while (sum >= target) {
                min = Math.min(R - L + 1, min);
                sum -= nums[L];
                L++;
            }
        }

        return min == n + 1 ? 0 : min;
    }
}