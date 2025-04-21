// Approach: (Using Bitwise XOR)
// TC: O(n)
// SC: O(1)
class Solution {
    int missingNum(int arr[]) {
        int n = arr.length; // This represents (n - 1)
        int xor = 0;
        for(int i = 0; i < n; i++) {
            // XOR from 1 to (n - 1) and elements of arr[]
            xor = xor ^ (i + 1) ^ arr[i];
        }
        xor ^= (n + 1); // XOR with n
        return xor;
    }
}