// Approach: (Two Pointers -> Sliding Window)
// TC: O(n)
// SC: O(26) ~ O(1)
// User function Template for Java
class Solution {
    public int longestUniqueSubstr(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int maxLen = 0;
        
        int i = 0;
        int j = 0;
        while(j < n) {
            while(i < j && freq[s.charAt(j) - 'a'] > 0) {
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            freq[s.charAt(j) - 'a']++;
            j++;
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}