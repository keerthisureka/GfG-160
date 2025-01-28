// Approach-1: (Swap and Sort each array)
// TC: O(n + m) + O(n * log(n)) + O(m * log(m))
// SC: O(1)
// User function Template for Java
class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        
        int i = n - 1; // Last elemesnt of 1st array
        int j = 0; // First element of 2nd array
        while(i >= 0 && j < m) {
            if(a[i] > b[j]) {
                // swap
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                
                i--;
                j++;
            }
            else {
                break;
            }
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
    }
}


// Approach-2: (Gap Method - Derived from Shell Sort)
// TC: O((m + n) * log(m + n))
// SC: O(1)
// User function Template for Java
class Solution {
    // Function to swap based on the larger element
    public static void swap(int arr1[], int arr2[], int ind1, int ind2) {
        if(arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
    
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int gap = (n + m + 1) / 2; // We take the ceil value after dividing, hence added 1
        
        while(gap > 0) {
            int left = 0;
            int right = gap;
            
            while(right < (n + m)) {
                if(left < n && right >= n) { // Both pointers point to separate arrays -> left to a[] and right to b[]
                    swap(a, b, left, right - n);
                }
                else if(left >= n) { // Both pointers point to second array -> b[]
                    swap(b, b, left - n, right - n);
                }
                else { // Both pointers point to first array -> a[]
                    swap(a, a, left, right);
                }
                left++;
                right++;
            }
            
            if(gap == 1) break;
            else gap = (gap + 1) / 2; // Again to consider ceil value, 1 is added
        }
    }
}