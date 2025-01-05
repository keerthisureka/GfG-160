// TC: O(nlogn + n)
// SC: O(1)
// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int cnt = 0;

        // Two pointer technique
        while(left < right) {
            int sum = arr[left] + arr[right];

            // If the sum is less than target, then arr[left] will form a valid pair with every element from index left + 1 to right.
            if(sum < target) {
                cnt += right - left;
                left++;
            }
            else {
                right--;
            }
        }
        return cnt;
    }
}