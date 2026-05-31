 class Solution {

    List<List<Integer>> adj;
    int[] state;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        adj = new ArrayList<>();
        state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]); // b -> a
        }

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i)) return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node) {

        if (state[node] == 1) return true;   // cycle found
        if (state[node] == 2) return false;  // already safe

        state[node] = 1; // mark visiting

        for (int nei : adj.get(node)) {
            if (hasCycle(nei)) return true;
        }

        state[node] = 2; // mark done
        return false;
    }
}