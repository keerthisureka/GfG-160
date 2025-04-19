// Approach-1: (Using Trie)
// TC: O(n * log m)
// SC: O(n * log m)
class Node {
    Node one;
    Node zero;
    Node() {
        one = null;
        zero = null;
    }
}
class Trie {
    Node root;
    Trie() {
        root = new Node();
    }
    // Function to insert in Trie
    void insert(int n) {
        Node curr = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            // Check if the bit is 0
            if(bit == 0) {
                if(curr.zero == null) {
                    curr.zero = new Node();
                }
                curr = curr.zero;
            }
            else { // Else if bit is 1
                if(curr.one == null) {
                    curr.one = new Node();
                }
                curr = curr.one;
            }
        }
    }
    // Function to find element having the maximum XOR with value n
    int findXOR(int n) {
        Node curr = root;
        int res = 0;

        for(int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            // if the bit is 0
            if(bit == 0) {
                // if set bit is present
                if(curr.one != null) {
                    curr = curr.one;
                    res += (1 << i);
                }
                else {
                    curr = curr.zero;
                }
            }
            else { // Else if bit is 1
                // if unset bit is present
                if(curr.zero != null) {
                    curr = curr.zero;
                    res += (1 << i);
                }
                else {
                    curr = curr.one;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int maxXor(int[] arr) {
        int res = 0;
        Trie t = new Trie();
        // insert the first element in trie
        t.insert(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            res = Math.max(t.findXOR(arr[i]), res);
            t.insert(arr[i]);
        }
        return res;
    }
}


// Approach-2: (Using Bit Masking)
// TC: O(n * log m)
// SC: O(n * log m)
class Solution {
    public int maxXor(int[] arr) {
        int res = 0, mask = 0;
        // to store all unique bits
        HashSet<Integer> s = new HashSet<>();

        for(int i = 30; i >= 0; i--) {
            // set the i-th bit in mask
            mask |= (1 << i);

            for(int value : arr) {
                // keep prefix of all elements till the i-th bit
                s.add(value & mask);
            }

            int cur = res | (1 << i);
            for(int prefix : s) {
                if(s.contains(cur ^ prefix)) {
                    res = cur;
                    break;
                }
            }
            s.clear();
        }
        return res;
    }
}