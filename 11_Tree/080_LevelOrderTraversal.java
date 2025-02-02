// Approach: (BFS -> level wise traversal)
// TC: O(n) -> visiting all nodes at max once
// SC: O(n) -> for queue (not considering ans array)
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size(); // Size of current level in the tree
            ArrayList<Integer> temp = new ArrayList<>();
            while(size-- > 0) {
                Node curr = q.poll();
                temp.add(curr.data);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            ans.add(temp); // Store all the nodes in the current level
        }
        return ans;
    }
}