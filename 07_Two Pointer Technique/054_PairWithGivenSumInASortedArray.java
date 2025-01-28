// Approach: (Two pointers on sorted array, handle duplicates by counting them at both ends when sum equals target)
// TC: O(n)
// SC: O(1)
// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            
            if(sum == target) {
                // Handle case when all remaining elements are same
                if(arr[left] == arr[right]) {
                    int len = right - left + 1;
                    count += (len * (len - 1)) / 2; // nC2 combinations
                    break;
                }
                
                // Count duplicates at left end
                int leftCount = 1;
                while(left < right && arr[left] == arr[left + 1]) {
                    leftCount++;
                    left++;
                }
                
                // Count duplicates at right end 
                int rightCount = 1;
                while(right > left && arr[right] == arr[right - 1]) {
                    rightCount++;
                    right--;
                }
                
                count += leftCount * rightCount; // Add combinations of duplicates
                left++;
                right--;
            }
            else if(sum > target) right--; // Decrease right if sum too large
            else left++; // Increase left if sum too small
        }
        
        return count;
    }
}