class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int counter = 0;
        for (int num: nums) {
            if (num == 1) {
                counter++;
            } else {
                if (counter > maxOnes) { 
                    maxOnes = counter;
                }
                counter = 0;
            }
        }
        return maxOnes > counter ? maxOnes : counter;
    }
}