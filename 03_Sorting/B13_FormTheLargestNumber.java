// Approach: (Sorting)
// TC: O(n*logn)
// SC: O(n)
class Solution {
    public boolean compare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }
    
    String findLargest(int[] arr) {
        int n = arr.length;
        // Converting int[] array to a String ArrayList
        ArrayList<String> nums = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nums.add(String.valueOf(arr[i]));
        }
        
        // Sorting strings since it will sort considering the MSB
        Collections.sort(nums, (s1, s2) -> compare(s1, s2) ? -1 : 1);
        if(nums.get(0).equals("0"))
            return "0";
        
        // Converting to a concatenated string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(nums.get(i));
        }
        return sb.toString();
    }
}