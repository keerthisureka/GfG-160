// Approach-1: (Using HashSet)
// TC: O(n^2) -> Because there is O(n) TC for the contains method on ans ArrayList
// SC: O(n)
class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Store the elements present in a[] in a HashSet
        HashSet<Integer> hs = new HashSet<>();
        for(int num : a) {
            hs.add(num);
        }
        // Find the common elements in a[] and b[] which are not already present in ans
        for(int num : b) {
            if(hs.contains(num) && !ans.contains(num)) {
                ans.add(num);
            }
        }
        return ans;
    }
}


// Approach-2: (Using HashMap)
// TC: O(n)
// SC: O(n)
class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Store the count of elements in a[]
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : a) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        // Find the common elements in a[] and b[]
        for(int num : b) {
            if(mp.getOrDefault(num, 0) > 0) {
                ans.add(num);
                mp.put(num, 0);
            }
        }
        return ans;
    }
}