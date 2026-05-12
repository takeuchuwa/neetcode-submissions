class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, subsets);
        return subsets;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i + 1, subset, subsets);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, subsets);
    }
}
