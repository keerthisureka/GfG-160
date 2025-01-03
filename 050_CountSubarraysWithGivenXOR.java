// Approach: (Using HashMap and prefix XOR)
// TC: O(n)
// SC: O(n)
class Solution {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        // Stores prefix XOR frequencies seen until now -> prefix XOR: frequency
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        int res = 0;
        int prefXOR = 0;
        for(int i = 0; i < n; i++) {
            prefXOR ^= arr[i];
            
            // If current prefix XOR equals k, found a valid subarray from start
            if(prefXOR == k) {
                res++;
            }
            // prefXOR ^ x = k, then x = prefXOR ^ k
            // If we have seen such an x before, then prefixes can be removed to get subarrays with XOR = k
            res += mp.getOrDefault(prefXOR ^ k, 0);
            
            // Update frequency of current prefix XOR
            mp.put(prefXOR, mp.getOrDefault(prefXOR, 0) + 1);
        }
        return res;
    }
}