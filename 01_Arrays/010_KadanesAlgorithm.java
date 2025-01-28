// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(sum < 0) {
                sum = 0;
            }
            sum += arr[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}