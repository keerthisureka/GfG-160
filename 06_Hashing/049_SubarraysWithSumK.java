// TC: O(n)
// SC: O(n)
// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        int n = arr.length;
        
        // Stores prefix sum frequencies -> sum: frequency of that sum
        HashMap<Integer, Integer> mp = new HashMap<>();
        int cnt = 0; // Counter for valid subarrays
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            // If sum equals k, found a valid subarray from start
            if(sum == k) {
                cnt++;
            }
            
            // Means that the required sum is seen in the subarray and can be eliminated to form the required subarray
            int req = sum - k;
            if(mp.containsKey(req)) {
                cnt += mp.get(req); // Add its frequency
            }
            
            // Update frequency of current prefix sum
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}