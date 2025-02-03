// Approach-1: (BFS Level Order Traversal)
// TC: O(n) -> visiting all nodes at max once
// SC: O(n) -> for queue
class Solution {
    int height(Node node) {
        if(node == null) return 0;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Node curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            level++;
        }
        // "level" will give us the number of levels in the tree. We are counting the number of edges from root to deepest leaf node.
        return level - 1;
    }
}


// Approach-2: (DFS Traversal)
// TC: O(n) -> visiting all nodes at max once
// SC: O(n) -> recursion stack
class Solution {
    public static int DFS(Node temp) {
        if(temp == null) return 0;
        
        // Compute the height of left and right subtrees
        int leftHeight = DFS(temp.left);
        int rightHeight = DFS(temp.right);
        
        // It counts the number of levels
        return Math.max(leftHeight, rightHeight) + 1;
    }

    int height(Node node) {
        if(node == null) return 0;
        // No. of edges will be one less than the no. of levels
        return DFS(node) - 1;
    }
}