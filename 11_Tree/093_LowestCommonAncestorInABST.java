// Approach-1: (Recursive Approach)
// TC: O(h) -> visiting only one subtree (left or right)
// SC: O(h) -> recursion stack
class Solution {
    public static Node find(Node root, Node n1, Node n2) {
        if(root == null) return null;
        
        if(root.data > n1.data && root.data > n2.data)
            return find(root.left, n1, n2);
        else if(root.data < n1.data && root.data < n2.data)
            return find(root.right, n1, n2);
        else
            return root;
    }
    
    Node LCA(Node root, Node n1, Node n2) {
        return find(root, n1, n2);
    }
}


// Approach-2: (Iterative Approach)
// TC: O(h) -> visiting only one subtree (left or right)
// SC: O(1)
class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        while(root != null) {
            if(root.data > n1.data && root.data > n2.data)
                root = root.left;
            else if(root.data < n1.data && root.data < n2.data)
                root = root.right;
            else
                break;
        }
        return root;
    }
}