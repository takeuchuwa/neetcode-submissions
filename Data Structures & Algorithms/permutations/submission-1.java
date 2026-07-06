class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(Collections.emptyList());

        for (int n : nums) {
            List<List<Integer>> nextPerms = new ArrayList<>();
            for (List<Integer> p : perms) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> pCopy = new ArrayList<>(p);
                    pCopy.add(i, n);
                    nextPerms.add(pCopy);
                }
            }
            perms = nextPerms;
        }

        return perms;
    }
}
