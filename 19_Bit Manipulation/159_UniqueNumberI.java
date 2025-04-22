// Approach: (Using Bitwise XOR)
// TC: O(n)
// SC: O(1)
class Solution {
    public int findUnique(int[] arr) {
        int n = arr.length;
        int xor = 0;
        for(int i = 0; i < n; i++) {
            xor ^= arr[i]; // Repeating twice elements cancel out each other, only the non-repeating element is left
        }
        return xor;
    }
}