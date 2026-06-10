class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] postfix = new int[n];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            postfix[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            if (postfix[i] == sum) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}