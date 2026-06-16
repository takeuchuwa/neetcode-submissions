class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind union = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            union.insert(edges[i][0], edges[i][1]);
        }

        return union.disconnectedGraphs;
    }

    class UnionFind {
        private int[] parents;
        private int[] ranks;
        private int disconnectedGraphs;

        private UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            disconnectedGraphs = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private int find(int n) {
            int parent = parents[n];
            while (parent != parents[parent]) {
                parents[parent] = parents[parents[parent]];
                parent = parents[parent];
            }

            return parent;
        }

        private void insert(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) return;

            if (p1 > p2) {
                parents[p2] = p1;
            } else if (p2 > p1) {
                parents[p1] = p2;
            } else {
                parents[p1] = p2;
                ranks[p2]++;
            }
            disconnectedGraphs--;
        }
    }
}
