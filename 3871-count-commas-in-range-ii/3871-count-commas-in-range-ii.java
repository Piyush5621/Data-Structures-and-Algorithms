class Solution {
    public long countCommas(long n) {
        if( n < 1000) return 0;
        long start = 1000;
        long ans = 0;
        while( start <= n){
            ans += (n - start + 1);
            start *=1000;
        }
        return ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna