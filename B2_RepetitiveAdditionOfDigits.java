// TC: O(dig)
// SC: O(1)
class Solution {
    public int singleDigit(int n) {
        while(n > 9) {
            int sum = 0;
            while(n > 0) {
                int dig = n % 10;
                sum += dig;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }
}