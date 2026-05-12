class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combinationSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, combinationSubsets, target);
        return combinationSubsets;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> combinationSubsets, int target) {
        if (i >= nums.length) {
            return;
        }
        
        subset.add(nums[i]);
        int sum = subset.stream()
              .mapToInt(Integer::intValue)
              .sum();
        
        
        if (sum >= target) {
            if (sum == target) {
                combinationSubsets.add(new ArrayList<>(subset));
            }
            subset.remove(subset.size() - 1);
            dfs(nums, i + 1, subset, combinationSubsets, target);
            return;
        }

        
        dfs(nums, i, subset, combinationSubsets, target);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, combinationSubsets, target);

    }
}
