class Solution {
    public int removeDuplicates(int[] nums) {
        int pointerA = 0;
        int pointerB = 1;
        while(pointerB < nums.length) {
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