class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        combinations(1, n, k, new ArrayList<>(), output);
        return output;
    }

    public void combinations(int value, int n, int k, List<Integer> curComb, List<List<Integer>> output) {
        if (curComb.size() == k) {
            output.add(new ArrayList<>(curComb));
            return;
        }
        if (value > n) {
            return;
        }

        
        for (int i = value; i <= n; i++) {
            curComb.add(i);
            combinations(i + 1, n, k, curComb, output);
            curComb.remove(curComb.size() - 1);
        }
    }
}