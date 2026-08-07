class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<List<NeighborNode>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> edge: edges) {
            adjList.get(edge.get(0)).add(new NeighborNode(edge.get(1), edge.get(2)));
        }
        Map<Integer, Integer> output = new HashMap<>();
        Queue<NeighborNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        minHeap.offer(new NeighborNode(src, 0));
        boolean[] visited = new boolean[n];
        while (!minHeap.isEmpty()) {
            NeighborNode node = minHeap.poll();
            if (!visited[node.edge]) {
                output.put(node.edge, node.weight);
            }
            visited[node.edge] = true;
            for (NeighborNode neighbor: adjList.get(node.edge)) {
                if (!visited[neighbor.edge]) {
                    minHeap.offer(new NeighborNode(neighbor.edge, node.weight + neighbor.weight));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            output.putIfAbsent(i, -1);
        }

        return output;
    }

    private static class NeighborNode {
        int edge;
        int weight;

        NeighborNode(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }  
}
