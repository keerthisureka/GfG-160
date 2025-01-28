// Approach-1: (2 iterations L to R and R to L -> Prefix and Suffix Product)
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


// Approach-2: (Calculate product of all non-zero numbers and handle cases based on count of zeros in array)
// TC: O(n)
// SC: O(1) -> apart from ans[] array
class Solution {
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int allProducts = 1;
        int zeroCount = 0;
        int zeroIdx = -1;

        // Calculate the product of all non-zero elements and count zeros
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                zeroCount++;
                zeroIdx = i;
            }
            else {
                allProducts *= arr[i];
            }
        }

        int[] ans = new int[n]; // Initialize result array with zeros

        if(zeroCount > 1) {
            // If more than one zero, all products are zero
            return ans;
        }
        else if(zeroCount == 1) {
            // If exactly one zero, only that index gets the product
            ans[zeroIdx] = allProducts;
        }
        else {
            // If no zeros, calculate the result for all elements
            for(int i = 0; i < n; i++) {
                ans[i] = allProducts / arr[i];
            }
        }
        return ans;
    }
}