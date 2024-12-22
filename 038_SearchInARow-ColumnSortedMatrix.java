// TC: O(n + m)
// SC: O(1)
class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length;
        int m = mat[0].length;
        
        int row = 0;
        int col = m - 1;
        while(row < n && col >= 0) {
            if(mat[row][col] == x) return true;
            
            if(mat[row][col] > x) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}