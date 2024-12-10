// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    static int minRemoval(int intervals[][]) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int cnt = 0;
        int cs = intervals[0][0]; // current start
        int ce = intervals[0][1]; // current end
        
        for(int i=1; i<n; i++) {
            int ns = intervals[i][0]; // next start
            int ne = intervals[i][1]; // next end
            
            if(ns < ce) { // Overlapping
                if(ce > ne) { // Since current end is larger it has more chances of causing overlap with further intervals
                    // Hence delete current interval so current start and end gets updated
                    cs = ns;
                    ce = ne;
                }
                // Else delete next interval so current start and end does not get updated
                cnt++;
            }
            else { // Non-overlapping
                cs = ns;
                ce = ne;
            }
        }
        return cnt;
    }
}