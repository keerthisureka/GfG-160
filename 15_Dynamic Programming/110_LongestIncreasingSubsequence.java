// Approach: (Recursion + Memoization -> Use recursion with memoization to cache results for each (i, prevIndex) state, avoiding redundant calculations)
// TC: O(n^2) -> due to caching of each state (i, prevIndex).
// SC: O(n^2) -> for the memoization table plus O(n) for the recursion stack.
class Solution {
    private static int solve(int arr[], int i, int prevIndex, int[][] dp) {
        int n = arr.length;
        if(i >= n) {
            return 0;
        }
        // Map prevIndex to dp index: use (prevIndex + 1) to handle prevIndex == -1.
        if(dp[i][prevIndex + 1] != -1) {
            return dp[i][prevIndex + 1];
        }
        int take = 0;
        if(prevIndex == -1 || arr[i] > arr[prevIndex]) {
            take = 1 + solve(arr, i + 1, i, dp);
        }
        int skip = solve(arr, i + 1, prevIndex, dp);
        dp[i][prevIndex + 1] = Math.max(take, skip);
        return dp[i][prevIndex + 1];
    }
    
    static int lis(int arr[]) {
        int n = arr.length;
        // Create a memoization table with dimensions (n+1) x (n+1), mapping prevIndex -1 to index 0.
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(arr, 0, -1, dp);
    }
}