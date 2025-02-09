// Approach: (Recursion)
// TC: O(n) -> visiting all nodes exactly once
// SC: O(h) -> recursion stack (where, h = height of the tree)
class Solution {
    public static int maxSum;
    public static int solve(Node root) {
        if(root == null)
            return 0;
            
        int l = solve(root.left);
        int r = solve(root.right);
        
        int niche_hi_milgya_answer = l + r + root.data; // (1)
        
        int koi_ek_acha = Math.max(l, r) + root.data; // (2)
        
        int only_root_acha = root.data; // (3)
        
        // max(maxSum, (1), (2), (3))
        maxSum = Math.max(maxSum, Math.max(niche_hi_milgya_answer, Math.max(koi_ek_acha, only_root_acha)));
        
        // Most important part
        return Math.max(koi_ek_acha, only_root_acha);
    }
    
    int findMaxSum(Node node) {
        maxSum = Integer.MIN_VALUE; // Node data can be negative, hence take Integer.MIN_VALUE
        solve(node);
        return maxSum;
    }
}