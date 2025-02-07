// Approach: (Recursion)
// TC: O(n) -> visiting all nodes atleast once
// SC: O(depth) -> recursion stack
class Solution {
    public static void inorder(Node root, ArrayList<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
    
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
}