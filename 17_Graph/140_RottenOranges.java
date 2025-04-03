// Approach: (Using BFS Traversal)
// TC: O(m * n)
// SC: O(m * n)
class Solution {
    public int orangesRotting(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Right, Left, Bottom, Top
        
        // Initially add all rotten oranges into the queue
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 2)
                    q.add(new int[] {i, j});
            }
        }
        
        // Now find the no. of levels reachable from every rotten orange using BFS
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] node = q.poll();
                for(int[] d : dir) {
                    int x = d[0] + node[0];
                    int y = d[1] + node[1];
                    
                    if(x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == 1) {
                        mat[x][y] = 2;
                        q.add(new int[] {x, y});
                    }
                }
            }
            time++; // Going to next level
        }
        
        // Check if all oranges are turned into rotten state, if not return -1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1)
                    return -1;
            }
        }
        
        return (time - 1 > 0) ? (time - 1) : 0; // Because it counts the start node as well
    }
}

/*
    Dry Run

    Input:
    mat[][] = [[0, 1, 2], 
            [0, 1, 2], 
            [2, 1, 1]]

    Step 1: Initialize Variables
    ------------------------------------------------------
    m = 3, n = 3
    dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}} // Right, Left, Bottom, Top
    Queue q = [] (to store initial rotten oranges)
    time = 0

    Step 2: Add all rotten oranges (2s) to the queue
    ------------------------------------------------------
    Rotten oranges at positions:
    (0,2) → q.add({0,2})
    (1,2) → q.add({1,2})
    (2,0) → q.add({2,0})

    Queue state:
    +-------+-------+-------+
    | (0,2) | (1,2) | (2,0) |
    +-------+-------+-------+

    Step 3: Start BFS Traversal
    ------------------------------------------------------
    Level 1:
    Queue size = 3

    Iteration 1: Process (0,2)
        - Adjacent (0,1) is fresh → Rot it → q.add({0,1})
        - Adjacent (1,2) already rotten
        - Adjacent (-1,2) out of bounds
        - Adjacent (0,3) out of bounds

    Queue state:
    +-------+-------+-------+-------+
    | (1,2) | (2,0) | (0,1) |
    +-------+-------+-------+-------+

    Iteration 2: Process (1,2)
        - Adjacent (1,1) is fresh → Rot it → q.add({1,1})
        - Adjacent (2,2) is fresh → Rot it → q.add({2,2})
        - Adjacent (0,2) already rotten
        - Adjacent (1,3) out of bounds

    Queue state:
    +-------+-------+-------+-------+-------+
    | (2,0) | (0,1) | (1,1) | (2,2) |
    +-------+-------+-------+-------+-------+

    Iteration 3: Process (2,0)
        - Adjacent (2,1) is fresh → Rot it → q.add({2,1})
        - Adjacent (3,0) out of bounds
        - Adjacent (1,0) is empty
        - Adjacent (2,-1) out of bounds

    Queue state:
    +-------+-------+-------+-------+-------+-------+
    | (0,1) | (1,1) | (2,2) | (2,1) |
    +-------+-------+-------+-------+-------+-------+

    Increment time = 1 (Level completed)

    Step 4: Check for fresh oranges
    ------------------------------------------------------
    No fresh oranges left in the matrix.

    Final Output:
    ------------------------------------------------------
    return time - 1 = 1 - 1 = 1
*/


// Approach: (Using DFS Traversal) -> MLE
// TC: O(m * n)
// SC: O(m * n) -> recursion stack
class Solution {
    public static void dfs(int[][] mat, int i, int j, int time) {
        mat[i][j] = time;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] d : dir) {
            int x = d[0] + i;
            int y = d[1] + j;
            if((x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) && (mat[x][y] == 1 || mat[x][y] > time + 1)) {
                dfs(mat, x, y, time + 1);
            }
        }
    }
    
    public int orangesRotting(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Make a DFS call from every rotten orange
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 2)
                    dfs(mat, i, j, 2);
            }
        }
        
        // Find the maximum time
        int time = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1)
                    return -1;
                
                time = Math.max(time, mat[i][j] - 2);
            }
        }
        return time;
    }
}