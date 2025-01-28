// Approach: (Two Pointers)
// TC: O(n^2)
// SC: O(1)
class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int cnt = 0;
        
        for(int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            int reqSum = target - arr[i];
            while(j < k) {
                if(arr[j] + arr[k] < reqSum) {
                    j++; // Increase the second pointer to get a larger sum
                }
                else if(arr[j] + arr[k] > reqSum) {
                    k--; // Decrease the third pointer to get a smaller sum
                }
                else { // Found a valid pair
                    int ele1 = arr[j];
                    int cnt1 = 1; // Count of arr[j]
                    int ele2 = arr[k];
                    int cnt2 = 1; // Count of arr[k]
                    
                    while(j < k-1 && arr[j+1] == arr[j]) { // Count duplicates of arr[j]
                        j++;
                        cnt1++;
                    }
                    while(j < k-1 && arr[k-1] == arr[k]) { // Count duplicates of arr[k]
                        k--;
                        cnt2++;
                    }
                    
                    if(ele1 == ele2) { // All elements between j and k are the same
                        cnt += (cnt1 * (cnt1 + 1)) / 2;
                    }
                    else {
                        cnt += (cnt1 * cnt2); // Multiply counts of duplicates
                    }
                    j++;
                    k--;
                }
            }
        }
        return cnt;
    }
}