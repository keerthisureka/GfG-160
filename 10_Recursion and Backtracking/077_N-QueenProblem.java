/*
    Time complexity for Approach-1 : O(N!)
    Unlike the brute force approach, we will only place queens on squares that aren't under attack.
    For the first queen, we have N options. For the next queen, we won't attempt to place it in the
    same column as the first queen, and there must be at least one square attacked diagonally by the
    first queen as well. Thus, the maximum number of squares we can consider for the second queen is
    (N−2). For the third queen, we won't attempt to place it in 2 columns already occupied by the first
    2 queens, and there must be at least two squares attacked diagonally from the first 2 queens.
    Thus, the maximum number of squares we can consider for the third queen is (N-4).
    This pattern continues, resulting in an approximate time complexity of O(N!)
 */
// Approach-1: (Simple DFS)
// TC: O(N!) -> Worst Case
// SC: O(N) -> Recursion Stack
class Solution {
    public static ArrayList<ArrayList<Integer>> ans;
    
    public static boolean isValid(char[][] board, int row, int col) {
        // Check upper rows in the same column
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q')
                return false;
        }
        // Check left upper diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }
        // Check right upper diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    
    public static void solve(char[][] board, int row) {
        // Base Case
        if(row >= board.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < board.length; j++) {
                for(int i = 0; i < board[0].length; i++) {
                    if(board[i][j] == 'Q') {
                        temp.add(i + 1);
                        break;
                    }
                }
            }
            ans.add(temp);
            return;
        }
        
        // Check for every column if it's possible
        for(int i = 0; i < board.length; i++) {
            if(isValid(board, row, i)) {
                board[row][i] = 'Q';
                solve(board, row + 1);
                board[row][i] = '.';
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ans = new ArrayList<>();
        if(n == 0)
            return ans;
        
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        solve(board, 0);
        return ans;
    }
}


// Approach-2: (Simple DFS -> Little Optimized by keeping track of the queen positions)
// TC: O(N!) -> Worst Case
// SC: O(N) -> Recursion Stack
class Solution {
    public static ArrayList<ArrayList<Integer>> ans;
    
    public static boolean isValid(char[][] board, int row, int col) {
        // Check upper rows in the same column
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q')
                return false;
        }
        // Check left upper diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }
        // Check right upper diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    
    public static void solve(char[][] board, int row, ArrayList<Integer> queenPos) {
        // Base Case
        if(row >= board.length) {
            ans.add(new ArrayList<>(queenPos));
            return;
        }
        
        // Check for every column if it's possible
        for(int i = 0; i < board.length; i++) {
            if(isValid(board, row, i)) {
                board[row][i] = 'Q';
                // Storing column no. by rows, because the answer can be returned in any order and we will get the same indices if we store queen positions by columns
                queenPos.add(i + 1);
                
                solve(board, row + 1, queenPos);
                
                board[row][i] = '.';
                queenPos.remove(queenPos.size() - 1);
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ans = new ArrayList<>();
        if(n == 0)
            return ans;
        
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        solve(board, 0, new ArrayList<>());
        return ans;
    }
}


// Approach-3: (Optimized while checking valid queen positions)
// TC: O(N!) -> Worst Case
// SC: O(N) -> Recursion Stack
class Solution {
    public static ArrayList<ArrayList<Integer>> ans;
    public static HashSet<Integer> upperCols;
    public static HashSet<Integer> leftUpperDiagonal;
    public static HashSet<Integer> rightUpperDiagonal;
    
    public static void solve(char[][] board, int row, ArrayList<Integer> queenPos) {
        // Base Case
        if(row >= board.length) {
            ans.add(new ArrayList<>(queenPos));
            return;
        }
        
        // Check for every column if it's possible
        for(int i = 0; i < board.length; i++) {
            // Optimized to check if the current cell is a valid queen position
            if(upperCols.contains(i) || leftUpperDiagonal.contains(row - i) || rightUpperDiagonal.contains(row + i))
                continue;
            
            board[row][i] = 'Q';
            // Storing column no. by rows, because the answer can be returned in any order and we will get the same indices if we store queen positions by columns
            queenPos.add(i + 1);
            
            upperCols.add(i);
            leftUpperDiagonal.add(row - i);
            rightUpperDiagonal.add(row + i);
            
            solve(board, row + 1, queenPos);
            
            board[row][i] = '.';
            queenPos.remove(queenPos.size() - 1);
            
            upperCols.remove(i);
            leftUpperDiagonal.remove(row - i);
            rightUpperDiagonal.remove(row + i);
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ans = new ArrayList<>();
        if(n == 0)
            return ans;
        
        upperCols = new HashSet<>();
        leftUpperDiagonal = new HashSet<>();
        rightUpperDiagonal = new HashSet<>();
        
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        solve(board, 0, new ArrayList<>());
        return ans;
    }
}