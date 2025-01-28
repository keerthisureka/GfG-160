// TC: O(max(n1, n2))
// SC: O(max(n1, n2))
// User function Template for Java
class Solution {
    public String addBinary(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        int i = n1 - 1;
        int j = n2 - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry > 0) {
            int currSum = carry;
            if(i >= 0) {
                currSum += s1.charAt(i) - '0';
            }
            if(j >= 0) {
                currSum += s2.charAt(j) - '0';
            }
            ans.append(currSum % 2); // Calculating ans bit and appending it to ans
            carry = currSum / 2; // Calculating carry
            i--;
            j--;
        }
        
        ans.reverse();
        // Deleting leading zeroes
        int k = 0;
        while(k < ans.length() && ans.charAt(k) == '0') {
            k++;
        }
        ans.delete(0, k);
        
        return ans.toString();
    }
}