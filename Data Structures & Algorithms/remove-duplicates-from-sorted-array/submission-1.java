class Solution {
    public int removeDuplicates(int[] nums) {
        int pointerA = 0;
        int pointerB = 1;
        for (int i = 0; pointerB < nums.length; i++) {
            if (nums[pointerA] == nums[pointerB]) {
                pointerB++;
            } else {
                pointerA++;
                nums[pointerA] = nums[pointerB];
                pointerB++;
            }
        }

        return pointerA + 1;
    }
}