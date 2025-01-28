// TC: O(n)
// SC: O(n)
class Solution {
    int countPairs(int arr[], int target) {
        int n = arr.length;
        int cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(mp.containsKey(target - arr[i])) {
                cnt += mp.get(target - arr[i]);
            }
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        return cnt;
    }
}