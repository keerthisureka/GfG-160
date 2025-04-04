// Approach-1: (DFS Traversal)
// TC: O(V + E)
// SC: O(V + E) + O(V) + O(V) -> HashMap + vis array + Recursion Stack
class Solution {
    public static boolean checkCycle(int node, int parent, boolean[] vis, HashMap<Integer, List<Integer>> adj) {
        vis[node] = true;
        // Check every adjacent node to the current node
        for(int v : adj.get(node)) {
            // Not visited and found a cycle, then return true
            if(!vis[v]) {
                if(checkCycle(v, node, vis, adj))
                    return true;
            }
            // Visited and the adjacent node is not the parent of the current node, then it's a cycle
            else if(v != parent) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Adjacency list to represent the graph
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        // Check for cycle at every unvisited node
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(checkCycle(i, -1, vis, adj))
                    return true;
            }
        }
        return false;
    }
}

/*
    Dry Run

    Input:
    V = 4, E = 4
    edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]

      0
     / \
    1 - 2
       /
      3

    Step 1: Build Adjacency List
    ------------------------------------------------------
    Adjacency List (Graph Representation):

    0 → [1, 2]
    1 → [0, 2]
    2 → [0, 1, 3]
    3 → [2]

    Step 2: Initialize Visited Array
    ------------------------------------------------------
    vis = [false, false, false, false]

    Step 3: Start DFS for Cycle Detection
    ------------------------------------------------------

    Starting from node 0:
    ------------------------------------------------------
    checkCycle(0, -1)

    - Mark 0 as visited → vis = [true, false, false, false]
    - Explore neighbors: 1 and 2

    ------------------------------------------------------
    Moving to node 1:
    checkCycle(1, 0)

    - Mark 1 as visited → vis = [true, true, false, false]
    - Explore neighbors: 0 and 2
    - 0 is the parent → continue
    - Move to 2

    ------------------------------------------------------
    Moving to node 2:
    checkCycle(2, 1)

    - Mark 2 as visited → vis = [true, true, true, false]
    - Explore neighbors: 0, 1, and 3
    - 1 is the parent → continue
    - 0 is already visited and NOT the parent → CYCLE DETECTED!

    Returning true up the recursion stack.
    ------------------------------------------------------
    checkCycle(2, 1) → true
    checkCycle(1, 0) → true
    checkCycle(0, -1) → true

    Step 4: Return Result
    ------------------------------------------------------
    isCycle() returns **true** since a cycle exists.

    Final Output:
    ------------------------------------------------------
    true
*/


// Approach-2: (BFS Traversal)
// TC: O(V + E)
// SC: O(V + E) + O(V) + O(V) -> HashMap + vis array + Queue
class Solution {
    public static boolean checkCycle(int start, boolean[] vis, HashMap<Integer, List<Integer>> adj) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, -1});
        vis[start] = true;
        
        while(!q.isEmpty()) {
            int[] front = q.poll();
            int node = front[0];
            int parent = front[1];
            
            for(int v : adj.get(node)) {
                if(!vis[v]) {
                    vis[v] = true;
                    q.add(new int[] {v, node});
                }
                // Visited and the adjacent node is not the parent of the current node, then it's a cycle
                else if(v != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Adjacency list to represent the graph
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        // Check for cycle at every unvisited node
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(checkCycle(i, vis, adj))
                    return true;
            }
        }
        return false;
    }
}

/*
    Dry Run of BFS Cycle Detection Algorithm

    Input:
    V = 4
    edges[][] = {
        {0, 1},
        {0, 2},
        {1, 2},
        {2, 3}
    }

    Graph Representation:
    Adjacency List:
    0 → [1, 2]
    1 → [0, 2]
    2 → [0, 1, 3]
    3 → [2]

    Queue Representation During BFS Traversal:

    Initial State:
    Queue:
    +-------+
    | 0, -1 |
    +-------+
    Visited: {0}

    Step 1: Process Node 0
    - Dequeue (0, -1)
    - Visit neighbors: 1 and 2
    - Enqueue unvisited neighbors with current node as parent

    Queue:
    +-------+-------+
    | 1, 0  | 2, 0  |
    +-------+-------+
    Visited: {0, 1, 2}

    Step 2: Process Node 1
    - Dequeue (1, 0)
    - Visit neighbors: 0 and 2
    - Neighbor 0 is the parent; continue
    - Neighbor 2 is visited and not the parent; cycle detected

    Cycle detected. Algorithm returns true.
*/