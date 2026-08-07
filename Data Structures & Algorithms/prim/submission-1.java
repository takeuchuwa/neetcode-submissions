class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge: edges) {
            adjList.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
            adjList.get(edge.get(1)).add(new int[]{edge.get(0), edge.get(2)});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[1] - n2[1]));
        for (int[] edge : adjList.get(0)) {
            minHeap.offer(edge);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int visitedSize = 1;
        int res = 0;
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            if (visited[node[0]]) {
                continue;
            }
            visited[node[0]] = true;
            visitedSize++;
            res += node[1];
            for (int[] edge: adjList.get(node[0])) {
                if (!visited[edge[0]]) {
                    minHeap.offer(edge);
                }
            }
        }

        return visitedSize == n ? res : -1;
    }
}    
