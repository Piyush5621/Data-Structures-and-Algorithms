class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minm = prices[0]; 
        for(int  i=1; i<prices.length; i++){
            minm = Math.min(minm,prices[i]);
            if(prices[i]>prices[i-1]){
                ans = Math.max(ans,prices[i]-minm);
            }
            
        }
        return ans;
    }
}