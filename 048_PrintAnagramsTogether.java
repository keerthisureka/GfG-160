// Approach-1: (Using HashMap and Sorting)
// TC: O(n * klogk) -> where, k = size of string in arr[]
// SC: O(n * k)
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        // HashMap is used to store anagram combinations as string and keeps track of the index at which that anagram is found in the ArrayList
        HashMap<String, Integer> mp = new HashMap<>();
        
        for(String s : arr) { // O(n)
            char[] c = s.toCharArray();
            Arrays.sort(c); // O(klogk)
            
            String key = new String(c);
            // If the key is not present it implies a new anagram is found, hence add a new ArrayList in the result and update the HashMap
            if(!mp.containsKey(key)) {
                res.add(new ArrayList<>());
                mp.put(key, res.size() - 1);
            }
            res.get(mp.get(key)).add(s);
        }
        return res;
    }
}


// Approach-2: (Using HashMap and Frequency array)
// TC: O(n * k) -> where, k = size of string in arr[]
// SC: O(n * k)
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        // HashMap is used to store anagram combinations as string and keeps track of the index at which that anagram is found in the ArrayList
        HashMap<String, Integer> mp = new HashMap<>();
        
        for(String s : arr) { // O(n)
            int[] freq = new int[26];
            for(int i = 0; i < s.length(); i++) { // O(k)
                freq[s.charAt(i) - 'a']++;
                
            }
            StringBuilder sb = new StringBuilder();
            for(int num : freq) { // O(k)
                sb.append(num).append('#'); // delimiter
            }
            
            String key = sb.toString();
            // If the key is not present it implies a new anagram is found, hence add a new ArrayList in the result and update the HashMap
            if(!mp.containsKey(key)) {
                res.add(new ArrayList<>());
                mp.put(key, res.size() - 1);
            }
            res.get(mp.get(key)).add(s);
        }
        return res;
    }
}