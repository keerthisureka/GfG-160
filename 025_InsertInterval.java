// TC: O(n)
// SC: O(n) -> for ans array
// User function Template for Java
class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> res = new ArrayList<>();
        
        int i = 0;
        // Add all intervals that come before the new interval
        while(i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with the new interval
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Add all the remaining intervals
        while(i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res;
    }
}