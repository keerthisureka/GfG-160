// TC: O(log(min(n, m)))
// SC: O(1)
// User function Template for Java
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;
        // If a[] has more elements, then call kthElement with reversed parameters
        if(n > m)
            return kthElement(b, a, k);
        
        int lo = Math.max(0, k - m);
        int hi = Math.min(k, n);

        while(lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;
            
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);
            
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);

            // If it is a valid partition
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            
            if(l1 > r2)
                hi = mid1 - 1;
            else
                lo = mid1 + 1;
        }

        return 0;
    }
}