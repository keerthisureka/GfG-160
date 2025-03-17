// Approach: (DP Recursion + Memoization)
// TC: O(n * sum)
// SC: O(n * sum)
class Solution {
    public static boolean solve(int[] arr, int sum, int idx, int[][] dp) {
        if(sum == 0)
            return true;
        if(idx >= arr.length || sum < 0)
            return false;
        
        if(dp[idx][sum] != -1)
            return dp[idx][sum] == 1;
        
        boolean take = solve(arr, sum - arr[idx], idx + 1, dp);
        boolean not_take = solve(arr, sum, idx + 1, dp);
        
        dp[idx][sum] = (take || not_take) ? 1 : 0;
        return dp[idx][sum] == 1;
    }
    
    static Boolean isSubsetSum(int arr[], int sum) {
        int[][] dp = new int[arr.length][sum + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(arr, sum, 0, dp);
    }
}