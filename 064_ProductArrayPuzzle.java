// Approach: (2 iterations L to R and R to L -> Prefix and Suffix Product)
// TC: O(n)
// SC: O(1) -> apart from ans[] array
// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        
        // Calculate the prefix product
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * arr[i - 1];
        }
        // Calculate the suffix product and multiply with the prefix product
        int prod = 1;
        for(int i = n - 2; i >= 0; i--) {
            prod *= arr[i + 1];
            ans[i] = ans[i] * prod;
        }
        return ans;
    }
}