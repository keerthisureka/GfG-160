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
        return take || not_take;
    }
    
    static boolean equalPartition(int arr[]) {
        int n = arr.length;
        // Calculate total sum of the array
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // If the number is not divisible by 2, it cannot be partitioned into 2 subsets of equal sum
        if(sum % 2 != 0)
            return false;
        // DP for memoization
        int[][] dp = new int[n][sum/2 + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(arr, sum / 2, 0, dp);
    }
}