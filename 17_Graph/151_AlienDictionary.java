// Approach: (Using Topological Sort)
// TC: O(n * s.length())
// SC: O(V + E)
class Solution {
    public String findOrder(String[] words) {
        int n = words.length;
        // Case when there's only one word in the words[] array
        if(n == 1) {
            HashSet<Character> hs = new HashSet<>();
            for(char c : words[0].toCharArray())
                hs.add(c);
            String ans = "";
            for(Character it : hs)
                ans += it;
            return ans;
        }
        
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] seen = new boolean[26];
        
        // Calculating the indegree of each alphabet
        for(int i = 0; i < n - 1; i++) { // O(n) * O(s.length())
            String s1 = words[i];
            String s2 = words[i + 1];
            
            int ptr = 0;
            int minLen = Math.min(s1.length(), s2.length());
            while(ptr < minLen && s1.charAt(ptr) == s2.charAt(ptr)) {
                seen[s1.charAt(ptr) - 'a'] = true;
                ptr++;
            }
            for(int j = ptr; j < s1.length(); j++)
                seen[s1.charAt(j) - 'a'] = true;
            for(int j = ptr; j < s2.length(); j++)
                seen[s2.charAt(j) - 'a'] = true;
            // Edge case where 2 strings are equal upto min length but the 1st string is of greater length than 2nd, then its an invalid order
            if(ptr == minLen) {
                if(s1.length() > s2.length())
                    return "";
            }
            else {
                adj.computeIfAbsent(s1.charAt(ptr) - 'a', k -> new ArrayList<>()).add(s2.charAt(ptr) - 'a');
                indegree[s2.charAt(ptr) - 'a']++;
            }
        }
        
        // Putting the zero indegree nodes into the queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 26; i++) { // O(26)
            if(indegree[i] == 0 && seen[i] == true) {
                q.offer(i);
                seen[i] = false;
            }
        }
        if(q.isEmpty()) // Invalid order when it forms a cyclic directed graph
            return "";
        
        // Finding the topo sort
        String ans = "";
        while(!q.isEmpty()) { // O(26)
            int node = q.poll();
            char c = (char) (node + 'a');
            ans += c;
            
            for(int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                    seen[neighbor] = false;
                }
            }
        }
        for(int i = 0; i < 26; i++) {
            if(seen[i])
                return "";
        }
        return ans;
    }
}