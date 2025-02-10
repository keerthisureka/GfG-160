// Approach-1: (Recursion and HashMap -> to keep track of cumulative sums)
// TC: O(n)
// SC: O(n) -> recursive call stack (h) + HashMap (n)
class Solution {
    public int pathSum(Node root, int k, long currSum, HashMap<Long, Integer> prefix) {
        if(root == null) return 0;
        currSum += root.data;
        
        int cnt = prefix.getOrDefault(currSum - k, 0);
        
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        cnt += pathSum(root.left, k, currSum, prefix);
        cnt += pathSum(root.right, k, currSum, prefix);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) - 1);
        
        return cnt;
    }
    
    public int sumK(Node root, int k) {
        if(root == null) return 0;
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1); // To handle the case when we have found the exact sum k, so on subtraction we get 0.
        return pathSum(root, k, 0, prefix);
    }
}


// Approach-2: (Recursion) -> TLE
// TC: O(n^2)
// SC: O(h) -> recursive call stack
class Solution {
    public int cnt = 0;
    public void solve(Node root, int k, long currSum) {
        if(root == null) return;
        currSum += root.data;
        if(currSum == k) cnt++;
        solve(root.left, k, currSum);
        solve(root.right, k, currSum);
    }
    
    public int sumK(Node root, int k) {
        if(root == null) return 0;
        // Consider the current root value
        solve(root, k, 0);
        // Do not consider the current root value
        sumK(root.left, k);
        sumK(root.right, k);
        return cnt;
    }
}