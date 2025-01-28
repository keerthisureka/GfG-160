// TC: O(n)
// SC: O(n)
class Solution {
    public boolean sentencePalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            else {
                continue;
            }
        }
        return (sb.toString()).equals(sb.reverse().toString());
    }
}