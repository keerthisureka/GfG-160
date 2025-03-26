// Approach-1: (DP Recursion + Memoization) -> TLE
// TC: O(n^2) - Each substring check takes O(n), and we recurse up to n times, leading to O(n^2).
// SC: O(n) - We use a DP array of size n and recursion stack space in the worst case.
class Solution {
    public static boolean solve(String s, HashSet<String> dictionary, int idx, Boolean[] dp) {
        // Base case: If we reach the end of the string, it means the segmentation is valid
        if(idx == s.length())
            return true;
        // Return the precomputed result
        if(dp[idx] != null)
            return dp[idx];

        // Try breaking the string at every possible index
        for(int endIdx = idx + 1; endIdx <= s.length(); endIdx++) {
            // Check if substring is in the dictionary and solve the remaining part
            if(dictionary.contains(s.substring(idx, endIdx)) && solve(s, dictionary, endIdx, dp))
                return dp[idx] = true;
        }
        return dp[idx] = false;
    }

    public boolean wordBreak(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> hs = new HashSet<>();
        // Store dictionary words in HashSet for quick lookup
        for(String d : dictionary)
            hs.add(d);

        // DP array to store results of subproblems
        Boolean[] dp = new Boolean[n];

        // Start recursion from index 0
        return solve(s, hs, 0, dp);
    }
}

/* 
    Dry Run

    Input: s = "leetcode", dictionary = ["leet", "code"]
    DP Table Initially: [null, null, null, null, null, null, null, null]

    Step 1: Solve(0) → Checking "leetcode"
        - Try "l", "le", "lee", "leet" → "leet" is in dictionary → Solve(4)

    Step 2: Solve(4) → Checking "code"
        - Try "c", "co", "cod", "code" → "code" is in dictionary → Solve(8)

    Step 3: Solve(8) → End of string → Return true

    Final Computation: dp[0] = true → Word can be segmented
    Output: true
*/


// Approach-2: (Bottom-Up DP) -> TLE
// TC: O(n^2) - We iterate over the string and check substrings in the dictionary using HashSet lookup (O(1)).
// SC: O(n) - We use a DP array of size n+1 to store results.
class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> dict = new HashSet<>();
        // Store dictionary words in HashSet for quick lookup
        for(String word : dictionary) 
            dict.add(word);

        // DP array: dp[i] = true if substring s[0...i-1] can be segmented
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: Empty string is always valid

        // Iterate over all substrings
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further, as one segmentation is enough
                }
            }
        }
        return dp[n]; // If the entire string can be divided into words present in dictionary, return true
    }
}

/*
    s = "leetcode", dictionary = ["leet", "code"]

    DP Initially: [true, false, false, false, false, false, false, false, false]

    1. i = 4, substring "leet" found → dp[4] = true
    2. i = 8, substring "code" found → dp[8] = true

    Final DP: [true, false, false, false, true, false, false, false, true]
    Output: true
*/


// Approach-3: (Use recursion with memoization (DP) to check if the string can be segmented into dictionary words by trying every possible prefix and using a lookup set for fast word verification)
// TC: O(n * maxLen) - For each index (n total), we try up to maxLen substrings.
// SC: O(n) - For the memoization array and recursion call stack.
class Solution {
    private int n;
    private int[] t; // Memoization array: -1 = not computed, 0 = false, 1 = true
    private int maxLen;
    private Set<String> set; // Set to store dictionary words for quick lookup

    // Recursive function to determine if s.substring(idx) can be segmented
    private boolean solve(int idx, String s) {
        if(idx == n) {
            return true; // Base case: reached end of string
        }
        if(t[idx] != -1) {
            return t[idx] == 1; // Return memoized result if available
        }
        // If the entire substring from idx is in the dictionary, we can return true
        if(set.contains(s.substring(idx))) {
            t[idx] = 1;
            return true;
        }

        // Limit the substring length to the maximum word length in the dictionary
        int limit = Math.min(maxLen, n - idx);
        for(int l = 1; l <= limit; l++) {
            String temp = s.substring(idx, idx + l);
            if(set.contains(temp) && solve(idx + l, s)) {
                t[idx] = 1;
                return true;
            }
        }
        t[idx] = 0; // Mark this index as not breakable
        return false;
    }

    public boolean wordBreak(String s, String[] dictionary) {
        n = s.length();
        t = new int[n + 1];
        Arrays.fill(t, -1);
        maxLen = 0;
        set = new HashSet<>();
        // Insert dictionary words into the set and update maximum word length
        for(String word : dictionary) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        return solve(0, s);
    }
}