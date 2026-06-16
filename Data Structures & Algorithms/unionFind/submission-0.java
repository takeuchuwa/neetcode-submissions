class UnionFind {

    private int[] parents;
    private int[] ranks;
    private int components;

    public UnionFind(int n) {
        parents = new int[n];
        ranks = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int x) {
        int parent = parents[x];
        while (parent != parents[parent]) {
            parents[parent] = parents[parents[parent]];
            parent = parents[parent];
        }

        return parent;
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        if (p1 == p2) return false;

        if (p1 > p2) {
            parents[p2] = p1;
        } else if (p2 > p1) {
            parents[p1] = p2;
        } else {
            parents[p1] = p2;
            ranks[p2]++;
        }
        components--;
        return true;
    }

    public int getNumComponents() {
        return components;
    }
}
