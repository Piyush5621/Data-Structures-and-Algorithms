class Solution {
    int memo[];
    public int climbStairs(int n, int[] costs) {
        memo = new int[n];
        Arrays.fill(memo,Integer.MAX_VALUE);
        return solve(0,n,costs);
    }

    private int solve(int idx, int n, int []costs){
        if(idx ==  n ) return 0;

        if(memo[idx] != Integer.MAX_VALUE) return memo[idx];
        int cost = 0;
        int minm = Integer.MAX_VALUE;
        for( int i = 1; i <= 3; i++){
            int j = idx+i;
            if( j <= n){
                int diff = j - idx;
                minm = Math.min(minm,costs[j-1] +(diff * diff) +solve(j,n,costs));
            } 
        }

        return memo[idx] = minm;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna