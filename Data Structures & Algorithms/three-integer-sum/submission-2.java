class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                sum(nums, i + 1, n - 1, -nums[i], ans);
            }
        }

        return ans;
    }

    private void sum(int[] nums, int p1, int p2, int target, List<List<Integer>> ans) {
        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];
            if (sum == target) {
                ans.add(List.of(-target, nums[p1], nums[p2]));
                while (nums[p1] == nums[++p1] && p1 < p2);
                while (nums[p2] == nums[--p2] && p1 < p2);
            } else if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }
    }

}
