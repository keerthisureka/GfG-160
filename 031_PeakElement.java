// TC: O(logn)
// SC: O(1)
class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            
            if(arr[mid] < arr[mid + 1]) l = mid + 1;
            else r = mid;
        }
        
        // Verify peak element
        if((l == n - 1 || arr[l] >= arr[l + 1]) && (l == 0 || arr[l] >= arr[l - 1]))
            return l;
        
        return -1;
    }
}