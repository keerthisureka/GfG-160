// Approach: (Recursion)
// TC: O(log(n))
// SC: O(log(n))
class Solution {
    public static double helper(double x, long n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        
        if(n % 2 == 0) { // Even power
            return helper(x * x, n / 2);
        }
        else { // Odd power
            return x * helper(x * x, (n - 1) / 2);
        }
    }
    
    double power(double b, int e) {
        long ee = e;
        if(e < 0) // If power is negative, convert it to positive
            ee = -1 * ee; // Stores the positive power
        
        double ans = helper(b, ee); // Obtains the ans for positive power
        
        if(e < 0) // If power is negative, we need to divide 1 by the ans
            ans = (double) 1 / (double) ans;
        
        return ans;
    }
}


// Approach: (Recursion -> Clean Code)
// TC: O(log(n))
// SC: O(log(n))
class Solution {
    public static double solve(double x, long n) {
        if(n == 0) return 1; // Zero power
        if(n < 0) return solve(1 / x, -n); // Negative power
        if(n % 2 == 0) return solve(x * x, n / 2); // Even power
        return x * solve(x * x, (n - 1) / 2); // Odd power
    }
    
    double power(double b, int e) {
        return solve(b, e);
    }
}