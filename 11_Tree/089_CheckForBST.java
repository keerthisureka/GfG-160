// Approach-1: (Inorder Traversal -> Left-Root-Right)
// TC: O(n) -> visiting all nodes exactly once
// SC: O(n) -> recursion stack (h) + all node values (n)
class Solution {
    public ArrayList<Integer> arr = new ArrayList<>();
    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        arr.add(root.data);
        inorder(root.right);
    }
    
    boolean isBST(Node root) {
        inorder(root);
        for(int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i) >= arr.get(i + 1)) // Also handles the case of duplicate node values
                return false;
        }
        return true;
    }
}


// Approach-2: (Inorder Traversal -> Left-Root-Right)
// TC: O(n) -> visiting all nodes exactly once
// SC: O(h) -> recursion stack (where, h = height of the tree)
class Solution {
    public boolean inorder(Node root, int[] prev) {
        if(root == null) return true;
        // Recursively check the left subtree
        if(!inorder(root.left, prev)) return false;
        // Current node's value should not be greater than previous value
        if(prev[0] >= root.data) return false;
        // Update the previous value to current node's value
        prev[0] = root.data;
        // Recursively check the right subtree
        return inorder(root.right, prev);
    }
    
    boolean isBST(Node root) {
        int[] prev = {Integer.MIN_VALUE};
        return inorder(root, prev);
    }
}


// Approach-3: (Using specified range of min and max values)
// TC: O(n) -> visiting all nodes exactly once
// SC: O(h) -> recursion stack (where, h = height of the tree)
class Solution {
    public boolean check(Node root, int min, int max) {
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;
        // Keep track of max value on the left subtree and min value on the right subtree
        // In left subtree, all values must be lesser than the current node's value
        // In right subtree, all values must be greater than the current node's value
        return check(root.left, min, root.data - 1) && check(root.right, root.data + 1, max);
    }
    
    boolean isBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}