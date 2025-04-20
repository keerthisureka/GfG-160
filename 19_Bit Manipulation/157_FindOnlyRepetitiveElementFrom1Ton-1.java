// Approach: (Using Bitwise XOR)
// TC: O(n)
// SC: O(1)
class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int res = 0;
        // XOR all numbers from 1 to (n-1) and elements in the array
        for(int i = 0; i < n - 1; i++) {
            res = res ^ (i + 1) ^ arr[i];
        }
        // XOR the last element in the array
        res ^= arr[n - 1];
        return res;
    }
}