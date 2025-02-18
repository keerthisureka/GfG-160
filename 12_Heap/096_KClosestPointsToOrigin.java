// Approach-1: (PriorityQueue -> Min-heap)
// TC: O((n + k) * logn)
// SC: O(n) -> PriorityQueue as min-heap
class Solution {
    class Pair {
        double dist;
        int idx;
        Pair(double dist, int idx) {
            this.dist = dist;
            this.idx = idx;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if(k > n) return new int[0][0];
        // Find the distance of the points from origin and store it in ascending order along with its index
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        for(int i = 0; i < n; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            pq.add(new Pair(Math.sqrt((x2 * x2) + (y2 * y2)), i)); // TC: O(logn)
        }
        
        // Now store the k nearest points in ans
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            int idx = pq.poll().idx; // TC: O(logn)
            ans[i][0] = points[idx][0];
            ans[i][1] = points[idx][1];
        }
        return ans;
    }
}


// Approach-2: (PriorityQueue -> Max-heap)
// TC: O((n + k) * logk) ~ O(n * logk)
// SC: O(k) -> PriorityQueue as max-heap
class Solution {
    public static int sqrtDist(int[] p) {
        return (p[0] * p[0]) + (p[1] * p[1]);
    }
    
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if(k > n) return new int[0][0];
        // Find the distance of the points from origin and store it in descending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> sqrtDist(b) - sqrtDist(a));
        for(int i = 0; i < n; i++) {
            if(pq.size() < k)
                pq.add(points[i]); // TC: O(logk)
            else {
                if(sqrtDist(points[i]) < sqrtDist(pq.peek())) {
                    pq.poll();
                    pq.add(points[i]); // TC: O(logk)
                }
            }
        }
        
        // Now store the k nearest points in ans
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] point = pq.poll(); // TC: O(logk)
            ans[i][0] = point[0];
            ans[i][1] = point[1];
        }
        return ans;
    }
}