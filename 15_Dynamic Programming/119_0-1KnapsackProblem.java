// Approach: (Use dynamic programming with a 2D DP table to store maximum value for each sub-problem)
// TC: O(n * W) -> as we iterate over each item and every capacity from 0 to W.
// SC: O(n * W) -> due to the use of a 2D DP table of size n x (W+1).
class Solution {
    public static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        // Create a 2D DP table with dimensions n x (W+1) and initialize with 0.
        int dp[][] = new int[n][W + 1];

        // Base condition: For the first item, if its weight is less than or equal to the capacity, then for all capacities >= wt[0], the maximum value is val[0].
        for(int cap = wt[0]; cap <= W; cap++) {
            dp[0][cap] = val[0];
        }

        // Build the DP table using a bottom-up approach.
        for(int ind = 1; ind < n; ind++) {
            for(int cap = 0; cap <= W; cap++) {
                // Option 1: Do not include the current item.
                int notTaken = dp[ind - 1][cap];
                // Option 2: Include the current item (if it fits in the knapsack).
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];
                }
                // The cell dp[ind][cap] is the maximum of including or excluding the item.
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        // The final answer is at dp[n-1][W].
        return dp[n - 1][W];
    }
}