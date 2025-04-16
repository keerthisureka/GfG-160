// Approach: (Floyd Warshall Algorithm)
// TC: O(V^3)
// SC: O(1)
class Solution {
    static final int INF = 100000000;
    public void floydWarshall(int[][] dist) {
        int V = dist.length;
        // Add all vertices one by one to the set of intermediate vertices
        for(int k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for(int i = 0; i < V; i++) {
                // Pick all vertices as destination for the above picked source
                for(int j = 0; j < V; j++) {
                    // shortest path from i to j
                    if(dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}