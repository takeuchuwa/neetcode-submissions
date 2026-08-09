class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = nums[0];

        while (low <= high) {
            if (nums[low] < nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            int middle = low + (high - low) / 2;
            min = Math.min(min, nums[middle]);
            if (nums[middle] < min) {
                high = middle - 1;
            } else {
                low = low + 1;
            }
        }
        
        return min;
    }
}
