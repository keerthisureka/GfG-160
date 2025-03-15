// Approach: (Recursion + Memoization)
// TC: O(n * sum)
// SC: O(n * sum)
class Solution {
    public static int solve(int[] coins, int sum, int idx, int[][] t) {
        if(sum == 0)
            return 0;
        if(idx >= coins.length || sum < 0)
            return Integer.MAX_VALUE - 1;
            
        if(t[idx][sum] != -1)
            return t[idx][sum];
        
        // Take the coin at index 'idx' (unlimited times)
        int take = 1 + solve(coins, sum - coins[idx], idx, t);
        // Skip the coin at index 'idx'
        int not_take = solve(coins, sum, idx + 1, t);
        
        return t[idx][sum] = Math.min(take, not_take);
    }
    
    public int minCoins(int coins[], int sum) {
        if(sum == 0) return 0;
        
        int[][] t = new int[coins.length][sum + 1];
        for(int[] row : t)
            Arrays.fill(row, -1);
        
        int res = solve(coins, sum, 0, t);
        return (res == Integer.MAX_VALUE - 1) ? -1 : res;
    }
}