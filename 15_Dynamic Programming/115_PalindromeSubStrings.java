// Approach: (Using Recursion + Memoization)
// TC: O(n^2)
// SC: O(n^2)
class Solution {
    static int isPalindrome(int i, int j, String s, int[][] memo) {
        // One length string is always palindrome                             
        if(i == j)
            return 1;
        // Two length string is palindrome if both characters are same
        if(j == i + 1 && s.charAt(i) == s.charAt(j))
            return 1;
        // If current substring is already checked
        if(memo[i][j] != -1)
            return memo[i][j];

        // Check if the characters at i and j are equal and the substring inside is palindrome
        if(s.charAt(i) == s.charAt(j) && isPalindrome(i + 1, j - 1, s, memo) == 1)
            memo[i][j] = 1;
        else
            memo[i][j] = 0;

        return memo[i][j];
    }

    public int countPS(String s) {
        int n = s.length();
        // Memoization table
        int[][] memo = new int[n][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                // Check if the substring is palindrome
                if(isPalindrome(i, j, s, memo) == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}