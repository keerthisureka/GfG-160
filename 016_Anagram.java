// TC: O(nlogn)
// SC: O(n)
class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        if(Arrays.equals(c1, c2)) {
            return true;
        }
        return false;
    }
}