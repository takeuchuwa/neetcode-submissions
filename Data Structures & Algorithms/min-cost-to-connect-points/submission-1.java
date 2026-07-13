class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<Node>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                adjList.get(i).add(new Node(j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
                adjList.get(j).add(new Node(i, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        for (Node neighbour : adjList.get(0)) {
            minHeap.offer(neighbour);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int res = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            if (visited[node.to]) {
                continue;
            }

            res += node.weight;
            visited[node.to] = true;
            for (Node neighbour : adjList.get(node.to)) {
                if (!visited[neighbour.to]) {
                    minHeap.offer(neighbour);
                }
            }
        }

        return res;

    }

    static class Node {
        int weight;
        int to;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
