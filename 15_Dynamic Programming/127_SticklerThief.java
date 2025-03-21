// Approach: (DP Recursion + Memoization)
// TC: O(n)
// SC: O(n)
class Solution {
    public static int solve(int[] arr, int idx, int[] dp) {
        if(idx >= arr.length)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int take = arr[idx] + solve(arr, idx + 2, dp);
        int not_take = solve(arr, idx + 1, dp);
        
        dp[idx] = Math.max(take, not_take);
        return dp[idx];
    }
    
    public int findMaxSum(int arr[]) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return solve(arr, 0, dp);
    }
}