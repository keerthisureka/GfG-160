// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        int n = arr.length;
        if(n < 3) return Arrays.asList(-1, -1);
        
        int i = 0;
        int j = n-1;
        
        int lSum = 0;
        int rSum = 0;
        while(i < j) {
            if(lSum < rSum) {
                lSum += arr[i];
                i++;
            }
            else if(lSum > rSum) {
                rSum += arr[j];
                j--;
            }
            else {
                lSum += arr[i];
                rSum += arr[j];
                i++;
                j--;
            }
            if(lSum == rSum) {
                // Calculate mid sum
                int mSum = 0;
                for(int m=i; m<=j; m++)
                    mSum += arr[m];
                if(mSum == lSum)
                    return Arrays.asList(i-1, j);
            }
        }
        return Arrays.asList(-1, -1);
    }
}