class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length);
    }

    public int majorityElement(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        int left = majorityElement(nums, start, mid);
        int right = majorityElement(nums, mid, end);
        if (left != right) {
            int count = 0;
            for (int i = start; i < end; i++) {
                if (nums[i] == left) {
                    count++;
                }
            }
            return count > (end - start) / 2 ? left : right;
        }

        return left;
    }
}