// TC: O(left.length + right.length) -> number of ants on the plank
// SC: O(1)
// User function Template for Java
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int res = 0;
        for(int i=0; i<left.length; i++) {
            res = Math.max(res, left[i]);
        }
        for(int i=0; i<right.length; i++) {
            res = Math.max(res, n - right[i]);
        }
        return res;
    }
}