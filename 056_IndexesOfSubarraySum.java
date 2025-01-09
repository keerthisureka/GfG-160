// Approach: (Sliding Window)
// TC: O(n)
// SC: O(1)
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0; // Represents start index of the subarray
        int j = 0; // Represents end index of the subarray
        int sum = 0;
        while(j < n) {
            sum += arr[j];
            // While current sum is greater than the target, keep shrinking the window from left
            while(i < j && sum > target) {
                sum -= arr[i];
                i++;
            }
            // If sum is equal to the target, add 1-based indices to the result and return
            if(sum == target) {
                res.add(i + 1);
                res.add(j + 1);
                return res;
            }
            j++;
        }
        // If the target sum is not found, return -1
        res.add(-1);
        return res;
    }
}