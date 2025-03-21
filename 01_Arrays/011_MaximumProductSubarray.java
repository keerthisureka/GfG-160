// TC: O(n)
// SC: O(1)
class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProd = Integer.MIN_VALUE;
        
        int prefix = 1;
        int suffix = 1;
        
        for(int i=0; i<n; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            
            prefix *= arr[i];
            suffix *= arr[n-1-i];
            
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
        return maxProd;
    }
}