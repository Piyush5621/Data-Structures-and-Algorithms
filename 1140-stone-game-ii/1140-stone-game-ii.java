class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        int memo[][][] = new int[n+1][n+1][2];
        for (int i = 0; i <= n; i++) {
            for (int m = 0; m <= n; m++) {
                Arrays.fill(memo[i][m], -1);
            }
        }
        return solve(0 , n ,1, piles,0,memo); 
    }

    private int solve(int i, int n, int m , int piles[],int turn ,int memo[][][]){
        if(i>=n) return 0;
        if(memo[i][m][turn]!=-1){
            return memo[i][m][turn];
        }
        int stones = 0;
        int res = (turn==0)? -1 : Integer.MAX_VALUE;

        for( int x = 1 ; x <= Math.min(2*m,n-i); x++){
            stones += piles[i+x-1];

            if(turn==0){
                res = Math.max(res, stones+solve(i+x,n,Math.max(x,m),piles,1,memo));
                
            }
            else{
                res = Math.min(res,solve(i+x,n,Math.max(x,m),piles,0,memo));
            }
        }
        return memo[i][m][turn]= res;
    }
}