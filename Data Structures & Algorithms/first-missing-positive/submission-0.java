class Solution {
    public int firstMissingPositive(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] > nums.length || nums[i] <= 0) {
                nums[i] = -1;
            } else {
                while (nums[i] <= nums.length && nums[i] > 0 
                        && nums[i] != nums[nums[i] - 1]) {
                        int tmp = nums[i];
                        nums[i] = nums[tmp - 1];
                        nums[tmp - 1] = tmp;
                    }
                }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}