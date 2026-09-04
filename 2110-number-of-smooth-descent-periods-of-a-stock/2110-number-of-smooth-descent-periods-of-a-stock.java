class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int left = 0;
        int n = prices.length;
        for( int i = 0;  i < n ; i++ ){
            if(i > 0 && prices[i-1] - prices[i] != 1 ){
                left = i;
            }
            ans += (i - left) + 1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna