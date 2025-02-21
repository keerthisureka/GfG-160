// Approach: (Stack)
// TC: O(n)
// SC: O(n)
class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else { // If stack is not empty, we check for corresponding brackets
                if(!st.isEmpty() && ((c == ')' && st.peek() == '(') || (c == '}' && st.peek() == '{') || (c == ']' && st.peek() == '['))) {
                    st.pop();
                }
                else { // Implies stack is empty, though a closing bracket is seen
                    // Or the equivalent opening bracket is not seen on the stack for the closing bracket
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}