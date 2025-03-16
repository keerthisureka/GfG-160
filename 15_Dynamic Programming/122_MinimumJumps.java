// Approach: (DP Recursion + Memoization)
// TC: O(n^2)
// SC: O(n)
class Solution {
    public static int solve(int[] arr, int idx, int[] dp) {
        if(idx >= arr.length - 1)
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
            
        int minJumps = Integer.MAX_VALUE;
        for(int i = 1; i <= arr[idx]; i++) {
            int res = solve(arr, idx + i, dp);
            if(res != Integer.MAX_VALUE)
                minJumps = Math.min(minJumps, 1 + res);
        }
        return dp[idx] = minJumps;
    }
    
    static int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        int res = solve(arr, 0, dp);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}