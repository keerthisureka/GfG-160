// Approach-1: (Recursive Approach -> DFS)
// TC: O(n)
// SC: O(depth) -> recursion stack
class Solution {
    public static Node solve(Node node) {
        if(node == null) return null;
        Node temp = node.left;
        node.left = solve(node.right);
        node.right = solve(temp);
        return node;
    }
    
    void mirror(Node node) {
        solve(node);
    }
}


// Approach-2: (Iterative Approach -> BFS)
// TC: O(n)
// SC: O(n) -> queue
class Solution {
    void mirror(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }
    }
}