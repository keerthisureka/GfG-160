// Approach-1: (Linear search in ArrayList, move recently used item to end)
// TC: O(n) -> for both get and put operations
// SC: O(capacity) -> to store key-value pairs

// design the class in the most optimal way
class LRUCache {
    // List to store key-value pairs in the cache
    private List<Pair> cache;
 
    // Maximum number of items the cache can hold
    private int capacity;
 
    // Constructor to initialize cache with specified capacity
    public LRUCache(int cap) {
        // Set the maximum capacity
        this.capacity = cap;
    
        // Initialize an empty ArrayList to store cache entries
        this.cache = new ArrayList<>();
    }
 
    // Retrieve value for a given key
    public int get(int key) {
        // Iterate through cache to find the key
        for(int i = 0; i < cache.size(); i++) {
            // Check if current entry matches the key
            if(cache.get(i).key == key) {
                // Store the found pair
                Pair temp = cache.get(i);
    
                // Remove the current entry
                cache.remove(i);
    
                // Move the entry to the end (most recently used)
                cache.add(temp);
    
                // Return the value associated with the key
                return temp.value;
            }
        }
    
        // Return -1 if key not found in cache
        return -1;
    }
 
    // Store or update a key-value pair
    public void put(int key, int value) {
        // Check if key already exists in cache
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i).key == key) {
                // Remove existing entry
                cache.remove(i);
    
                // Add updated entry at the end
                cache.add(new Pair(key, value));
                return;
            }
        }
    
        // If cache is at full capacity
        if(cache.size() == capacity) {
            // Remove the least recently used item (first item)
            cache.remove(0);
        }
    
        // Add new key-value pair to the end of the cache
        cache.add(new Pair(key, value));
    }
 
    // Inner class to represent a key-value pair
    private class Pair {
        // Key of the cache entry
        int key;
    
        // Value associated with the key
        int value;
    
        // Constructor to create a new pair
        Pair(int key, int value) {
            this.key   = key;
            this.value = value;
        }
    }
}


// Approach-2: (Doubly Linked List + Hashmap for O(1) operations)
// TC: O(1) -> for both get and put operations
// SC: O(capacity) -> to store key-value mappings
class LRUCache {
    // Doubly Linked List to maintain order of recently used items
    private LinkedList<Integer> dll;
 
    // Map to store key to (index, value) mapping
    private Map<Integer, Node> map;
 
    // Remaining capacity of cache
    private int capacity;
 
    // Constructor to initialize cache capacity
    public LRUCache(int cap) {
        capacity = cap;
        dll      = new LinkedList<>();
        map      = new HashMap<>();
    }
 
    // Node class to store key-value pair with order
    private class Node {
        int value;
    
        Node(int value) {
            this.value = value;
        }
    }
 
    // Move a key to the front (most recently used)
    private void makeRecentlyUsed(int key) {
        dll.remove(Integer.valueOf(key));
        dll.addFirst(key);
    }
 
    // Retrieve value for a given key
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
    
        makeRecentlyUsed(key);
        return map.get(key).value;
    }
 
    // Store or update key-value pair
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).value = value;
            makeRecentlyUsed(key);
        }
        else {
            if(map.size() >= capacity) {
                int lru = dll.removeLast();
                map.remove(lru);
            }
    
            dll.addFirst(key);
            map.put(key, new Node(value));
        }
    }
}