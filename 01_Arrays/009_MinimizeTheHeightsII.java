// TC: O(n * logn)
// SC: O(1)
// User function Template for Java
class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        
        int minH = arr[0];
        int maxH = arr[n-1];
        int res = maxH - minH;
        
        for(int i=0; i<n-1; i++) {
            minH = Math.min(arr[0]+k, arr[i+1]-k);
            maxH = Math.max(arr[n-1]-k, arr[i]+k);
            if(minH < 0) continue;
            res = Math.min(res, maxH - minH);
        }
        return res;
    }
}