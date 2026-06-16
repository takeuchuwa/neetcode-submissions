class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind union = new UnionFind(n);
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (!union.insert(edges[i])) {
                res = edges[i];
            }
        }

        return res;
    }

    class UnionFind {

        int[] nodes;
        int[] parents;

        UnionFind(int n) {
            nodes = new int[n];
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = 0;
                parents[i] = i;
            }
        }

        int find(int n) {
            int p = parents[n - 1];
            while (p != parents[p]) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }

            return p;
        }

        boolean insert(int[] edge) {
            int p1 = find(edge[0]);
            int p2 = find(edge[1]);

            if (p1 == p2) return false;

            if (nodes[p1] > nodes[p2]) {
                parents[p2] = p1;
            } else if (nodes[p2] > nodes[p1]) {
                parents[p1] = p2;
            } else {
                parents[p1] = p2;
                nodes[p2]++;
            }

            return true;
        }
    }
}
