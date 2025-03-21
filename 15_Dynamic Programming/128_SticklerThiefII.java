// Approach: (DP Recursion + Memoization)
// TC: O(n)
// SC: O(n)
class Solution {
    public static int solve(int[] arr, int idx, int[] dp, int n) {
        if(idx >= n)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int take = arr[idx] + solve(arr, idx + 2, dp, n);
        int not_take = solve(arr, idx + 1, dp, n);
        
        dp[idx] = Math.max(take, not_take);
        return dp[idx];
    }
    
    int maxValue(int arr[]) {
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return arr[0];
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int soln1 = solve(arr, 0, dp, n - 1); // From 0th index, don't consider last index
        
        Arrays.fill(dp, -1);
        int soln2 = solve(arr, 1, dp, n); // From 1st index, can consider last index
        
        return Math.max(soln1, soln2);
    }
}