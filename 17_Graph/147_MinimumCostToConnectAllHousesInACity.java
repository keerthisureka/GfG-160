// Approach: (Using Prim’s Algorithm)
// TC: O(n^2*log(n))
// SC: O(n^2)
class Solution {
    public static int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    
    public int minCost(int[][] houses) {
        int n = houses.length;
        // Min-heap to store {cost, houseIndex}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Marks whether a house is already connected
        boolean[] visited = new boolean[n];
        
        // Start with the first house (index 0)
        minHeap.offer(new int[]{0, 0});
        int totalCost = 0;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int u = curr[1];
            // Skip if already connected
            if(visited[u]) continue;
            // Mark as connected and add the cost
            visited[u] = true;
            totalCost += cost;
            // Add distances to all unvisited houses
            for(int v = 0; v < n; v++) {
                if(!visited[v]) {
                    int dist = manhattanDistance(houses[u], houses[v]);
                    minHeap.offer(new int[]{dist, v});
                }
            }
        }
        return totalCost;
    }
}