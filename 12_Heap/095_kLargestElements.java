// Approach: (PriorityQueue -> Max-heap)
// TC: O((n + k)*logn)
// SC: O(n + k) ~ O(n) -> PriorityQueue + ans array
class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        int n = arr.length;
        if(k > n) return new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        // Adding the k largest elements in ans
        for(int i = 0; i < k; i++) {
            ans.add(pq.poll());
        }
        return ans;
    }
}