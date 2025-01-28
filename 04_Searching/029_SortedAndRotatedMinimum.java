// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i] < arr[i-1]) {
                min = arr[i];
                break;
            }
        }
        return min;
    }
}