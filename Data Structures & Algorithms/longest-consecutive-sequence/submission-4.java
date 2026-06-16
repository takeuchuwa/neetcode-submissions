class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind union = new UnionFind();
        for (int i = 0; i < nums.length; i++) {
            union.insert(nums[i]);
        }

        return nums.length > 0 ? union.max : 0;
    }

    class UnionFind {
        private Map<Integer, Integer> parents;
        private Map<Integer, Integer> ranks;
        private Map<Integer, Integer> count;
        private int max;

        private UnionFind() {
            parents = new HashMap<>();
            ranks = new HashMap<>();
            count = new HashMap<>();
            max = 1;
        }

        private void insert(int n) {
            if (!parents.containsKey(n)) {
                parents.put(n, n);
                ranks.put(n, 0);
                count.put(n, 1);
                union(n, n - 1);
                union(n, n + 1);
            }
        }

        private Integer find(int n) {
            if (!parents.containsKey(n)) return null;

            Integer p = parents.get(n);
            while (p != parents.get(p)) {
                parents.put(p, parents.get(parents.get(p)));
                p = parents.get(p);
            }

            return p;
        }

        private boolean union(int n1, int n2) {
            int p1 = find(n1);
            Integer p2Nullable = find(n2);

            if (p2Nullable == null) return false;
            int p2 = p2Nullable;
            if (p1 == p2) return false;

            if (ranks.get(p1) > ranks.get(p2)) {
                parents.put(p2, p1);
                count.merge(p1, count.get(p2), Integer::sum);
                max = Math.max(max, count.get(p1));
            } else if (ranks.get(p2) > ranks.get(p1)) {
                parents.put(p1, p2);
                count.merge(p2, count.get(p1), Integer::sum);
                max = Math.max(max, count.get(p2));
            } else {
                parents.put(p1, p2);
                ranks.merge(p2, 1, Integer::sum);
                count.merge(p2, count.get(p1), Integer::sum);
                max = Math.max(max, count.get(p2));
            }

            return true;
        }
    }
}
