class Solution {
    Boolean memo[][];
    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n+1][2];
        return solve(n,0);
    }

    private boolean solve( int n , int turn ){
        if( n == 0 ){
            if(turn ==0) return false;
            return true;
        }

        if(memo[n][turn]!=null){
            return memo[n][turn];
        }
        if(turn == 0){
            for( int i = 1; i*i <= n; i++){
                if(solve(n-(i*i),1)){
                    return memo[n][turn]=true;
                }
            }
            return memo[n][turn]=false;
        }
        else{
            for( int i = 1; i*i <= n; i++){
                if(!solve(n-(i*i),0)){
                    return memo[n][turn] = false;
                }
            }
            return memo[n][turn] = true;
        }
    }
}