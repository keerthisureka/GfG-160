// Approach: (Use a deque to store indices of potential maximums for each sliding window)
// TC: O(n) -> Each element is processed at most twice (added and removed).
// SC: O(k) -> The deque stores at most k indices at any time.
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // Get the length of the array
        int n = arr.length;
        // Result list to store maximums for each subarray
        ArrayList<Integer> result = new ArrayList<>();
        // Deque to store indices of potential maximum values for each sliding window
        Deque<Integer> deq = new LinkedList<>();

        // Loop through every element in the array
        for(int i = 0; i < n; i++) {
            // Remove indices from the front if they are out of the current window (i - k)
            while(!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }
            // Remove from the back all indices whose corresponding values are less than the current element
            while(!deq.isEmpty() && arr[i] >= arr[deq.peekLast()]) {
                deq.pollLast();
            }
            // Add current index to the deque
            deq.offerLast(i);
            // Once the first window is reached (i >= k-1), add the current maximum to result
            if(i >= k - 1) {
                result.add(arr[deq.peekFirst()]);
            }
        }
        return result;
    }
}