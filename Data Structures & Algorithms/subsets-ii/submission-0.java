class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(0, nums, subsets, new ArrayList<>());
        return subsets;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> subsets, List<Integer> curr) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        dfs(i + 1, nums, subsets, curr);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        curr.removeLast();
        dfs(i + 1, nums, subsets, curr);
    }
}
