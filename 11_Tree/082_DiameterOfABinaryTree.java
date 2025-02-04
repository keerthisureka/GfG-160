// Approach: (DFS)
// TC: O(n) -> visiting all nodes at max once
// SC: O(n) ~ O(depth of the tree) -> recursion stack
class Solution {
    public static int solve(Node root, int[] res) {
        if(root == null) return 0;
        
        int lh = solve(root.left, res);
        int rh = solve(root.right, res);
        
        res[0] = Math.max(res[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }
    
    int diameter(Node root) {
        if(root == null) return 0;
        // In java, array is passed by reference. We do not use variable as it is passed by value.
        int[] res = {Integer.MIN_VALUE};
        solve(root, res);
        
        return res[0];
    }
}