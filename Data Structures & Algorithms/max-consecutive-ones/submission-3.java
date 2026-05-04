class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0; 
        int counter = 0;
        for (int num : nums) {
            counter = (num == 1) ? counter + 1 : 0;
            if (counter > result) {
                result = counter;
            }
        
        }
        return result;
    }
}