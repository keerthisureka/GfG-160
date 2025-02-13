// Approach-1: (Morris Traversal -> Inorder)
// TC: O(n) -> visiting all nodes once
// SC: O(n) -> HashSet
class Solution {
    boolean findTarget(Node root, int target) {
        Node curr = root;
        HashSet<Integer> hs = new HashSet<>(); // Keeps track of seen elements in BST
        while(curr != null) {
            if(curr.left == null) {
                if(hs.contains(target - curr.data))
                    return true;
                hs.add(curr.data);
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
        return false;
    }
}


// Approach-2: (Recursion)
// TC: O(n) -> visiting all nodes once
// SC: O(n) -> recursion stack + HashSet
class Solution {
    public static HashSet<Integer> seen;
    public static boolean dfs(Node root, int target) {
        if(root == null) return false;
        if(seen.contains(target - root.data)) return true;
        seen.add(root.data);
        return dfs(root.left, target) || dfs(root.right, target);
    }
    boolean findTarget(Node root, int target) {
        seen = new HashSet<>(); // Keeps track of seen elements in BST
        return dfs(root, target);
    }
}