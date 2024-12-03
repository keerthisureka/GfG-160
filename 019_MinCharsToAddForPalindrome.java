// Naive Approach: (TLE)
// TC: O(n^2)
// SC: O(1)
// User function Template for Java
class Solution {
    public static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public static int minChar(String s) {
        int i = s.length() - 1;
        while(i >= 0 && !isPalindrome(s, 0, i)) {
            i--;
        }
        return s.length() - 1 - i;
    }
}


// Using lps array of KMP Algorithm: (Accepted)
// TC: O(n)
// SC: O(n)
// User function Template for Java
class Solution {
    public static int[] computeLPS(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i < n) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = lps[len - 1];
                }
                else {
                    i++;
                }
            }
        }
        return lps;
    }
    
    public static int minChar(String s) {
        int n = s.length();
        
        // Finding the reverse of the given string and appending it to s
        String rev = new StringBuilder(s).reverse().toString();
        s = s + "$" + rev;
        
        // Compute LPS array
        int[] lps = computeLPS(s);
        
        return (n - lps[lps.length - 1]);
    }
}