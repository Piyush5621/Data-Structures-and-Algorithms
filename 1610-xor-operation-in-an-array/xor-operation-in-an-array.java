class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        while( n-- > 0 ){
            ans ^= start;
            start +=2;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna