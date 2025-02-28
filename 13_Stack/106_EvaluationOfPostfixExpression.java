// Approach: (Using Stack)
// TC: O(n)
// SC: O(n)
class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(String token : arr) {
            // If the token is a number, push it onto the stack
            if(token.matches("-?\\d+")) {  
                stack.push(Integer.parseInt(token));
            }
            else { // Otherwise, it must be an operator
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(token) {
                    case "+":   stack.push(val2 + val1);
                                break;
                    case "-":   stack.push(val2 - val1);
                                break;
                    case "*":   stack.push(val2 * val1);
                                break;
                    case "/":   stack.push(val2 / val1);
                                break;
                }
            }
        }
        return stack.pop();
    }
}