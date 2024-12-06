// TC: O(n*log(n) + n) -> sorting + while loop
// SC: O(1)
// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        int citationsCnt = 0;
        int idx = 0;
        while(idx < n && citations[n - 1 - idx] > idx) {
            idx++;
        }
        return idx;
    }
}