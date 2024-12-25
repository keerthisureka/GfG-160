// TC: O(m * n)
// SC: O(1)
//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Keeps track if we want to change the first row to all zeroes
        boolean setFirstRow = false;
        for(int i=0; i<n; i++) {
            if(mat[0][i] == 0) {
                setFirstRow = true;
                break;
            }
        }
        /* Iterate through the entire matrix except first row 
        to use the first row and column of the original matrix 
        to keep track of the rows and columns to be set to zeroes */
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }
        
        // Set to zeroes
        for(int i=1; i<m; i++) {
            /* Iterate from last because it may be possible that first column 
            has to be set to zero so it will be changed to zero in every row 
            before checking if that row has to set to zeroes */
            for(int j=n-1; j>=0; j--) {
                if(mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        
        // Set the first row to zero
        if(setFirstRow) {
            for(int i=0; i<n; i++) {
                mat[0][i] = 0;
            }
        }
    }
}