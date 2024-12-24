// Approach-1:
// TC: O(m + logn)
// SC: O(1)
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int m = mat.length;
        int n = mat[0].length;
        
        if(x < mat[0][0] || x > mat[m-1][n-1])
            return false;
        
        // Finding the row which may contain x
        int row = 0;
        for(int i=0; i<m; i++) {
            if(x <= mat[i][n-1]) {
                if(x == mat[i][n-1])
                    return true;
                row = i;
                break;
            }
        }
        
        // Binary Search
        int l = 0;
        int h = n-1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(mat[row][mid] == x) {
                return true;
            }
            else if(x < mat[row][mid]) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}

// Approach-2:
// TC: O(log(m*n))
// SC: O(1)
class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int m = mat.length;
        int n = mat[0].length;
        int l = 0;
        int r = n * m - 1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            int val = mat[mid / n][mid % n];
            
            if(val == x) return true;
            if(val < x) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}