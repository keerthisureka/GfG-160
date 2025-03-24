// Approach: (DP Recursion + Memoization)  
// TC: O(n^3) -> We iterate over k in range [i, j] for each (i, j) pair, leading to O(n^3) complexity.  
// SC: O(n * n) + O(n) ~ O(n^2) -> We use a 2D DP table of size n x n to store results, reducing redundant calculations.  
class Solution {
    public static int solve(int[] arr, int i, int j, int[][] dp) {
        // Base case: If only one matrix, no multiplication needed
        if(i == j)
            return 0;
        
        // Return already computed value
        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;
        // Try placing the partition at every possible index k
        for (int k = i; k < j; k++) {
            // Compute cost of multiplying two subproblems plus current multiplication
            int multiplications = (arr[i - 1] * arr[k] * arr[j]) + solve(arr, i, k, dp) + solve(arr, k + 1, j, dp);
            // Store minimum multiplication cost
            mini = Math.min(mini, multiplications);
        }
        return dp[i][j] = mini;
    }

    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        // Initialize DP table with -1 (indicating uncomputed states)
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Solve from index 1 to n-1 (since arr represents dimensions)
        return solve(arr, 1, n - 1, dp);
    }
}

/* 
    Dry Run

    Input: arr = {10, 20, 30, 40, 50}
    DP Table Initially: 
    -1  -1  -1  -1  -1  
    -1  -1  -1  -1  -1  
    -1  -1  -1  -1  -1  
    -1  -1  -1  -1  -1  
    -1  -1  -1  -1  -1  

    Step 1: Solve(1, 4)  
        - k = 1 → Cost = 10 * 20 * 50 + Solve(2, 4)  
        - k = 2 → Cost = 10 * 30 * 50 + Solve(1, 2) + Solve(3, 4)  
        - k = 3 → Cost = 10 * 40 * 50 + Solve(1, 3) + Solve(4, 4)  

    Step 2: Solve(2, 4)  
        - k = 2 → Cost = 20 * 30 * 50 + Solve(2, 2) + Solve(3, 4)  
        - k = 3 → Cost = 20 * 40 * 50 + Solve(2, 3) + Solve(4, 4)  

    Step 3: Solve(3, 4)  
        - k = 3 → Cost = 30 * 40 * 50  

    Final Computation: Minimum cost is stored in dp[1][4] = 38000
    Output: 38000
*/