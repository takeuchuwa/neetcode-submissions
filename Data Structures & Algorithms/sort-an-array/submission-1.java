class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return;
        }

        int pivot = nums[end];
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                int temp = nums[pointer];
                nums[pointer++] = nums[i];
                nums[i] = temp;
            }
        }

        nums[end] = nums[pointer];
        nums[pointer] = pivot;
        quickSort(nums, start, pointer - 1);
        quickSort(nums, pointer + 1, end);
    }
}