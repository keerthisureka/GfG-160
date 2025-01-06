// TC: O(nlogn + n)
// SC: O(1)
// User function Template for Java
class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(arr); // O(nlogn)
        int l = 0;
        int r = n - 1;
        int minDiff = Integer.MAX_VALUE;
        while(l < r) { // O(n)
            int sum = arr[l] + arr[r];
            /* We want to obtain the closest sum to the target, 
            not necessarily below the target or above the target.
            It can be anywhere. */
            if(Math.abs(target - sum) < minDiff) {
                minDiff = Math.abs(target - sum);
                ans = Arrays.asList(arr[l], arr[r]);
            }
            
            if(sum > target) {
                r--;
            }
            else if(sum < target) {
                l++;
            }
            else {
                return ans;
            }
        }
        return ans;
    }
}