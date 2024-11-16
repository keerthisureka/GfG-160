// Optimal approach
// TC: O(n)
// SC: O(1)
class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int j = -1; // Store the first index containing zero
        
        for(int i=0; i<n; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) // It implies no zeroes are found
            return;
        
        for(int i=j+1; i<n; i++) {
            if(arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }
}
