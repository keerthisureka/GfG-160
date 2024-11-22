// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxPro = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        
        return maxPro;
    }
}