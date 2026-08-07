class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (l <= r) {
            i = l + (r - l) / 2;
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return nums[i] > target ? i : i + 1;
    }
}