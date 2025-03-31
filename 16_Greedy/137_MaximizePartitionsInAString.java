// Approach: (Greedy)
// TC: O(n)
// SC: O(26) ~ O(1)
class Solution {
    public int maxPartitions(String s) {
        int n = s.length();
        
        // Keeping track of the right most occurrence of the characters in 's'
        int[] rightIdx = new int[26];
        Arrays.fill(rightIdx, -1);
        for(int i = n - 1; i >= 0; i--) {
            if(rightIdx[s.charAt(i) - 'a'] == -1)
                rightIdx[s.charAt(i) - 'a'] = i;
        }
        
        // Counting the partitions
        int i = 0; // Tracks the start of the partition
        int j = 0; // Tracks the end of the partition
        int partitions = 0;
        while(i < n) {
            j = Math.max(j, rightIdx[s.charAt(i) - 'a']);
            // Check if the chars within the partition have the right most occurrence beyond the current partition's end
            while(i < j) {
                j = Math.max(j, rightIdx[s.charAt(i) - 'a']);
                i++;
            }
            partitions++;
            i++;
        }
        return partitions;
    }
}

/*
    Dry Run

    Input:
    s = "acbbcc"

    Step 1: Compute Rightmost Occurrences
    ------------------------------------------------------
    n = 6
    rightIdx = new int[26] (initialized to -1)

    Iteration 1: i = 5, s[i] = 'c'
        rightIdx['c' - 'a'] = 5

    Iteration 2: i = 4, s[i] = 'c'
        (Already set, no change)

    Iteration 3: i = 3, s[i] = 'b'
        rightIdx['b' - 'a'] = 3

    Iteration 4: i = 2, s[i] = 'b'
        (Already set, no change)

    Iteration 5: i = 1, s[i] = 'c'
        (Already set, no change)

    Iteration 6: i = 0, s[i] = 'a'
        rightIdx['a' - 'a'] = 0

    rightIdx after computation:
        rightIdx['a'] = 0
        rightIdx['b'] = 3
        rightIdx['c'] = 5

    Step 2: Partitioning the String
    ------------------------------------------------------
    Initialize:
        i = 0, j = 0, partitions = 0

    Iteration 1: i = 0, s[i] = 'a'
        j = max(0, rightIdx['a']) = max(0, 0) = 0
        Partition completed → partitions = 1
        Move i to next index → i = 1

    Iteration 2: i = 1, s[i] = 'c'
        j = max(1, rightIdx['c']) = max(1, 5) = 5

    Iteration 3: i = 2, s[i] = 'b'
        j = max(5, rightIdx['b']) = max(5, 3) = 5
        (No change)

    Iteration 4: i = 3, s[i] = 'b'
        j = max(5, rightIdx['b']) = max(5, 3) = 5
        (No change)

    Iteration 5: i = 4, s[i] = 'c'
        j = max(5, rightIdx['c']) = max(5, 5) = 5
        (No change)

    Iteration 6: i = 5, s[i] = 'c'
        j = max(5, rightIdx['c']) = max(5, 5) = 5
        (No change)
        Partition completed → partitions = 2
        Move i to next index → i = 6

    Step 3: Return number of partitions
    ------------------------------------------------------
    return partitions = 2

    Final Output: 2
*/