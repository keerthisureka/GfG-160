// Approach: (Use the LCS (Longest Common Subsequence) between the string and its reverse to find the longest palindromic subsequence)
// TC: O(n^2) -> We fill a DP table of size n*n, where n is the length of the string.
// SC: O(n^2) -> A 2D DP table of size n*n is used.
class Solution {
    public int longestPalinSubseq(String s) {
        int n = s.length();
        String s1 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];

        // Fill the DP table using the LCS approach
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}