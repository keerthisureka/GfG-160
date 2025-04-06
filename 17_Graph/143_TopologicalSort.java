// Approach: (Kahn's Algorithm (BFS))
// TC: O(E + V + (V + E)) ~ O(V + E) -> for loop (edges) + for loop (queue) + while loop (queue)
// SC: O((V + E) + V + V) ~ O(V + E) -> adj + indegree + queue
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for(int adjNode : adj.getOrDefault(node, new ArrayList<>())) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0)
                    q.add(adjNode);
            }
        }
        return ans;
    }
}

/*
    Dry Run of Kahn’s Algorithm (Topological Sort using BFS)

    Input:
    V = 4
    edges = [[3, 0], [1, 0], [2, 0]]

    Graph:
    Adjacency List:
    3 → [0]
    1 → [0]
    2 → [0]

    Initial Indegree Array:
    [3, 0, 0, 0]

    Initial Queue (nodes with indegree 0):
    Queue: [1, 2, 3]
    Answer: []

    ----------------------------------------------------
    Step 1:
    Dequeue node: 1
    Answer: [1]
    Neighbor 0 → indegree[0] = 2
    Queue: [2, 3]

    ----------------------------------------------------
    Step 2:
    Dequeue node: 2
    Answer: [1, 2]
    Neighbor 0 → indegree[0] = 1
    Queue: [3]

    ----------------------------------------------------
    Step 3:
    Dequeue node: 3
    Answer: [1, 2, 3]
    Neighbor 0 → indegree[0] = 0 → Enqueue 0
    Queue: [0]

    ----------------------------------------------------
    Step 4:
    Dequeue node: 0
    Answer: [1, 2, 3, 0]
    No neighbors
    Queue: []

    ----------------------------------------------------
    All nodes processed → Valid Topological Sort
    Final Output: [1, 2, 3, 0]
*/