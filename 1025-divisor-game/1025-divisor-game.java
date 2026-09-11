class Solution {
    public boolean divisorGame(int n) {
        Boolean memo[][] = new Boolean[n+1][2];
        return solve(n,0,memo);
    }
    private boolean solve(int n,int turn,Boolean[][] memo){

        if(n ==1 ){
            return turn == 1;
        }
        if(memo[n][turn] != null ) return memo[n][turn]; 

        if(turn == 0){
            for( int i = 1; i < n; i++){
                if( n % i == 0 ){
                    if(solve(n-i,1,memo)){
                        return memo[n][turn]=true;
                    }
                }
            }
            return memo[n][turn]=false;
        }
        else{
            for( int i = 1; i < n; i++){
                if( n % i == 0){
                    if(!solve(n-i,0,memo)){
                        return memo[n][turn] = false;
                    }
                } 
            }
            return memo[n][turn] = true;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna