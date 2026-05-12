class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combinationSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, subset, combinationSubsets, target, 0);
        return combinationSubsets;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> combinationSubsets, int target, int sum) {
        if (sum == target) {
            combinationSubsets.add(new ArrayList(subset));
            return;
        }
        
        for (int j = i; j < nums.length; j++) {
            if (sum + nums[j] > target) {
                return;
            }
            subset.add(nums[j]);
            dfs(nums, j, subset, combinationSubsets, target, sum + nums[j]);
            subset.remove(subset.size() - 1);
        }
    }
}
