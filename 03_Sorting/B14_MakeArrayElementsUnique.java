// Approach: (Sorting)
// TC: O(n*logn)
// SC: O(1)
class Solution {
    public int minIncrements(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] <= arr[i - 1]) {
                cnt += (arr[i - 1] + 1) - arr[i];
                arr[i] = arr[i - 1] + 1;
            }
        }
        return cnt;
    }
}