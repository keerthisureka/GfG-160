// TC: O(n * log(n))
// SC: O(n) -> for ans
class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        
        // Sort based on start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{arr[0][0], arr[0][1]});
        
        for(int i=1; i<n; i++) {
            int[] last = ans.get(ans.size() - 1);
            int[] curr = arr[i];
            // If the current interval lies within the last interval, merge it
            if(curr[0] <= last[1])
                last[1] = Math.max(last[1], curr[1]);
            else
                ans.add(new int[]{curr[0], curr[1]});
        }
        
        return ans;
    }
}