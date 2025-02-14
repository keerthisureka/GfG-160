// Approach-1: (Inorder Traversal)
// TC: O(n*logn) -> inorder traversal + sorting
// SC: O(n) -> inorder traversal is stored in ArrayList
class Solution {
    public static ArrayList<Integer> inorder;
    // Function to find the inorder traversal of the given tree
    public static void findInorder(Node root) {
        if(root == null) return;
        findInorder(root.left);
        inorder.add(root.data);
        findInorder(root.right);
    }
    
    // Update the tree values according to sorted Inorder Traversal
    public static void updateBST(Node root, int[] idx) {
        if(root == null) return;
        
        updateBST(root.left, idx);
        
        root.data = inorder.get(idx[0]); // Update the data according to sorted inorder traversal
        idx[0]++; // Keeps track of the index in inorder ArrayList
        
        updateBST(root.right, idx);
    }
    
    void correctBST(Node root) {
        inorder = new ArrayList<>();
        // Find inorder traversal
        findInorder(root);
        // Sort the ArrayList
        Collections.sort(inorder);
        // Update the BST
        int[] idx = {0};
        updateBST(root, idx);
    }
}


// Approach-2: (Using One Traversal)
// TC: O(n) -> inorder traversal
// SC: O(h) -> recursion stack
class Solution {
    public static void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    
    public static void find(Node root, Node[] first, Node[] middle, Node[] last, Node[] prev) {
        if(root == null) return;
        // Left
        find(root.left, first, middle, last, prev);
        // Root
        if(prev[0] != null && root.data < prev[0].data) {
            if(first[0] == null) {
                first[0] = prev[0];
                middle[0] = root;
            }
            else {
                last[0] = root;
            }
        }
        prev[0] = root;
        // Right
        find(root.right, first, middle, last, prev);
    }
    
    void correctBST(Node root) {
        Node[] first = {null};
        Node[] middle = {null};
        Node[] last = {null};
        Node[] prev = {null};
        
        find(root, first, middle, last, prev);
        
        if(first[0] != null && last[0] != null)
            swap(first[0], last[0]);
        else if(first[0] != null && middle[0] != null)
            swap(first[0], middle[0]);
    }
}