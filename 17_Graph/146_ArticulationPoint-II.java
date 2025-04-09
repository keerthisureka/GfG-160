// Approach: (Using DFS Traversal)
// TC: O(V + E)
// SC: O(V)
class Solution {
    public static ArrayList<ArrayList<Integer>> constructAdj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
    
    public static void findPoints(ArrayList<ArrayList<Integer>> adj, int u, int[] visited, int[] disc, int[] low, int[] time, int parent, int[] isAP) {
        visited[u] = 1;
        disc[u] = low[u] = ++time[0];
        int children = 0;
        for(int v : adj.get(u)) {
            if(visited[v] == 0) {
                children++;
                findPoints(adj, v, visited, disc, low, time, u, isAP);
                low[u] = Math.min(low[u], low[v]);
                if(parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = 1;
                }
            }
            else if(v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if(parent == -1 && children > 1) {
            isAP[u] = 1;
        }
    }
    
    public static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = constructAdj(V, edges);
        int[] disc = new int[V], low = new int[V],
        visited = new int[V], isAP = new int[V];
        int[] time = {0};
        for(int u = 0; u < V; u++) {
            if (visited[u] == 0) {
                findPoints(adj, u, visited, disc, low, time, -1, isAP);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int u = 0; u < V; u++) {
            if(isAP[u] == 1) {
                result.add(u);
            }
        }
        if(result.isEmpty()) result.add(-1);
        return result;
    }
}