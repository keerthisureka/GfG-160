// TC: O(n)
// SC: O(1)
class Solution {
    int countFreq(int[] arr, int target) {
        int n = arr.length;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] == target)
                cnt++;
        }
        return cnt;
    }
}