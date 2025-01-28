// TC: O(n)
// SC: O(1)
class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        boolean neg = false;
        
        int i = 0;
        // Skipping leading whitespaces
        while(i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Checking if there is a sign
        if(i < n && s.charAt(i) == '-') { // Checking if it is negative number
            neg = true;
            i++;
        }
        else if(i < n && s.charAt(i) == '+') { // Else its positive number
            i++;
        }
        
        int num = 0;
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            // Handling overflow/underflow test case
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return (neg == true) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = (10 * num) + (s.charAt(i++) - '0');
        }
        return (neg == true) ? -num : num;
    }
}