// Approach-1: (Basic Approach)
// TC: O(n^2) -> function call + for loop to find the root value in inorder[] array for every function call
// SC: O(depth) -> recursion stack
class Solution {
    public static Node build(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        // Base case: if array bounds become invalid, return null
        if(inStart > inEnd || preStart > preEnd) return null;
        
        // Create root node from first element of preorder (preorder traversal always has root first)
        Node root = new Node(preorder[preStart]);
        // Find position of root in inorder traversal
        int i = inStart;
        for(; i <= inEnd; i++) {
            if(root.data == inorder[i])
                break;
        }
        
        // Calculate sizes of left and right subtrees: Elements before root in inorder are in left subtree; Elements after root in inorder are in right subtree
        int leftSize = i - inStart;
        int rightSize = inEnd - i;
        
        // Recursively build left and right subtree
        root.left = build(inorder, preorder, inStart, i - 1, preStart + 1, preEnd - rightSize);
        root.right = build(inorder, preorder, i + 1, inEnd, preStart + leftSize + 1, preEnd);
        
        return root;
    }
    
    public static Node buildTree(int inorder[], int preorder[]) {
        return build(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
}


// Approach-2: (Optimized Approach)
// TC: O(n) -> function call
// SC: O(n) -> recursion stack + HashMap
class Solution {
    public static HashMap<Integer, Integer> mp;
    public static Node build(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        // Base case: if array bounds become invalid, return null
        if(inStart > inEnd || preStart > preEnd) return null;
        
        // Create root node from first element of preorder (preorder traversal always has root first)
        Node root = new Node(preorder[preStart]);
        // Using map to find position of root in inorder traversal
        int i = mp.get(root.data);
        
        // Calculate sizes of left and right subtrees: Elements before root in inorder are in left subtree; Elements after root in inorder are in right subtree
        int leftSize = i - inStart;
        int rightSize = inEnd - i;
        
        // Recursively build left and right subtree
        root.left = build(inorder, preorder, inStart, i - 1, preStart + 1, preEnd - rightSize);
        root.right = build(inorder, preorder, i + 1, inEnd, preStart + leftSize + 1, preEnd);
        
        return root;
    }
    
    public static Node buildTree(int inorder[], int preorder[]) {
        // Store the indices of each node in the HashMap
        mp = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return build(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
}