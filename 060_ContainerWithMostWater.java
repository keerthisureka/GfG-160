// Approach: (Two Pointers)
// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        
        int res = 0;
        while(left < right) {
            // Finding the current area of water it can contain
            int curr = Math.min(arr[left], arr[right]) * (right - left);
            res = Math.max(res, curr); // Updating max result
            
            if(arr[left] <= arr[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }
}