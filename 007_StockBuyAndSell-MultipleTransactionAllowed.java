// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int n = prices.length;
        int aheadBuy, aheadNotBuy, currBuy, currNotBuy;
        aheadBuy = aheadNotBuy = 0;

        for(int ind=n-1; ind>=0; ind--) {
            // buy
            currBuy = Math.max(-prices[ind] + aheadNotBuy, 0 + aheadBuy);
            // sell
            currNotBuy = Math.max(prices[ind] + aheadBuy, 0 + aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}