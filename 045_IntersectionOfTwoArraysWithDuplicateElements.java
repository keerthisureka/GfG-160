// TC: O(n)
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