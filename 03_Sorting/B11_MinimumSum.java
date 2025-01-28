// TC: O(nlogn)
// SC: O(1)
// User function Template for Java
class Solution {
    public static String addTwoStrings(StringBuilder s1, StringBuilder s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        // Initial carry is zero
        int carry = 0;

        // We will calculate and store the resultant sum in reverse order in res
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if(i >= 0)
                sum += (s1.charAt(i) - '0');

            if(j >= 0)
                sum += (s2.charAt(j) - '0');

            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        // Remove leading zeroes which are currently at the back due to reversed string res
        while(res.length() > 0 && res.charAt(res.length() - 1) == '0')
            res.deleteCharAt(res.length() - 1);

        // Reverse our final string 
        res.reverse();
        return res.toString();
    }
    
    String minSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(i % 2 == 0)
                num1.append(arr[i]);
            else
                num2.append(arr[i]);
        }
        return addTwoStrings(num1, num2);
    }
}