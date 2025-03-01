// Approach: (Use two stacks to store multipliers and previously built strings; iteratively build the decoded string without extra reversals)
// TC: O(n) -> Each character in the string is processed once.
// SC: O(n) -> In the worst case, the stacks store a significant portion of the input string.
class Solution {
    static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>(); // Stack to store multipliers.
        Stack<String> strStack = new Stack<>(); // Stack to store the strings built so far.
        String current = ""; // Current string being built.
        int k = 0; // Current multiplier.

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                // Build the multiplier k (handles multiple digits).
                k = k * 10 + (c - '0');
            }
            else if(c == '[') {
                // Push the current multiplier and string onto their stacks.
                numStack.push(k);
                strStack.push(current);
                // Reset k and current for the new substring.
                k = 0;
                current = "";
            }
            else if(c == ']') {
                // Pop the last multiplier and previous string.
                int repeatTimes = numStack.pop();
                StringBuilder decoded = new StringBuilder(strStack.pop());
                // Append the current substring repeated repeatTimes times.
                for(int i = 0; i < repeatTimes; i++) {
                    decoded.append(current);
                }
                current = decoded.toString();
            }
            else {
                // Append the current character to the current substring.
                current += c;
            }
        }
        return current;
    }
}