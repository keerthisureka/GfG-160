// Approach: (Greedy -> Sorting and Two Pointers)
// TC: O(nlogn)
// SC: O(1)
class Solution {
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0; // Pointer to arr[] array
        int j = 0; // Pointer to dep[] array
        int cnt = 0;
        int platforms = 0;
        while(i < n) {
            while(j < n && dep[j] < arr[i]) { // If departed, decrement the platform count
                cnt--;
                j++;
            }
            cnt++; // Rlse increment the platform count
            i++;
            
            platforms = Math.max(platforms, cnt);
        }
        
        return platforms;
    }
}

/* 
    Dry Run

    Input:
    arr[] =  {900, 940, 950, 1100, 1500, 1800}
    dep[] =  {910, 1200, 1120, 1130, 1900, 2000}

    Step 1: Sorting
    Sorted arr[] = {900, 940, 950, 1100, 1500, 1800}
    Sorted dep[] = {910, 1120, 1130, 1200, 1900, 2000}

    Initial Variables:
    i = 0, j = 0, cnt = 0, platforms = 0

    Step 2: Processing each train arrival
    ------------------------------------------------------
    i = 0, arr[i] = 900
    - dep[j] = 910 (910 > 900) → No departure
    - cnt++ (1), platforms = max(0,1) = 1

    i = 1, arr[i] = 940
    - dep[j] = 910 (910 < 940) → Departing train, cnt-- (0), j++
    - cnt++ (1), platforms = max(1,1) = 1

    i = 2, arr[i] = 950
    - dep[j] = 1120 (1120 > 950) → No departure
    - cnt++ (2), platforms = max(1,2) = 2

    i = 3, arr[i] = 1100
    - dep[j] = 1120 (1120 > 1100) → No departure
    - cnt++ (3), platforms = max(2,3) = 3

    i = 4, arr[i] = 1500
    - dep[j] = 1120 (1120 < 1500) → Departing train, cnt-- (2), j++
    - dep[j] = 1130 (1130 < 1500) → Departing train, cnt-- (1), j++
    - dep[j] = 1200 (1200 < 1500) → Departing train, cnt-- (0), j++
    - cnt++ (1), platforms = max(3,1) = 3

    i = 5, arr[i] = 1800
    - dep[j] = 1900 (1900 > 1800) → No departure
    - cnt++ (2), platforms = max(3,2) = 3

    Step 3: Final Output
    Platforms required = 3
*/