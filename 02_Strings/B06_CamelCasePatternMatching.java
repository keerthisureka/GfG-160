// TC: O(n * max(s.length()))
// SC: O(1)
class Solution {
    public List<String> camelCase(String[] arr, String pat) {
        int n = arr.length;
        List<String> ans = new ArrayList<>();
        
        for(String s : arr) {
            int i = 0;
            int j = 0;
            while(i < s.length() && j < pat.length()) {
                if(Character.isLowerCase(s.charAt(i))) {
                    i++;
                }
                else if(s.charAt(i) != pat.charAt(j)) {
                    break;
                }
                else {
                    i++;
                    j++;
                }
            }
            if(j == pat.length()) {
                ans.add(s);
            }
        }
        
        return ans;
    }
}