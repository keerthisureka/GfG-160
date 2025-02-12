// Approach: (Morris Traversal -> Inorder (kth smallest))
// TC: O(n) -> visiting all nodes once
// SC: O(1) -> no extra space used
class Solution {
    public int kthSmallest(Node root, int k) {
        Node curr = root;
        int cnt = 0; // Keeping track of no. of nodes visited
        
        while(curr != null) {
            if(curr.left == null) {
                cnt++;
                if(cnt == k) return curr.data;
                curr = curr.right;
            }
            else {
                Node pre = curr.left;
                while(pre.right != null)
                    pre = pre.right;
                pre.right = curr;
                
                // Removing the left pointer from curr, so that its not visited again
                Node temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return -1;
    }
}