// Approach: (Recursion + Memoization)
// TC: O(m * n) -> due to memoization, otherwise it would be 2^(m + n)
// SC: O(m * n)
class Solution {
    public static int m, n;
    public static int[][] t;
    public static int solve(String s1, String s2, int i, int j) {
        if(i >= m || j >= n)
            return 0;
        if(t[i][j] != -1)
            return t[i][j];
        
        if(s1.charAt(i) == s2.charAt(j))
            return t[i][j] = 1 + solve(s1, s2, i + 1, j + 1);
        else
            return t[i][j] = Math.max(solve(s1, s2, i + 1, j), solve(s1, s2, i, j + 1));
    }
    
    public static int lcs(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        t = new int[m + 1][n + 1];
        for(int[] row : t) {
            Arrays.fill(row, -1);
        }
        
        return solve(s1, s2, 0, 0);
    }
}