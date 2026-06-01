class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean hasZero = false;
        int zeroCounter = 0;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zeroCounter++;
                zeroIndex = i;
            }
        }

        int[] ans = new int[nums.length];
        if (zeroCounter == 1) {
            ans[zeroIndex] = product;
            return ans;
        } else if (zeroCounter == 0) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = product / nums[i];
            }
        }

        return ans;
    }
}  
