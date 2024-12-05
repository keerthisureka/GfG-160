// TC: O(m)
// SC: O(m)
// User function Template for Java
class Solution {
    public static int[] computeLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        lps[0] = 0;
        
        int i = 1;
        int len = 0;
        while(i < m) {
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
    
    int longestPrefixSuffix(String s) {
        int m = s.length();
        int[] lps = computeLPS(s);
        
        return lps[m - 1];
    }
}