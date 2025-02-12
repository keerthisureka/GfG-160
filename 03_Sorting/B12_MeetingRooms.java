// Approach: (Sorting)
// TC: O(n*logn)
// SC: O(1)
class Solution {
    static boolean canAttend(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]); // Based on start time
        for(int i = 0; i < n - 1; i++) {
            // If current meeting ends after the start of the next meeting
            if(arr[i][1] > arr[i + 1][0])
                return false;
        }
        return true;
    }
}