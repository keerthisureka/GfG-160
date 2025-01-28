// Approach: (Optimal)
// TC: O(n + (k % n)) ~ O(2n) -> where n = length of linked list
// SC: O(1)
class Solution {
    public Node rotate(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        Node temp = head;
        int len = 1; // Determine the length of the given linked list
        while(temp.next != null) {
            temp = temp.next;
            len++;
        }
        temp.next = head; // Attach the last node link to head
        
        k = k % len; // Mod is done for cases where k is greater than len
        while(k-- > 0) {
            temp = temp.next;
        }
        head = temp.next; // Store the new head
        temp.next = null;
        return head;
    }
}