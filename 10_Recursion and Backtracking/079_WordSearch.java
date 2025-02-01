/*
Space Complexity -> is due to recursion to store the function call stack.
Time Complexity -> from every cell, we can move to three adjacent cells (avoiding the cell we just came from).
This traversal can go up to a maximum of L steps, where L is the length of the word. So, each path can extend up to L steps -> O(3^L).
Since this process is initiated from each cell on the board -> O(m * n). Therefore, the overall time complexity is O(m * n * 3^L).
*/
// Approach: (Backtrack)
// TC: O(m * n * 3^word.length())
// SC: O(word.length())
class Solution {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static boolean solve(char[][] mat, int r, int c, String word, int idx) {
        if(idx == word.length()) { // Found all characters present in word
            return true;
        }
        if(r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] == '$' || mat[r][c] != word.charAt(idx)) {
            return false;
        }
        
        mat[r][c] = '$';
        for(int[] dir : directions) {
            int new_r = r + dir[0];
            int new_c = c + dir[1];
            
            if(solve(mat, new_r, new_c, word, idx + 1)) // Check in all 4 directions
                return true;
        }
        mat[r][c] = word.charAt(idx); // Backtrack
        return false;
    }
    
    static public boolean isWordExist(char[][] mat, String word) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(solve(mat, i, j, word, 0)) // Check if we can find the word from current cell
                    return true;
            }
        }
        return false;
    }
}