// Approach-1: (Using Recursion)
// TC: O(n) -> visiting all nodes atleast once
// SC: O(h) -> recursion stack
class Solution {
    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Function to collect left boundary nodes
    // (top-down order)
    static void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
        if(root == null || isLeaf(root))
            return;

        res.add(root.data);
        if(root.left != null)
            collectBoundaryLeft(root.left, res);
        else if(root.right != null)
            collectBoundaryLeft(root.right, res);
    }

    // Function to collect all leaf nodes
    static void collectLeaves(Node root, ArrayList<Integer> res) {
        if(root == null)
            return;

        if(isLeaf(root)) {
            res.add(root.data);
            return;
        }

        collectLeaves(root.left, res);
        collectLeaves(root.right, res);
    }

    // Function to collect right boundary nodes
    // (bottom-up order)
    static void collectBoundaryRight(Node root, ArrayList<Integer> res) {
        if(root == null || isLeaf(root))
            return;

        if(root.right != null)
            collectBoundaryRight(root.right, res);
        else if(root.left != null)
            collectBoundaryRight(root.left, res);

        res.add(root.data);
    }
    
    // Function to find Boundary Traversal of Binary Tree
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();

        if(node == null)
            return res;

        // Add root data if it's not a leaf
        if(!isLeaf(node))
            res.add(node.data);

        // Collect left boundary
        collectBoundaryLeft(node.left, res);

        // Collect leaf nodes
        collectLeaves(node, res);

        // Collect right boundary
        collectBoundaryRight(node.right, res);

        return res;
    }
}


// Approach-2: (Using Iteration and Morris Traversal)
// TC: O(n)
// SC: O(1)
class Solution {
    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    
    // Function to collect the left boundary nodes
    static void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
        if(root == null)
            return;
        Node curr = root;
        while(!isLeaf(curr)) {
            res.add(curr.data);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    // Function to collect the leaf nodes using Morris Traversal
    static void collectLeaves(Node root, ArrayList<Integer> res) {
        Node current = root;

        while(current != null) {
            if(current.left == null) {
                // If it's a leaf node
                if(current.right == null) 
                    res.add(current.data);
                current = current.right;
            } 
            else {
                // Find the inorder predecessor
                Node predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } 
                else {
                    // If it's predecessor is a leaf node
                    if(predecessor.left == null) 
                        res.add(predecessor.data);
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
    
    // Function to collect the right boundary nodes
    static void collectBoundaryRight(Node root, ArrayList<Integer> res) {
        if(root == null)
            return;

        Node curr = root;
        ArrayList<Integer> temp = new ArrayList<>();
        while(!isLeaf(curr)) {
            temp.add(curr.data);

            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        for(int i = temp.size() - 1; i >= 0; i--)
            res.add(temp.get(i));
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();

        if(node == null)
            return res;

        // Add root data if it's not a leaf
        if(!isLeaf(node))
            res.add(node.data);

        // Collect left boundary
        collectBoundaryLeft(node.left, res);

        // Collect leaf nodes
        collectLeaves(node, res);

        // Collect right boundary
        collectBoundaryRight(node.right, res);

        return res;
    }
}