class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int currentSize = subsets.size();
            for (int j = 0; j < currentSize; j++) {
                List<Integer> prevSubset = new ArrayList<>(subsets.get(j));
                prevSubset.add(num);
                subsets.add(prevSubset);
            }
        }

        return subsets;
    }
}
