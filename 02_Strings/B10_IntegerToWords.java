// TC: O(log10(n))
// SC: O(1)
// User function Template for Java
class Solution {
    public static StringBuilder processBatch(int currBatch, int batchInd) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousandAndBeyond = {"", "Thousand", "Million", "Billion"};

        StringBuilder batchAns = new StringBuilder();
        if(currBatch >= 100) {
            int hunsInd = currBatch / 100;
            batchAns.append(ones[hunsInd]).append(" Hundred ");
            currBatch %= 100;
        }
        if(currBatch >= 20) {
            int tensInd = currBatch / 10;
            batchAns.append(tens[tensInd]).append(" ");
            currBatch %= 10;
        }
        if(currBatch > 0) {
            int onesInd = currBatch;
            batchAns.append(ones[onesInd]).append(" ");
        }

        batchAns.append(thousandAndBeyond[batchInd]).append(" ");
        return batchAns;
    }
    
    String convertToWords(int n) {
        if(n == 0) return "Zero";

        StringBuilder ans = new StringBuilder();
        int batchInd = 0;

        while(n > 0) {
            if(n % 1000 != 0) {
                StringBuilder batchAns = processBatch(n%1000, batchInd);
                ans.insert(0, batchAns);
            }
            n /= 1000;
            batchInd++;
        }
        return ans.toString().trim();
    }
}