// Approach: (DFS Traversal)
// TC: O(V + E) -> recursion call for every vertex + for loop
// SC: O(V + E) -> vis array + recursion stack
class Solution {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for(int adjNode : adj.get(node)) {
            if(!vis[adjNode]) {
                dfs(adj, adjNode, vis, ans);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];
        
        dfs(adj, 0, vis, ans);
        
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
    V = adj.size() = 5
    ans = []
    vis = [false, false, false, false, false, false]  // Extra space for V+1

    Step 2: Start DFS from node 0
    ------------------------------------------------------
    Call dfs(adj, 0, vis, ans)

        - vis[0] = true
        - ans = [0]
        
        - Explore adj[0] = {2, 3, 1}
            - First adjacent node: 2
                - vis[2] = false → Call dfs(adj, 2, vis, ans)
            
    Step 3: DFS on node 2
    ------------------------------------------------------
    Call dfs(adj, 2, vis, ans)

        - vis[2] = true
        - ans = [0, 2]
        
        - Explore adj[2] = {0, 4}
            - First adjacent node: 0 (Already visited)
            - Second adjacent node: 4
                - vis[4] = false → Call dfs(adj, 4, vis, ans)

    Step 4: DFS on node 4
    ------------------------------------------------------
    Call dfs(adj, 4, vis, ans)

        - vis[4] = true
        - ans = [0, 2, 4]
        
        - Explore adj[4] = {2}
            - First adjacent node: 2 (Already visited)
        
        - Return to previous dfs call (node 2)

    Step 5: Back to node 2, return to node 0
    ------------------------------------------------------
        - Remaining nodes in adj[0]: {3, 1}
            - Next adjacent node: 3
                - vis[3] = false → Call dfs(adj, 3, vis, ans)

    Step 6: DFS on node 3
    ------------------------------------------------------
    Call dfs(adj, 3, vis, ans)

        - vis[3] = true
        - ans = [0, 2, 4, 3]
        
        - Explore adj[3] = {0}
            - First adjacent node: 0 (Already visited)
        
        - Return to previous dfs call (node 0)

    Step 7: Back to node 0, explore next adjacent node 1
    ------------------------------------------------------
        - Next adjacent node: 1
            - vis[1] = false → Call dfs(adj, 1, vis, ans)

    Step 8: DFS on node 1
    ------------------------------------------------------
    Call dfs(adj, 1, vis, ans)

        - vis[1] = true
        - ans = [0, 2, 4, 3, 1]
        
        - Explore adj[1] = {0}
            - First adjacent node: 0 (Already visited)
        
        - Return to previous dfs call (node 0)

    Step 9: All nodes visited, return ans
    ------------------------------------------------------
    return ans = [0, 2, 4, 3, 1]

    Final Output: [0, 2, 4, 3, 1]
*/