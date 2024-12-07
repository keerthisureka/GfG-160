// Brute Force: (TLE)
// TC: O(n^2)
// SC: O(1)
// User function Template for Java
class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int n = arr.length;
        int cnt = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i] > arr[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


// Merge Sort: (Accepted)
// TC: O(n*log(n))
// SC: O(n)
// User function Template for Java
class Solution {
    public static int merge(int[] arr, int l, int r, int m) {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i < n1; i++)
            left[i] = arr[i + l];
        for(int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];
        
        int cnt = 0;
        
        int i = 0;
        int j = 0;
        int k = l;
        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
                cnt += (n1 - i);
            }
            k++;
        }
        while(i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return cnt;
    }
    
    public static int count(int[] arr, int l, int r) {
        int res = 0;
        if(l < r) {
            int m = (l + r) / 2;
            res += count(arr, l, m); // count while dividing the left part
            res += count(arr, m+1, r); // count while dividing the right part
            
            res += merge(arr, l, r, m); // count while merging
        }
        return res;
    }
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int n = arr.length;
        
        return count(arr, 0, n-1);
    }
}