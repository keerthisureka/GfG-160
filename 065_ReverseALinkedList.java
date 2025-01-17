// Approach-1: (Reverse Links in place -> Iterative Approach)
// TC: O(n) -> Traverse the entire linked list once
// SC: O(1) -> No extra space used
class Solution {
    Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;
        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}


// Approach-2: (Recursive Approach)
// TC: O(n) -> Processes one node in every recursive call
// SC: O(n) -> Recursion Stack
class Solution {
    Node reverseList(Node head) {
        if(head == null || head.next == null)
            return head;
        Node newHead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}