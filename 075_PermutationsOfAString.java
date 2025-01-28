// Approach-1: (Backtracking)
// TC: O(n!)
// SC: O(n) -> recursion stack (O(n!) space required to store ans is not considered)
class Solution {
    public static void solve(StringBuilder sb, int idx, HashSet<String> ans) {
        if(idx == sb.length()) {
            ans.add(sb.toString());
            return;
        }
        
        for(int i = idx; i < sb.length(); i++) {
            // Swap
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(idx));
            sb.setCharAt(idx, ch);
            
            solve(sb, idx + 1, ans);
            
            // Undo swap
            ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(idx));
            sb.setCharAt(idx, ch);
        }
    }
    
    public ArrayList<String> findPermutation(String s) {
        int n = s.length();
        HashSet<String> ans = new HashSet<>(); // To avoid duplicates, we use HashSet
        StringBuilder sb = new StringBuilder(s);
        
        solve(sb, 0, ans);
        
        return new ArrayList<>(ans);
    }
}


// Approach-2: (Backtracking with little optimization for duplicate characters using HashSet uniqueChars)
// TC: O(n!) -> Less than O(n!) for a string with duplicates
// SC: O(n) -> recursion stack (O(n!) space required to store ans is not considered)
class Solution {
    public static void solve(StringBuilder sb, int idx, HashSet<String> ans) {
        if(idx == sb.length()) {
            ans.add(sb.toString());
            return;
        }
        
        HashSet<Character> uniqueChars = new HashSet<>(); // Optimizing for duplicate characters
        for(int i = idx; i < sb.length(); i++) {
            if(uniqueChars.contains(sb.charAt(i))) {
                continue; // Do not call the function again for duplicates
            }
            uniqueChars.add(sb.charAt(i));
            
            // Swap
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(idx));
            sb.setCharAt(idx, ch);
            
            solve(sb, idx + 1, ans);
            
            // Undo swap
            ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(idx));
            sb.setCharAt(idx, ch);
        }
    }
    
    public ArrayList<String> findPermutation(String s) {
        int n = s.length();
        HashSet<String> ans = new HashSet<>(); // To avoid duplicates, we use HashSet
        StringBuilder sb = new StringBuilder(s);
        
        solve(sb, 0, ans);
        
        return new ArrayList<>(ans);
    }
}