// Approach: (Sliding Window + HashMap)
// TC: O(n) -> for loop (k) times + for loop (n-k) times
// SC: O(k) -> HashMap
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        // Initialize the first window of size k
        for(int i = 0; i < k; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        ans.add(mp.size()); // Store the count of unique elements in the first window
        
        // Process the remaining windows
        for(int i = k; i < n; i++) {
            // Shift the window
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            mp.put(arr[i - k], mp.get(arr[i - k]) - 1);
            
            if(mp.get(arr[i - k]) == 0) {
                mp.remove(arr[i - k]);
            }
            ans.add(mp.size()); // Store the count of unique elements in the current window
        }
        return ans;
    }
}