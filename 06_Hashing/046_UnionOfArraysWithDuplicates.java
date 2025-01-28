// TC: O(n + m) -> where n = size of a, m = size of b
// SC: O(n + m)
// User function Template for Java
class Solution {
    public static int findUnion(int a[], int b[]) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : a) {
            hs.add(num); // HashSet does not contain repetitions
        }
        for(int num : b) {
            hs.add(num); // HashSet does not contain repetitions
        }
        // Return the size after union of both arrays
        return hs.size();
    }
}