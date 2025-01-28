// TC: O(n)
// SC: O(n)
// User function Template for Java
class Solution {
    boolean twoSum(int arr[], int target) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(hs.contains(target - arr[i])) {
                return true;
            }
            hs.add(arr[i]);
        }
        return false;
    }
}