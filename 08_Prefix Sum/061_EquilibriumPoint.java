// Approach-1: (Prefix & Suffix Sum)
// TC: O(n)
// SC: O(n)
class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;

        // Compute prefix sum at every index from (0...i)
        long[] prefix = new long[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        // Compute suffix sum at every index from (i...(n-1))
        long[] suffix = new long[n];
        suffix[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }
        
        // Check for equilibrium point
        for(int i = 0; i < n; i++) {
            if(prefix[i] == suffix[i]) {
                return i;
            }
        }
        return -1;
    }
}


// Approach-2: (Running Prefix & Suffix Sum)
// TC: O(n)
// SC: O(1)
class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        
        // Compute the total sum of the array
        long tot = 0;
        for(int i = 0; i < n; i++) {
            tot += arr[i];
        }
        
        // Check for equilibrium point
        long prefSum = 0;
        for(int i = 0; i < n; i++) {
            long suffSum = tot - prefSum - arr[i];
            
            if(prefSum == suffSum) {
                return i;
            }
            prefSum += arr[i];
        }
        return -1;
    }
}