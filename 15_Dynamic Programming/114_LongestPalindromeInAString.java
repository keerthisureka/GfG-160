// Approach: (Dynamic Programming using a 2D dp array to record if s[i...j] is a palindrome)
// TC: O(n^2) -> we examine all substrings.
// SC: O(n^2) -> dp array storage.
class Solution {
    static String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // All substrings of length 1 are palindromes.
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2.
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if(maxLen < 2) { // update only if first occurrence
                    start  = i;
                    maxLen = 2;
                }
            }
        }

        // Check for substrings of length greater than 2.
        for(int k = 3; k <= n; k++) {
            for(int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if(k > maxLen) { // update only if a longer palindrome is found
                        start  = i;
                        maxLen = k;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}