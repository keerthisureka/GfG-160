// TC: O(m * logn)
// SC: O(1)
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0; i<m; i++) {
            if(x == mat[i][n - 1]) {
                return true;
            }
            else if(x > mat[i][n - 1]) {
                continue;
            }
            int l = 0;
            int h = n - 1;
            while(l <= h) {
                int mid = l + (h - l) / 2;
                if(mat[i][mid] == x) {
                    return true;
                }
                else if(mat[i][mid] > x) {
                    h = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}