class Solution {
    int mod = 1000000007;
    Integer memo[][];
    public int numberOfSets(int n, int k){
        memo = new Integer[n][k+1];
        return solve(0, k, n);
    }

    private int solve(int idx, int k , int n){

        if(k == 0 ) return 1;
        
        if(idx >= n) return 0;

        if (n - idx - 1 < k) return 0;

        if(memo[idx][k] != null){
            return memo[idx][k];
        }

        long count = solve(idx+1, k , n) % mod;
        for( int i = idx+1 ; i < n ; i++ ){
            count = (count + solve(i, k - 1, n)) % mod;
        }

        return memo[idx][k] = (int)count%mod;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna