// Approach: (Iterating through both linked lists)
// TC: O(n1 + n2) -> where, n1 = length of ll1; n2 = length of ll2
// SC: O(1)
class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        if(head1 == null && head2 == null) return head1; 
        else if(head1 == null) return head2;
        else if(head2 == null) return head1;
        
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummy = new Node(-1);
        Node ans = dummy;
        while(temp1 != null && temp2 != null) {
            if(temp1.data <= temp2.data) {
                ans.next = temp1;
                temp1 = temp1.next;
            }
            else {
                ans.next = temp2;
                temp2 = temp2.next;
            }
            ans = ans.next;
            ans.next = null;
        }
        
        if(temp1 != null) ans.next = temp1;
        else if(temp2 != null) ans.next = temp2;
        
        return dummy.next;
    }
}