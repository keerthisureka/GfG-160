// Approach-1: (Using Min-heap -> better for unequal sized lists)
// TC: O(n * k * logk) ~ O(n * logk) -> k lists of size n each ~ n number of nodes in total
// SC: O(k)
class Solution {
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        // Insert the head nodes of k lists 
        for(Node head : arr) {
            if(head != null) pq.add(head);
        }

        // Initialize a dummy head 
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(!pq.isEmpty()) {
            // Pop the min node 
            Node top = pq.poll();
            tail.next = top;
            tail = top;
            // If top node has next node, add it to the heap.
            if(top.next != null) {
                pq.add(top.next);
            }
        }
        return dummy.next;
    }
}


// Approach-2: (Using Divide and Conquer -> better for equal sized lists)
// TC: O(n * k * log k)
// SC: O(logk) -> recursion stack
class Solution {
    public static Node mergeTwo(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            }
            else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if(head1 != null) {
            curr.next = head1;
        }
        else {
            curr.next = head2;
        }
        return dummy.next;
    }

    public static Node mergeListsRecur(int i, int j, List<Node> arr) {
        // If single list is left
        if(i == j) return arr.get(i);
        // Find the middle of lists
        int mid = i + (j - i) / 2;

        // Merge lists from i to mid 
        Node head1 = mergeListsRecur(i, mid, arr);
        // Merge lists from (mid + 1) to j 
        Node head2 = mergeListsRecur(mid + 1, j, arr);
        
        // Merge the above 2 lists 
        Node head = mergeTwo(head1, head2);

        return head;
    }

    Node mergeKLists(List<Node> arr) {
        // Base case for 0 lists 
        if(arr.size() == 0) return null;
        return mergeListsRecur(0, arr.size() - 1, arr);
    }
}