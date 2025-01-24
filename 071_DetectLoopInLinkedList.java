// Approach: (Floyd's Cycle-Finding Algorithm/Tortoise and the Hare Algorithm)
// TC: O(n)
// SC: O(1)
class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // This loop runs until slow and fast are not null or they're not equal
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // Cycle exists
            if(slow == fast)
                return true;
        }
        // If any of them is null, it implies that a loop does not exist
        return false;
    }
}