// TC: O(n * log(sum(arr) - max))
// SC: O(1)
//Back-end complete function Template for Java
class Solution {
    public static boolean isPossible(int[] arr, int mid, int k) {
        int cnt = 1;
        int pageSum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(pageSum + arr[i] > mid) {
                cnt++;
                pageSum = arr[i];
            }
            else {
                pageSum += arr[i];
            }
        }
        return (cnt <= k);
    }
    
    public static int findPages(int[] arr, int k) {
        if(k > arr.length)
            return -1;
        
        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();
        int res = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if(isPossible(arr, mid, k)){
                res = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return res;
    }
}