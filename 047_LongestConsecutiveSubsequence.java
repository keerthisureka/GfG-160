// Approach-1: (Using Sorting)
// TC: O(nlogn)
// SC: O(1)
class Solution {
    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // Sort the array to easily check for consecutive subsequence
        
        int maxCnt = 0;
        int cnt = 1;
        for(int i=1; i<n; i++) {
            if(arr[i] == arr[i-1]) // Repetitive numbers are skipped
                continue;
                
            if(arr[i] == arr[i-1] + 1) {
                cnt++;
            }
            else {
                cnt = 1;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}


// Approach-2: (Using Hashing)
// TC: O(n)
// SC: O(n)
class Solution {
    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        // HashSet to store all elements
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            if(hs.contains(arr[i]) && !hs.contains(arr[i] - 1)) { // We start counting only if the number can be the starting number of the consecutive sequence
                int num = arr[i];
                
                while(hs.contains(num)) {
                    hs.remove(num);
                    cnt++;
                    num++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}