// Approach: (Using Priority Queue)
// TC: O(nlogn)
// SC: O(n)
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int ans = 0;

        // Min Heap to store activities in ascending order of finish time
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++) {
            p.add(new int[] {finish[i], start[i]});
        }

        // Variable to store the end time of the last selected activity
        int finishtime = -1;

        while(!p.isEmpty()) {
            int[] activity = p.poll(); // Extract the activity with the smallest finish time
            if(activity[1] > finishtime) {
                finishtime = activity[0];
                ans++;
            }
        }
        return ans;
    }
}

/* 
    Dry Run

    Input:
    start[]  = {1, 3, 2, 5}
    finish[] = {2, 4, 3, 6}

    Step 1: Insert all activities into Min Heap (sorted by finish time)
    Priority Queue (Min Heap) after inserting:
    [
        {2, 1},  // finish=2, start=1
        {3, 2},  // finish=3, start=2
        {4, 3},  // finish=4, start=3
        {6, 5}   // finish=6, start=5
    ]

    Step 2: Initialize variables:
        ans = 0
        finishtime = -1

    Step 3: Process activities from Priority Queue

    Iteration 1:
        - Extract {2, 1} (finish=2, start=1)
        - Since start=1 > finishtime=-1, select this activity
        - Update finishtime = 2, ans = 1

    Iteration 2:
        - Extract {3, 2} (finish=3, start=2)
        - Since start=2 <= finishtime=2, skip this activity

    Iteration 3:
        - Extract {4, 3} (finish=4, start=3)
        - Since start=3 > finishtime=2, select this activity
        - Update finishtime = 4, ans = 2

    Iteration 4:
        - Extract {6, 5} (finish=6, start=5)
        - Since start=5 > finishtime=4, select this activity
        - Update finishtime = 6, ans = 3

    Step 4: Final Output
    Maximum number of activities selected = 3
*/