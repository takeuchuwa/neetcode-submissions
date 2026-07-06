class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0, nums);
    }

    private List<List<Integer>> helper(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> out = new ArrayList<>();
            out.add(Collections.emptyList());
            return out;
        }

        List<List<Integer>> resPerms = new ArrayList<>();
        List<List<Integer>> perms = helper(i + 1, nums);
        for (List<Integer> p : perms) {
            for (int j = 0; j <= p.size(); j++) {
                List<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(j, nums[i]);
                resPerms.add(pCopy);
            }
        }

        return resPerms;
    }
}
