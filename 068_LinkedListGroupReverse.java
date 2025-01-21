// Approach: (Use recursion to reverse groups of k nodes at a time. For each group, reverse k nodes using three pointers (prev, curr, next), then recursively process the remaining list.)
// TC: O(n) where n is the number of nodes in the linked list, as we visit each node exactly once
// SC: O(n/k) due to the recursive call stack, where n is the number of nodes and k is the group size
class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // Base case: if list is empty, return null
        if (head == null) return null;
        
        // Initialize pointers for reversing the list:
        // prev: points to the previous node in reversal
        // curr: points to the current node being processed
        // nextNode: stores the next node before breaking links
        Node prev = null;    
        Node curr = head;       
        Node nextNode = null;
        
        // Counter to ensure we reverse exactly k nodes
        int count = 0;           

        // Step 1: Reverse k nodes in the current group
        while (curr != null && count < k) {
            // Store next node before we change current node's next pointer
            nextNode = curr.next;
            
            // Reverse the link: make current node point to previous node
            curr.next = prev;
            
            // Move prev and curr one step forward for next iteration
            prev = curr;
            curr = nextNode;
            
            // Keep track of how many nodes we've reversed
            count++;
        }

        // Step 2: After reversing current group:
        // 'head' is now the last node of reversed group
        // 'prev' is the new first node of reversed group
        // 'nextNode/curr' is the start of next group
        
        // Step 3: Recursively reverse next group of k nodes
        if (nextNode != null) {
            // The original 'head' is now at the end of its group, so its next should point to the head of next reversed group
            head.next = reverseKGroup(nextNode, k);
        }

        // Step 4: Return the new head of the reversed group
        return prev;
    }
}