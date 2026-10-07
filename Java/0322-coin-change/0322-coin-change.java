class Solution {
    int memo[];
    public int coinChange(int[] coins, int amount) {
        int ts = 0 ;
        memo = new int[amount+1];
        Arrays.fill(memo, -1);
        int ans = solve(coins,amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int solve(int coins[], int amount){
        if(amount == 0 ) return 0;
        if( memo[amount] != -1 ){
            return memo[amount];
        }
        int count = Integer.MAX_VALUE;
        for(int coin : coins ){
            if(coin <= amount){
                int result = solve(coins, amount - coin );
                if( result != Integer.MAX_VALUE){
                    count = Math.min(count , 1 + result);
                }
            }

        }
        return memo[amount] = count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna