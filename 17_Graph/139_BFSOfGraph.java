// Approach: (Queue)
// TC: O(V + E)
// SC: O(V)
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        boolean[] vis = new boolean[adj.size()];
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);
            ArrayList<Integer> nodes = adj.get(u);
            
            for(int v : nodes) {
                if(!vis[v]) {
                    q.offer(v);
                    vis[v] = true;
                }
            }
        }
        return ans;
    }
}

/*
    Dry Run

    Input:
    adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

    Graph Representation:
    0 → {2, 3, 1}
    1 → {0}
    2 → {0, 4}
    3 → {0}
    4 → {2}

    Step 1: Initialize Variables
    ------------------------------------------------------
    ans = []
    Queue q = []
    vis = [false, false, false, false, false]  // Visited array

    Step 2: Start BFS from node 0
    ------------------------------------------------------
    q.offer(0)
    vis[0] = true

    Queue state:
    +---+
    | 0 |
    +---+

    While loop begins:

    Iteration 1: Process node 0
    ------------------------------------------------------
        - q.poll() → u = 0
        - ans = [0]

        - adj[0] = {2, 3, 1}
            - v = 2 → Not visited → q.offer(2), vis[2] = true
            - v = 3 → Not visited → q.offer(3), vis[3] = true
            - v = 1 → Not visited → q.offer(1), vis[1] = true

    Queue state:
    +---+---+---+
    | 2 | 3 | 1 |
    +---+---+---+

    Iteration 2: Process node 2
    ------------------------------------------------------
        - q.poll() → u = 2
        - ans = [0, 2]

        - adj[2] = {0, 4}
            - v = 0 → Already visited
            - v = 4 → Not visited → q.offer(4), vis[4] = true

    Queue state:
    +---+---+---+
    | 3 | 1 | 4 |
    +---+---+---+

    Iteration 3: Process node 3
    ------------------------------------------------------
        - q.poll() → u = 3
        - ans = [0, 2, 3]

        - adj[3] = {0}
            - v = 0 → Already visited

    Queue state:
    +---+---+
    | 1 | 4 |
    +---+---+

    Iteration 4: Process node 1
    ------------------------------------------------------
        - q.poll() → u = 1
        - ans = [0, 2, 3, 1]

        - adj[1] = {0}
            - v = 0 → Already visited

    Queue state:
    +---+
    | 4 |
    +---+

    Iteration 5: Process node 4
    ------------------------------------------------------
        - q.poll() → u = 4
        - ans = [0, 2, 3, 1, 4]

        - adj[4] = {2}
            - v = 2 → Already visited

    Queue state:
    +---+
    |   |  (Empty)
    +---+

    Step 3: Queue is empty, return ans
    ------------------------------------------------------
    return ans = [0, 2, 3, 1, 4]

    Final Output: [0, 2, 3, 1, 4]
*/