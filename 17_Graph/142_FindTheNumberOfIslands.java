// Approach: (Recursion -> DFS)
// TC: O(m * n)
// SC: O(m * n) -> vis + recursion stack
class Solution {
    public static void solve(char[][] grid, int i, int j, boolean[][] vis) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] != 'L') {
            return;
        }
        vis[i][j] = true;
        // Horizontally & Vertically
        solve(grid, i + 1, j, vis);
        solve(grid, i - 1, j, vis);
        solve(grid, i, j + 1, vis);
        solve(grid, i, j - 1, vis);
        // Diagonals
        solve(grid, i + 1, j + 1, vis);
        solve(grid, i - 1, j + 1, vis);
        solve(grid, i + 1, j - 1, vis);
        solve(grid, i - 1, j - 1, vis);
    }
    
    public int countIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && grid[i][j] == 'L') {
                    solve(grid, i, j, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

/*
    Dry Run of DFS Island Counting Algorithm

    Input:
    grid[][] = [
        ['L', 'L', 'W', 'W', 'W'],
        ['W', 'L', 'W', 'W', 'L'],
        ['L', 'W', 'W', 'L', 'L'],
        ['W', 'W', 'W', 'W', 'W'],
        ['L', 'W', 'L', 'L', 'W']
    ]

    Grid with index for reference:
    (0,0) (0,1) (0,2) (0,3) (0,4)
    (1,0) (1,1) (1,2) (1,3) (1,4)
    (2,0) (2,1) (2,2) (2,3) (2,4)
    (3,0) (3,1) (3,2) (3,3) (3,4)
    (4,0) (4,1) (4,2) (4,3) (4,4)

    Initial Visited Matrix:
    All false

    Start iterating grid:

    Island 1: Start at (0,0)
    → Call solve(0,0), mark visited
    → (0,1) = 'L' → solve(0,1)
    → (1,1) = 'L' → solve(1,1)
    → (1,0) = 'W' → skip
    → (2,0) = 'L' → solve(2,0)
    → All neighbors now visited or 'W'
    → Island 1 Complete

    Visited so far: (0,0), (0,1), (1,1), (2,0)

    Island 2: Next unvisited 'L' is at (1,4)
    → Call solve(1,4), mark visited
    → (2,3) = 'L' → solve(2,3)
    → (2,4) = 'L' → solve(2,4)
    → All neighbors now visited or 'W'
    → Island 2 Complete

    Visited so far: (1,4), (2,3), (2,4)

    Island 3: Next unvisited 'L' is at (4,0)
    → Call solve(4,0), mark visited
    → All neighbors are 'W'
    → Island 3 Complete

    Island 4: Next unvisited 'L' is at (4,2)
    → Call solve(4,2), mark visited
    → (4,3) = 'L' → solve(4,3)
    → All neighbors are 'W'
    → Island 4 Complete

    Final Count = 4 islands

    Time Complexity: O(m * n)
    Space Complexity: O(m * n) → for visited[][] + recursion stack
*/