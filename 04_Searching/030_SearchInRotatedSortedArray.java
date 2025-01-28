// TC: O(logn)
// SC: O(1)
// User function Template for Java
class Solution {
    int search(int[] arr, int key) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == key)
                return mid;
            
            if(arr[l] <= arr[mid]) { // Left half is sorted
                if(key >= arr[l] && key < arr[mid]) r = mid - 1;
                else l = mid + 1;
            }
            else { // Otherwise, check for right half
                if(key > arr[mid] && key <= arr[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}