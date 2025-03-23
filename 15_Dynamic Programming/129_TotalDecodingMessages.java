// Approach: (DP Recursion + Memoization)
// TC: O(n)
// SC: O(n)
class Solution {
    public static int ans;
    public static int solve(String digits, int idx, int val, int[] dp) {
        if(val < 1 || val > 26)
            return 0;
        if(idx >= digits.length())
            return 1;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        return dp[idx] = solve(digits, idx + 1, Integer.valueOf(digits.substring(idx, idx + 1)), dp) + ((idx < digits.length() - 1 && digits.charAt(idx) != '0') ? solve(digits, idx + 2, Integer.valueOf(digits.substring(idx, idx + 2)), dp) : 0);
    }
    
    public int countWays(String digits) {
        int[] dp = new int[digits.length()];
        Arrays.fill(dp, -1);
        return dp[0] = solve(digits, 1, Integer.valueOf(digits.substring(0, 1)), dp) + ((digits.length() >= 2 && digits.charAt(0) != '0') ? solve(digits, 2, Integer.valueOf(digits.substring(0, 2)), dp) : 0);
    }
}