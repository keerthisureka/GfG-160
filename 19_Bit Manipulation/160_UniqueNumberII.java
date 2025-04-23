// Approach: (Using Bitwise XOR)
// TC: O(n)
// SC: O(1)
class Solution {
    public int[] singleNum(int[] arr) {
        int n = arr.length;
        int xor = 0;
        for(int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        
        // Finding the last set bit
        xor = (xor & -xor);
        
        int[] res = new int[2];
        for(int i = 0; i < n; i++) {
            if((arr[i] & xor) == 0) { // If bit is not set, it belongs to the first set
                res[0] ^= arr[i];
            }
            else { // If bit is set, it belongs to the second set
                res[1] ^= arr[i];
            }
        }
        
        if(res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }
}