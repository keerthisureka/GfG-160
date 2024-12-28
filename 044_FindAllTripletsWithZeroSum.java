// Approach-1: (Better -> Hashing and O(n^2) space)
// TC: O(n^2)
// SC: O(n^2)
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        
        // HashMap to store the indices of all possible sums with 2 numbers in the array
        HashMap<Integer, List<int[]>> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                mp.computeIfAbsent(arr[i] + arr[j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        
        // Finding the indices with the negative sum of the current number
        for(int i = 0; i < n; i++) {
            int rem = -arr[i];
            
            if(mp.containsKey(rem)) {
                List<int[]> pairs = mp.get(rem);
                
                for(int[] p : pairs) {
                    if(p[0] != i && p[1] != i) { // Should not be same indices
                        List<Integer> temp = Arrays.asList(i, p[0], p[1]);
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}


// Approach-2: (Optimal -> Hashing & O(n) space)
// TC: O(n^2)
// SC: O(n)
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n - 2; i++) {
            HashMap<Integer, List<Integer>> mp = new HashMap<>();
            
            for(int j = i + 1; j < n; j++) {
                if(mp.containsKey(-(arr[i] + arr[j]))) {
                    List<Integer> k = mp.get(-(arr[i] + arr[j]));
                    
                    for(int idx : k) {
                        List<Integer> temp = Arrays.asList(i, j, idx);
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                }
                
                mp.computeIfAbsent(arr[j], k -> new ArrayList<>()).add(j);
            }
        }
        return ans;
    }
}