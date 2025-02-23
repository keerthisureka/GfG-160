// Approach: (Traverse the array from right to left using a stack to track potential next greater elements)
// TC: O(n) -> (Each element is pushed and popped at most once)
// SC: O(n) -> (Extra space is used for the stack and the result list)
class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
       int n = arr.length; // Get the number of elements in the input array.
       ArrayList<Integer> result = new ArrayList<>(n); // Initialize the result list with size n.
 
       // Initialize the result list with -1 for each element.
       for(int i = 0; i < n; i++) {
          result.add(-1);
       }
 
       Stack<Integer> stack = new Stack<>(); // Create a stack to store potential next greater elements.
 
       // Traverse the array from right to left.
       for(int i = n - 1; i >= 0; i--) {
          // Remove elements from the stack that are less than or equal to the current element.
          while(!stack.isEmpty() && stack.peek() <= arr[i]) {
             stack.pop();
          }
          // If the stack is not empty, the top element is the next greater element.
          if(!stack.isEmpty()) {
             result.set(i, stack.peek());
          }
          // Push the current element onto the stack.
          stack.push(arr[i]);
       }
 
       return result; // Return the list containing next greater elements.
    }
}