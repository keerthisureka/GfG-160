// Approach: (Bellman-Ford Algorithm)
// TC: O(V * E)
// SC: O(V)
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;
        
        // According to Bellman-Ford Algorithm, iterate (V-1) times over the edges to find the shortest path
        for(int i = 0; i < V - 1; i++) {
            for(int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(dist[u] != 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        // Iterating the Vth time to check for negative cycles
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(dist[u] != 1e8 && dist[u] + w < dist[v]) {
                return new int[] {-1};
            }
        }
        return dist;
    }
}