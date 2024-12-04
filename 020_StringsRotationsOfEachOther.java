// Naive Approach: (TLE)
// TC: O(2 * s1.length())
// SC: O(s1.length())
class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        s1 = s1 + s1;
        return s1.contains(s2);
    }
}


// Using KMP: (Accepted)
// TC: O(m + n)
// SC: O(m) -> lps array
class Solution {
    public static int[] computeLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        
        lps[0] = 0;
        int len = 0;
        int i = 1;
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
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        String pat = s2;
        String txt = s1 + s1;
        int m = pat.length();
        int n = txt.length();
        
        // Compute LPS array
        int[] lps = computeLPS(pat);
        
        // Apply KMP Algorithm
        int i = 0;
        int j = 0;
        while(i < n) {
            if(j < m && txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if(j == m) {
                return true;
            }
            else if(i < n && (j == 0 || txt.charAt(i) != pat.charAt(j))) {
                if(j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }
        return false;
    }
}