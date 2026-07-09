class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
            adjList.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
        }

        PriorityQueue<QNode> max = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        max.offer(new QNode(start_node, 1));
        boolean[] visited = new boolean[n];
        while (!max.isEmpty()) {
            QNode qNode = max.poll();
            if (visited[qNode.node]) {
                continue;
            }
            visited[qNode.node] = true;
            if (qNode.node == end_node) {
                return qNode.prob;
            }
            for (Node neighbour : adjList.get(qNode.node)) {
                if (!visited[neighbour.to]) {
                    max.offer(new QNode(neighbour.to, qNode.prob * neighbour.prob));
                    
                }
            }
        }

        return 0.;
    }

    class Node {
        int to;
        double prob;

        Node(int to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }

    class QNode {
        int node;
        double prob;

        QNode(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}