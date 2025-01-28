// TC: O(n)
// SC: O(n)
class Solution {
    public static ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<>(); // To store the result array
        for(int i=1; i<=n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                ans.add("Fizz");
            }
            else if(i % 5 == 0) {
                ans.add("Buzz");
            }
            else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}