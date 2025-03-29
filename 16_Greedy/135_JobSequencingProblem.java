// Approach: (Greedy -> Sorting and PriorityQueue)
// TC; O(nlogn)
// SC: O(n)
class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));
        
        // Pair the profit and deadline of all the jobs together
        List<int[]> jobs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i]});
        }
        // Sort the jobs based on deadline in ascending order
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        
        // Min-heap to maintain the scheduled jobs based on profit
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] job : jobs) {
            // If job can be scheduled within its deadline
            if(job[0] > pq.size()) {
                pq.add(job[1]);
            }
            // Replace the job with the lowest profit
            else if(!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }

        while(!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }
        return ans;
    }
}

/*
    Dry Run

    Input:
    deadline[] = {2, 1, 2, 1, 3}
    profit[]   = {100, 50, 200, 30, 150}

    Step 1: Pair jobs with their deadlines
    jobs = [
        {2, 100}, // deadline=2, profit=100
        {1, 50},  // deadline=1, profit=50
        {2, 200}, // deadline=2, profit=200
        {1, 30},  // deadline=1, profit=30
        {3, 150}  // deadline=3, profit=150
    ]

    Step 2: Sort jobs by deadline
    sorted_jobs = [
        {1, 50},  // deadline=1, profit=50
        {1, 30},  // deadline=1, profit=30
        {2, 100}, // deadline=2, profit=100
        {2, 200}, // deadline=2, profit=200
        {3, 150}  // deadline=3, profit=150
    ]

    Step 3: Process jobs using Min-Heap (pq)

    Iteration 1: Processing {1, 50}
        - pq.size() = 0 < 1 (allowed)
        - Add 50 to pq → pq = [50]

    Iteration 2: Processing {1, 30}
        - pq.size() = 1 (not allowed)
        - pq.peek() = 50 > 30 → Ignore this job

    Iteration 3: Processing {2, 100}
        - pq.size() = 1 < 2 (allowed)
        - Add 100 to pq → pq = [50, 100]

    Iteration 4: Processing {2, 200}
        - pq.size() = 2 (not allowed)
        - pq.peek() = 50 < 200 → Remove 50 and add 200
        - pq = [100, 200]

    Iteration 5: Processing {3, 150}
        - pq.size() = 2 < 3 (allowed)
        - Add 150 to pq → pq = [100, 200, 150]

    Step 4: Compute final results
        - Jobs selected = pq.size() = 3
        - Total profit = sum(pq) = 100 + 200 + 150 = 450

    Final Output: [3, 450]
*/