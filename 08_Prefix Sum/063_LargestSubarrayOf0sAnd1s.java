// Approach: (HashMap and Prefix Sum)
// TC: O(n)
// SC: O(n)
class Solution {
    public int maxLen(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        int res = 0;
        int prefSum = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) prefSum++;
            else prefSum--;
            
            if(prefSum == 0) {
                // Check if the prefSum equals 0 which indicates equal number of zeroes and ones.
                res = i + 1;
            }
            else if(mp.containsKey(prefSum)) {
                // Check if there exists a prefSum from index 0 which when subtracted from the current prefSum will give prefSum = 0.
                res = Math.max(res, i - mp.get(prefSum));
            }
            
            if(!mp.containsKey(prefSum)) {
                // Store only the first occurrence of the prefSum.
                mp.put(prefSum, i);
            }
        }
        return res;
    }
}