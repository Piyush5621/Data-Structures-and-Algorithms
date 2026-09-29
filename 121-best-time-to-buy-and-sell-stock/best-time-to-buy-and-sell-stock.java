class Solution {
    public int maxProfit(int[] prices) {
        int minm = prices[0];
        int ans = 0;
        for( int i = 0; i < prices.length; i++ ){
            if( prices[i] < minm ){
                minm = prices[i];
            }
            else{
                ans = Math.max(prices[i] - minm, ans);
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna