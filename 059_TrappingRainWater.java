// Approach-1: (Compute leftMax and rightMax at every index)
// TC: O(n)
// SC: O(n)
class Solution {
    public int maxWater(int[] arr) {
        int n = arr.length;
        
        // Array to store the maximum height to the left of each index
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        // Array to store the maximum height to the right of each index
        int[] rightMax = new int[n];
        rightMax[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate the total water trapped
        int waterTrapped = 0;
        for(int i = 0; i < n; i++) {
            int h = Math.min(leftMax[i], rightMax[i]) - arr[i];
            waterTrapped += h;
        }

        return waterTrapped;
    }
}


// Approach-2: (Two Pointers)
// TC: O(n)
// SC: O(1)
class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;

        int l = 0;
        int r = n - 1;
        
        // Variables to track the maximum heights on the left and right
        int maxLeft = arr[0];
        int maxRight = arr[r];
        
        int sum = 0;
        // Use two-pointer approach to traverse the array
        while(l < r) {
            if(maxLeft <= maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, arr[l]);
                sum += maxLeft - arr[l]; // Calculate water trapped at the current position and add to the total
            }
            else {
                r--;
                maxRight = Math.max(maxRight, arr[r]);
                sum += maxRight - arr[r]; // Calculate water trapped at the current position and add to the total
            }
        }
        return sum;
    }
}