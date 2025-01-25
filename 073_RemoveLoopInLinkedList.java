// Approach: (Floyd's Cycle-Finding Algorithm/Tortoise and the Hare Algorithm)
// TC: O(n)
// SC: O(1)
class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        
        // This loop runs until slow and fast are not null or they're not equal
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // Loop exists
            if(slow == fast) {
                slow = head;
                // Find the last node of loop
                if(slow != fast) {
                    // When the first node is not a part of the cycle
                    while(slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
                else {
                    // When the first node is also a part of the cycle
                    while(fast.next != slow) {
                        fast = fast.next;
                    }
                }
                fast.next = null;
            }
        }
    }
}