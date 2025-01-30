// Approach: (Backtracking)
// TC: O(9^(9*9)) -> If all cells are empty, but in reality its not the case
// SC: O(9*9) -> Recursion Stack in worst case, though in reality its much less than (9*9)
class Solution {
    // Check if a number can be placed in the given cell
    public static boolean isValid(int num, int row, int col, int[][] mat) {
        for(int i = 0; i < 9; i++) {
            // Check if number exists in the same column
            if(mat[i][col] == num)
                return false;
            // Check if number exists in the same row
            if(mat[row][i] == num)
                return false;
            // Check if number exists in the 3x3 sub-grid
            // Formula: 3*(row/3) + i/3 gives the row index of current sub-grid cell
            // Formula: 3*(col/3) + i%3 gives the column index of current sub-grid cell
            if(mat[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == num)
                return false;
        }
        return true;
    }

    // Recursive function to solve the Sudoku using backtracking
    public static boolean solve(int[][] mat) {
        // Iterate through each cell in the grid
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                // Find an empty cell (marked as 0)
                if(mat[i][j] == 0) {
                    // Try placing numbers 1-9 in this cell
                    for(int num = 1; num <= 9; num++) {
                        // If the number is valid for this cell
                        if(isValid(num, i, j, mat)) {
                            mat[i][j] = num; // Place the number
                            if(solve(mat)) // Recursively try to solve the rest of the puzzle
                                return true;
                            mat[i][j] = 0; // If placing the number didn't lead to a solution, backtrack by removing it (set cell back to 0)
                        }
                    }
                    return false; // If no number can be placed, return false to trigger backtracking
                }
            }
        }
        return true; // If we've filled all cells, we've solved the puzzle
    }
    
    // Main function that initiates the solving process
    static void solveSudoku(int[][] mat) {
        solve(mat);
    }
}