// Approach: (Use recursion with memoization to determine the number of ways to form the target sum by either including the current coin (with unlimited supply) or skipping it)
// TC: O(n * sum) -> as each (index, remaining sum) state is computed only once due to memoization.
// SC: O(n * sum) -> for the memoization table and recursion stack.
// Note: The memo table is initialized with dimensions [coins.length+1][sum+1] based on the problem constraints (up to 1000 coins and sum up to 1000).
class Solution {
    int[][] memo; // Memoization table

    private int solve(int[] coins, int sum, int index) {
        // Base case: If the remaining sum is 0, one valid combination is found.
        if(sum == 0) {
            return 1;
        }
        // Base case: If all coins have been considered, return 0 as no valid combination exists.
        if(index == coins.length) {
            return 0;
        }
        // Return the computed result if available.
        if(memo[index][sum] != -1) {
            return memo[index][sum];
        }
        // If the current coin's value is greater than the remaining sum, skip this coin.
        if(coins[index] > sum) {
            memo[index][sum] = solve(coins, sum, index + 1);
            return memo[index][sum];
        }
        // Option 1: Include the current coin (remain at the same index for unlimited supply).
        int take = solve(coins, sum - coins[index], index);
        // Option 2: Exclude the current coin and move to the next index.
        int skip = solve(coins, sum, index + 1);

        memo[index][sum] = take + skip;
        return memo[index][sum];
    }
    
    public int count(int coins[], int sum) {
        // Initialize memoization table with -1 to indicate uncomputed states.
        memo = new int[coins.length + 1][sum + 1];
        for(int i = 0; i <= coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solve(coins, sum, 0);
    }
}