// Approach: (Using DFS Traversal)
// TC: O(V + E)
// SC: O(V)
class Solution {
    private static boolean isCyclicUtil(List<Integer>[] adj, int u, boolean[] visited, boolean[] recStack) {
        // If the current node is already in the recursion stack, a cycle is detected
        if(recStack[u])
            return true;
        // If already visited and not in recStack, it's not part of a cycle
        if(visited[u])
            return false;

        // Mark the current node as visited and add it to the recursion stack
        visited[u] = true;
        recStack[u] = true;
        // Recur for all adjacent vertices
        for(int v : adj[u]) {
            if(isCyclicUtil(adj, v, visited, recStack))
                return true;
        }
        // Backtrack: remove the vertex from recursion stack
        recStack[u] = false;
        return false;
    }

    public boolean isCyclic(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        // Add edges to the adjacency list (directed)
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        // Perform DFS from each unvisited vertex
        for(int i = 0; i < V; i++) {
            if(!visited[i] && isCyclicUtil(adj, i, visited, recStack))
                return true; // Cycle found
        }
        return false; // No cycle found
    }
}