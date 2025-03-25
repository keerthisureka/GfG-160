// Approach: (DP Recursion + Memoization)  
// TC: O(n * n * 2 * n) ~ O(n^3) - We iterate over k in range [i, j] with multiple recursive calls, leading to O(n^3) complexity.
// SC: O(n * n * 2) ~ O(n^2) - We use a 3D DP table of size n x n x 2 to store results, reducing redundant calculations.
class Solution {
    public static int solve(String s, int i, int j, int isTrue, int[][][] dp) {
        // Base case: If the index goes out of bounds
        if(i > j) return 0;

        // Base case: If a single character is left
        if(i == j) {
            if(isTrue == 1)
                return (s.charAt(i) == 'T') ? 1 : 0;
            else
                return (s.charAt(i) == 'F') ? 1 : 0;
        }

        // Return the precomputed value
        if(dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];

        int ways = 0;

        // Try placing the partition at every operator (k)
        for(int k = i + 1; k <= j - 1; k += 2) {
            // Compute number of ways for left and right subproblems
            int lT = solve(s, i, k - 1, 1, dp); // Left True
            int lF = solve(s, i, k - 1, 0, dp); // Left False
            int rT = solve(s, k + 1, j, 1, dp); // Right True
            int rF = solve(s, k + 1, j, 0, dp); // Right False

            // Process current operator
            if(s.charAt(k) == '&') { // AND (&)
                if(isTrue == 1)
                    ways += (lT * rT);
                else
                    ways += (lT * rF) + (lF * rT) + (lF * rF);
            }
            else if(s.charAt(k) == '|') { // OR (|)
                if(isTrue == 1)
                    ways += (lT * rT) + (lT * rF) + (lF * rT);
                else
                    ways += (lF * rF);
            }
            else { // XOR (^)
                if(isTrue == 1)
                    ways += (lT * rF) + (lF * rT);
                else
                    ways += (lT * rT) + (lF * rF);
            }
        }
        // Memoize result
        return dp[i][j][isTrue] = ways;
    }

    static int countWays(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];

        // Initialize DP table with -1 (indicating uncomputed states)
        for(int[][] mat : dp)
            for(int[] row : mat)
                Arrays.fill(row, -1);

        // Solve from index 0 to n-1 with initial state as True -> isTrue = 1
        return solve(s, 0, n - 1, 1, dp);
    }
}

/* 
    Dry Run

    Input: s = "T|F&T"

    Step 1: Solve(0, 4, 1) → Evaluating "T|F&T"
        - k = 1 ('|') → Solve(0, 0, 1) and Solve(2, 4, 1)

    Step 2: Solve(0, 0, 1) → "T" → Returns 1

    Step 3: Solve(2, 4, 1) → Evaluating "F&T"
        - k = 3 ('&') → Solve(2, 2, 1) and Solve(4, 4, 1)

    Step 4: Solve(2, 2, 1) → "F" → Returns 0
    Step 5: Solve(4, 4, 1) → "T" → Returns 1

    Combining results:
        - (T|F) = (1 + 0) = 1
        - (F&T) = (0 * 1) = 0

    Final Computation: Ways = 1
    Output: 1
*/