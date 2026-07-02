class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(0, nums, output, 0, target, new ArrayList<>());
        return output;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> output, int sum, int target, List<Integer> curComb) {
        if (sum == target) {
            output.add(new ArrayList<>(curComb));
            return;
        }

        if (i == nums.length) {
            return;
        }

        if (target - sum >= nums[i]) {
            curComb.add(nums[i]);
            sum += nums[i];
            dfs(i, nums, output, sum, target, curComb);
            curComb.remove(curComb.size() - 1);
            sum -= nums[i];
        }

        dfs(++i, nums, output, sum, target, curComb);

    }
}
