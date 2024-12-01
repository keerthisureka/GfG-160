// TC: O(n)
// SC: O(26)
// User function Template for Java
class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        
        for(char c : s.toCharArray()) {
            if(mp.get(c) == 1) {
                return c;
            }
        }
        
        return '$';
    }
}