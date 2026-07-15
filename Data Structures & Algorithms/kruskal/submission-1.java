class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));

        for (List<Integer> edge : edges) {
            minHeap.offer(new Node(edge.get(0), edge.get(1), edge.get(2)));
        }

        UnionFind union = new UnionFind(n);
        int res = 0;
        int count = 0;
        while (count < n - 1) {
            Node node = minHeap.poll();
            if (node == null) {
                return -1;
            }
            if (union.union(node.from, node.to)) {
                res += node.weight;
                count++;
            }
        }

        return res;
    }

    static class Node {
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class UnionFind {
        int[] parent;
        int[] size;
        int components;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            int root = x;
            while (root != parent[root]) {
                parent[root] = parent[parent[root]];
                root = parent[root];
            }

            return root;
        }

        boolean union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);

            if (p1 == p2) return false;

            if (size[p1] < size[p2]) {
                parent[p1] = p2;
                size[p2] += size[p1];
            } else {
                parent[p2] = p1;
                size[p1] += size[p2];
            }

            return true;
        }
    }
}
