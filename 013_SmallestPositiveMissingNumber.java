// TC: O(nlogn + n)
// SC: O(1)
class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int num = 1;
        for(int i=0; i<n; i++) {
            if(arr[i] <= 0) continue;
            if(i > 0 && arr[i] == arr[i-1]) continue;
            if(arr[i] != num)
                return num;
            num++;
        }
        return num;
    }
}