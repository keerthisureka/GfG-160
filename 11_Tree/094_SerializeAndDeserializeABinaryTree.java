// Approach-1: (Preorder Traversal)
// TC: O(n)
// SC: O(n)
class Tree {
    public static void serializePreOrder(Node root, ArrayList<Integer> arr) {
        // Push -1 if root is null
        if(root == null) {
            arr.add(-1);
            return;
        }
        // Push the root into result
        arr.add(root.data);
        // Recursively traverse the left and right subtree
        serializePreOrder(root.left, arr);
        serializePreOrder(root.right, arr);
    }
    // Function to serialize a tree and return a list containing nodes of tree
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        serializePreOrder(root, arr);
        return arr;
    }
    
    public static Node deserializePreOrder(int[] i, ArrayList<Integer> arr) {
        // -1 means null
        if(arr.get(i[0]) == -1) {
            i[0]++;
            return null;
        }
        // Create the root node
        Node root = new Node(arr.get(i[0]));
        i[0]++;
        // Create the left and right subtree
        root.left = deserializePreOrder(i, arr);
        root.right = deserializePreOrder(i, arr);
        return root;
    }
    // Function to deserialize a list and construct the tree
    public Node deSerialize(ArrayList<Integer> arr) {
       int[] i = {0};
       return deserializePreOrder(i, arr);
    }
}


// Approach-2: (Using Level Order Traversal)
// TC: O(n)
// SC: O(n)
class Tree {
    public static ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node curr = q.poll();

            // If curr node is null, append -1 to result
            if(curr == null) {
                arr.add(-1);
                continue;
            }

            // else push its value into result and push left and right child nodes into queue
            arr.add(curr.data);
            q.add(curr.left);
            q.add(curr.right);
        }

        return arr;
    }
    
    public static Node deSerialize(ArrayList<Integer> arr) {
        // Base Case
        if(arr.get(0) == -1) return null;

        // create root node and push it into queue
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while(!q.isEmpty()) {
            Node curr = q.poll();

            // If left node is not null
            if(arr.get(i) != -1) {
                Node left = new Node(arr.get(i));
                curr.left = left;
                q.add(left);
            }
            i++;

            // If right node is not null
            if(arr.get(i) != -1) {
                Node right = new Node(arr.get(i));
                curr.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
}