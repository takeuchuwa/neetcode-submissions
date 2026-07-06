class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        res.add(Collections.emptyList());

        for (int n : nums) {
            Set<List<Integer>> nextPerms = new HashSet<>();
            for (List<Integer> p : res) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> pCopy = new ArrayList<>(p);
                    pCopy.add(i, n);
                    nextPerms.add(pCopy);
                }
            }
            res = nextPerms;
        }

        return new ArrayList<>(res);
    }
}