// Approach: (Sort the array and use a binary search to count the number of valid triangles formed by each pair of sides)
// TC: O(n² * log n) -> where `n` is the number of elements in the array (due to nested loops and binary search).
// SC: O(n) -> for storing the sorted array.
// User function Template for Java
class Solution {
    // Binary search function to find the first index with a value >= x
    static int binarySearch(int arr[], int left, int right, int x) {
        // While the range is valid (right >= left)
        while (right >= left && right < arr.length) {
            // Calculate mid index
            int mid = left + (right - left) / 2;
            
            // If the value at mid is greater than or equal to x, search in the left part
            if (arr[mid] >= x) {
                right = mid - 1;
            } else {
                // Otherwise, search in the right part
                left = mid + 1;
            }
        }
        // Return the left index, which is the first element >= x
        return left;
    }
    
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int count = 0; // Variable to store the number of triangles
        int n = arr.length; // Size of the array
        
        // Sort the array to use binary search effectively
        Arrays.sort(arr);
        
        // Iterate through the array with the first pointer (i)
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2; // Initialize the third pointer (k) to i + 2
            
            // Iterate with the second pointer (j), which starts from i + 1
            for (int j = i + 1; j < n - 1 && arr[i] != 0; j++) {
                // Perform binary search to find the index where the sum of arr[i] and arr[j] is greater
                k = binarySearch(arr, k, n - 1, arr[i] + arr[j]);
                
                // Add the count of triangles formed by arr[i] and arr[j]
                count += k - j - 1;
            }
        }
        
        // Return the total count of triangles
        return count;
    }
}