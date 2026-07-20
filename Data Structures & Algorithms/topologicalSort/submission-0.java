class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }

        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!dfs(i, adjList, ans, visited)) {
                return new ArrayList<>();
            }
        }
        Collections.reverse(ans);

        return ans;
    }

    public boolean dfs(int i, List<Set<Integer>> adjList, List<Integer> ans, int[] visited) {
        if (visited[i] != 0) {
            return visited[i] == 2;
        }

        visited[i] = 1;
        for (int neighbor: adjList.get(i)) {
            if (!dfs(neighbor, adjList, ans, visited)) {
                return false;
            }   
        }
        ans.add(i);
        visited[i] = 2;
        return true;
    }
}
