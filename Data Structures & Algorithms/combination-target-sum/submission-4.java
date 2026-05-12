class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combinationSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, combinationSubsets, target);
        return combinationSubsets;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> combinationSubsets, int target) {
        if (i >= nums.length) {
            if (target == 0) {
                combinationSubsets.add(new ArrayList(subset));
            }
            return;
        }

        if (nums[i] <= target) {
            subset.add(nums[i]);
            dfs(nums, i, subset, combinationSubsets, target - nums[i]);
            subset.remove(subset.size() - 1);
        }
        
        dfs(nums, i + 1, subset, combinationSubsets, target);

    }
}
