// TC: O(logn)
// SC: O(1)
class Solution {
    public int kthMissing(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] - (mid + 1) < k) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo + k;
    }
}