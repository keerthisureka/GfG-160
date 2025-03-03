// Approach: (Use a sliding window with a TreeMap as a multiset to maintain the sorted elements of the window and track the longest valid subarray where the difference between the maximum and minimum is not greater than x)
// TC: O(n logn) -> each insertion/deletion in the TreeMap takes O(log n) over n elements
// SC: O(n) -> in the worst-case the TreeMap stores all elements
class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length; // size of the input array

        // TreeMap to maintain a sorted window of elements (acting as a multiset) for quick access to min and max
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        int i = 0; // start pointer of the sliding window
        int j = 0; // end pointer of the sliding window
        int bestLen = 0; // stores the maximum valid subarray length found
        int bestStart = 0; // stores the starting index of the best subarray

        while(j < n) { // iterate over the array
            // Insert current element into the TreeMap, updating its frequency
            tm.put(arr[j], tm.getOrDefault(arr[j], 0) + 1);
            // while the current window is invalid (difference between max and min > x)
            while(tm.lastKey() - tm.firstKey() > x) {
                // Remove the element at index i from the TreeMap
                int count = tm.get(arr[i]);
                if(count == 1) {
                    tm.remove(arr[i]);
                }
                else {
                    tm.put(arr[i], count - 1);
                }
                i++; // move the start pointer to shrink the window
            }
            // update best subarray if current window size is greater than bestLen
            if(j - i + 1 > bestLen) {
                bestLen   = j - i + 1;
                bestStart = i;
            }
            j++; // move end pointer to the next element
        }
        // Build and return the subarray from bestStart to bestStart + bestLen - 1
        ArrayList<Integer> res = new ArrayList<>();
        for(int k = bestStart; k < bestStart + bestLen; k++) {
            res.add(arr[k]);
        }
        return res;
    }
}