class Solution {
    public int removeElement(int[] nums, int val) {
        int pointerA = 0;
        int pointerB = 0;
        while(pointerB < nums.length) {
            if (nums[pointerB] != val) {
                nums[pointerA] = nums[pointerB];
                pointerA++;
            }
            pointerB++;
        }

        return pointerA;
    }
}