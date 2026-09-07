class Solution {
    int mod = 1000000007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        long dp[] = new long[n+1];

        int lastIdx[] = new int[26];
        Arrays.fill(lastIdx , -1);
        for( int i = 1; i <= n; i++ ){
            int ch = s.charAt(i-1) - 'a';
            if(lastIdx[ch] != -1){
                dp[i] = ((dp[i-1] * 2) - (dp[lastIdx[ch]])+mod)%mod;
            }
            else{
                dp[i] = (dp[i-1] * 2 + 1)%mod;
            }
            lastIdx[ch] = i-1;
        }

        return (int)dp[n]%mod;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna