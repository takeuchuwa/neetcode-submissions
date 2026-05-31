class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];

        int L = 0;
        int R = 0;
        int N = nums.length;

        while (L < N) {
            if (curSum < 0 && L < R) {
                curSum = 0;
                L = R;
            }

            curSum += nums[R];
            maxSum = Math.max(curSum, maxSum);
            R = (R + 1) % N;
            if (R == L) {
                L++;
                R++;
                curSum = 0;
            }
        }

        return maxSum;
    }
}