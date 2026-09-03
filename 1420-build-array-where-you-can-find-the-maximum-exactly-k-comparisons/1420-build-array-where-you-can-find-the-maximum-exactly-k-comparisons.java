class Solution {
    int mod = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        int memo[][][] = new int[n][m+1][k+1];
        for (int[][] arr : memo) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0 , n, m , k,memo , 0,0);
    }

    private int solve( int i, int n, int m, int k , int memo[][][], int maxm, int tc ){
        if (tc > k) return 0;
        if(i >= n ){
            return tc == k ? 1 : 0;
        }

        if(memo[i][maxm][tc]!=-1) return memo[i][maxm][tc];

        long count = 0;
        for( int num = 1; num <= m; num++ ){
            int newMax = maxm;
            int newTc = tc;
            if( num > maxm ){
                newMax = num;
                newTc++;
            }
            count += solve(i+1, n, m , k, memo,newMax,newTc);
            count  = count % mod;
        }

        return memo[i][maxm][tc] = (int)count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna