// Approach: Use a 26-way trie (prefix tree) where each node has up to 26 children and a flag marking end-of-word; insert by creating/traversing nodes, search by traversing and checking the end flag, prefix check by traversing only.
// TC: insert/search/isPrefix each take O(L) time per operation -> where L = length of the word.
// SC O(N * L) -> in the worst case for storing N words of average length L (each new character may allocate a new node).
class Trie {
    // Node structure for the trie
    static class TrieNode {
        TrieNode[] children; // child links for 'a' to 'z'
        boolean isEndOfWord; // true if this node completes a word

        TrieNode() {
            children    = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root; // root of the trie

    // Constructor initializes the trie with an empty root node
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode crawler = root; // start at the root

        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // map 'a'..'z' to 0..25
            if(crawler.children[index] == null) {
                crawler.children[index] = new TrieNode(); // create node if missing
            }
            crawler = crawler.children[index]; // move to the child
        }
        crawler.isEndOfWord = true; // mark end of word
    }

    // Search for a full word in the trie
    public boolean search(String word) {
        TrieNode crawler = root; // start at the root

        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(crawler.children[index] == null) {
                return false; // missing node → word not present
            }
            crawler = crawler.children[index]; // move to child
        }
        return crawler != null && crawler.isEndOfWord; // true only if end-of-word flag is set
    }

    // Check if any word in the trie starts with the given prefix
    public boolean isPrefix(String prefix) {
        TrieNode crawler = root; // start at the root

        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(crawler.children[index] == null) {
                return false; // missing node → no such prefix
            }
            crawler = crawler.children[index]; // move to child
        }
        return true; // all prefix characters found
    }
}