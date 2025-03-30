// Approach-1: (Greedy -> two iterations)
// TC: O(n)
// SC: O(1)
class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        
        // Finding the index at which the gas > cost
        int currGas = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];
            if(currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }
        
        // Now check if its possible to go in a clockwise direction from 'start' idx
        currGas = 0;
        for(int i = 0; i < n; i++) {
            int idx = (i + start) % n;
            currGas = currGas + gas[idx] - cost[idx];
            
            if(currGas < 0) return -1;
        }
        return start;
    }
}

/*
    Dry Run

    Input:
    gas  =  {1, 2, 3, 4, 5}
    cost =  {3, 4, 5, 1, 2}

    Step 1: Find the potential starting station
    ------------------------------------------------------
    currGas = 0, start = 0

    Iteration 1: i = 0 → currGas = 0 + (1 - 3) = -2 (Negative)  
        - Reset currGas to 0
        - Move start index to i + 1 → start = 1

    Iteration 2: i = 1 → currGas = 0 + (2 - 4) = -2 (Negative)  
        - Reset currGas to 0
        - Move start index to i + 1 → start = 2

    Iteration 3: i = 2 → currGas = 0 + (3 - 5) = -2 (Negative)  
        - Reset currGas to 0
        - Move start index to i + 1 → start = 3

    Iteration 4: i = 3 → currGas = 0 + (4 - 1) = 3 (Positive)  
        - Continue

    Iteration 5: i = 4 → currGas = 3 + (5 - 2) = 6 (Positive)  
        - Continue

    Potential start station found: start = 3

    Step 2: Verify if the journey is possible from start index 3
    ------------------------------------------------------
    currGas = 0

    Iteration 1: idx = (0 + 3) % 5 = 3  
        - currGas = 0 + (4 - 1) = 3 (Positive)  

    Iteration 2: idx = (1 + 3) % 5 = 4  
        - currGas = 3 + (5 - 2) = 6 (Positive)  

    Iteration 3: idx = (2 + 3) % 5 = 0  
        - currGas = 6 + (1 - 3) = 4 (Positive)  

    Iteration 4: idx = (3 + 3) % 5 = 1  
        - currGas = 4 + (2 - 4) = 2 (Positive)  

    Iteration 5: idx = (4 + 3) % 5 = 2  
        - currGas = 2 + (3 - 5) = 0 (Valid)

    Since we complete the circuit, return `start = 3`

    Final Output: 3
*/


// Approach-2: (Greedy -> one iteration)
// TC: O(n)
// SC: O(1)
class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        
        // Finding the index at which the gas > cost
        int currGas = 0;
        int totalGas = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];
            totalGas = totalGas + gas[i] - cost[i];
            if(currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }
        
        // Now check if its possible to go in a clockwise direction from 'start' idx
        if(totalGas < 0) return -1;
        return start;
    }
}

/*
    Dry Run

    Input:
    gas  =  {1, 2, 3, 4, 5}
    cost =  {3, 4, 5, 1, 2}

    Step 1: Find the potential starting station in one iteration
    ------------------------------------------------------
    currGas = 0, totalGas = 0, start = 0

    Iteration 1: i = 0
        - currGas = 0 + (1 - 3) = -2 (Negative)
        - totalGas = 0 + (1 - 3) = -2
        - currGas < 0 → Reset currGas to 0
        - Move start index to i + 1 → start = 1

    Iteration 2: i = 1
        - currGas = 0 + (2 - 4) = -2 (Negative)
        - totalGas = -2 + (2 - 4) = -4
        - currGas < 0 → Reset currGas to 0
        - Move start index to i + 1 → start = 2

    Iteration 3: i = 2
        - currGas = 0 + (3 - 5) = -2 (Negative)
        - totalGas = -4 + (3 - 5) = -6
        - currGas < 0 → Reset currGas to 0
        - Move start index to i + 1 → start = 3

    Iteration 4: i = 3
        - currGas = 0 + (4 - 1) = 3 (Positive)
        - totalGas = -6 + (4 - 1) = -3
        - Continue

    Iteration 5: i = 4
        - currGas = 3 + (5 - 2) = 6 (Positive)
        - totalGas = -3 + (5 - 2) = 0
        - Continue

    Step 2: Check total gas balance
    ------------------------------------------------------
    - totalGas = 0 (>= 0), so completing the circuit is possible.
    - Return start index = 3.

    Final Output: 3
*/