// TC: O(n)
// SC: O(n)
class Solution {
    static Node cloneHelper(Node node, Map<Node, Node> mp) {
        if(node == null) {
            return null;
        }

        // If the node is already cloned, return the cloned node
        if(mp.containsKey(node)) {
            return mp.get(node);
        }

        // Create a new node with the same data
        Node newNode = new Node(node.data);
        mp.put(node, newNode);

        // Recursively clone the next and random pointers
        newNode.next = cloneHelper(node.next, mp);
        newNode.random = cloneHelper(node.random, mp);

        return newNode;
    }

    // Function to clone the linked list
    public static Node cloneLinkedList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        return cloneHelper(head, mp);
    }
}