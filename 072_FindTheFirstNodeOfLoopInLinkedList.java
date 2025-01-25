// Approach: (Floyd's Cycle-Finding Algorithm/Tortoise and the Hare Algorithm)
// TC: O(n)
// SC: O(1)
class Solution {
    public static Node findFirstNode(Node head) {
        Node slow = head;
        Node fast = head;
        
        // This loop runs until slow and fast are not null or they're not equal
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // Loop exists
            if(slow == fast) {
                // Find the first node of loop
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        // If loop does not exist, return null
        return null;
    }
}