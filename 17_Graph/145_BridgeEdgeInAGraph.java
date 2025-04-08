// Approach: (DFS Traversal)
// TC: O(V + E)
// SC: O(V)
class Solution {
    static void dfs(List<Integer>[] adj, int c, boolean[] visited) {
        visited[c] = true;
        for(int neighbor : adj[c]) {
            if(!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
    
    static List<Integer>[] constructAdj(int V, int[][] edges, int c, int d) {
        List<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if((a == c && b == d) || (a == d && b == c))
                continue;
            adj[a].add(b);
            adj[b].add(a);
        }
        return adj;
    }
    
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<Integer>[] adj = constructAdj(V, edges, c, d);
        boolean[] visited = new boolean[V];
        dfs(adj, c, visited);
        return !visited[d]; 
    }
}