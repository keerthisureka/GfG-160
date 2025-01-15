// Approach: (HashMap and Prefix Sum)
// TC: O(n)
// SC: O(n)
// User function Template for Java
class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        int prefSum = 0;
        
        for(int i = 0; i < n; i++) {
            prefSum += arr[i];
            
            if(prefSum == k) {
                // Check if the entire prefix sum equals the target sum k.
                ans = i + 1;
            }
            else if(mp.containsKey(prefSum - k)) {
                // If there exists a subarray from index 0 which when subtracted from the prefSum will give k, then eliminate that subarray to compare the longest subarray length.
                ans = Math.max(ans, i - mp.get(prefSum - k));
            }
            
            // Store only the first occurrence of the prefix sum. Inorder to obtain the longest subarray we need to subtract the smallest subarray length possible.
            if(!mp.containsKey(prefSum)) {
                mp.put(prefSum, i);
            }
        }
        return ans;
    }
}