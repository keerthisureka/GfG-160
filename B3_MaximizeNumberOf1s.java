// Sliding Window
// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    // k is the maximum number of zeros allowed to flip
    public int maxOnes(int arr[], int k) {
        int n = arr.length;
        
        int res = 0; // Max consecutive 1's window size obtained till now
        int cnt = 0; // Keeps track of the number of zeroes in the current window
        int start = 0; // start of the window
        int end = 0; // end of the window
        
        while(end < n) {
            if(arr[end] == 0) {
                cnt++;
            }
            
            while(cnt > k) {
                if(arr[start] == 0) {
                    cnt--;
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}