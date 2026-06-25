class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && candidate2 != nums[i]) {
                candidate1 = nums[i];
            } else if (count2 == 0 && candidate1 != nums[i]) {
                candidate2 = nums[i];
            }
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else {
                count2--;
                count1--;
            }
        }
        
        List<Integer> majority = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        int threshold = n / 3;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > threshold) {
            majority.add(candidate1);
        }
        if (count2 > threshold) {
            majority.add(candidate2);
        }

        return majority;
    }
}