// TC: O(m + n) -> length of the pat + txt
// SC: O(m) -> length of the pat
// User function Template for Java
class Solution {
    static void computeLPS(String pat, int[] lps) {
        int len = 0; // initially the length of longest equal prefix and suffix is 0
        lps[0] = 0;
        
        int m = pat.length();
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
    }
    
    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int n = txt.length();
        int m = pat.length();
        
        // Store the result
        ArrayList<Integer> res = new ArrayList<>();
        
        // creating the lps array for KMP algo
        // lps -> longest prefix which is equal to the suffix from 0..i in pat
        int[] lps = new int[m];
        computeLPS(pat, lps);
        
        // Apply KMP
        int i = 0; // pointer for txt
        int j = 0; // pointer for pat
        while(i < n) {
            if(j < m && txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            
            if(j == m) {
                res.add(i-j);
                j = lps[j - 1];
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
        return res;
    }
}