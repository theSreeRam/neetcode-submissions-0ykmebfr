class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int prevLow = prices[0];
        int res = 0;
        for(int i=1; i<n; i++){
            res = Math.max(res, prices[i]-prevLow);
            prevLow = Math.min(prevLow, prices[i]);
        }
        return res;
    }
}
