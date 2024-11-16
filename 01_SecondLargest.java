// TC: O(n)
// SC: O(1)
class Solution {
    public int getSecondLargest(int[] arr) {
        int large = Integer.MIN_VALUE;
        int slarge = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > large) {
                slarge = large;
                large = arr[i];
            }
            else if(arr[i] > slarge && arr[i] < large) {
                slarge = arr[i];
            }
        }
        return slarge == Integer.MIN_VALUE ? -1 : slarge;
    }
}
