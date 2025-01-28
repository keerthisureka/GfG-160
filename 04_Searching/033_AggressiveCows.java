// Approach: (Maximize the minimum - Binary Search)
// TC: O(n * log(max - min))
// SC: O(1)
// User function Template for Java
class Solution {
    public static boolean isPossible(int[] stalls, int mid, int k) {
        int n = stalls.length;
        int cnt = 1; // First cow is placed at stalls[0]
        int lastPos = stalls[0]; // First cow is placed at index 0
        for(int i=1; i<n; i++) {
            if(stalls[i] - lastPos >= mid) {
                cnt++;
                lastPos = stalls[i];
                
                if(cnt >= k)
                    return true;
            }
        }
        return false;
    }
    
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        
        int res = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(isPossible(stalls, mid, k)) {
                res = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return res;
    }
}