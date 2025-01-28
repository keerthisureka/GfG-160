// TC: O(n^2)
// SC: O(1)
// User function Template for Java
class Solution {
    static void rotateby90(int mat[][]) {
        int n = mat.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int j = 0; j < n; j++) {
            for(int i = 0, k = n - 1; i < k; i++, k--) {
                int temp = mat[i][j];
                mat[i][j] = mat[k][j];
                mat[k][j] = temp;
            }
        }
    }
}