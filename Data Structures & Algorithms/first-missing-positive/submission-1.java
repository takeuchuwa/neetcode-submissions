class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length &&
                nums[nums[i] - 1] != nums[i]) {
                int tgt = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[tgt];
                nums[tgt] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}