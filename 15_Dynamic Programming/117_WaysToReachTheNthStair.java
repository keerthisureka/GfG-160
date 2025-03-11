// Approach: (Space Optimized DP)
// TC: O(n)
// SC: O(1)
class Solution {
    int countWays(int n) {
        // prev1 and prev2 to store the values of last and second last states
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}