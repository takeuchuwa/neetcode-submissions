class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length, k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[r - 1];
        int p = l;

        for (int i = l; i < r - 1; i++) {
            if (nums[i] <= pivot) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
        
        nums[r - 1] = nums[p];
        nums[p] = pivot;

        if (p > k) {
            return quickSelect(nums, l, p, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, r, k);
        } else {
            return nums[p];
        }

    }
}
