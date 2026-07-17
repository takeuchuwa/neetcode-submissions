class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visit = new int[numCourses]; // 0 not visited, 1 in path, 2 visited
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, visit)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, List<List<Integer>> adjList, int[] visit) {
        if (visit[i] != 0) {
            return visit[i] == 2;
        }

        visit[i] = 1;
        for (Integer next : adjList.get(i)) {
            if (!dfs(next, adjList, visit)) {
                return false;
            }
        }
        visit[i] = 2;

        return true;
    }
        
}
