class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if( m > n ) return 0;
        int memo[][] = new int[n][m];
        for( int arr[] : memo) Arrays.fill(arr, -1);
        return solve( 0,0, s, t ,memo);
    }

    private int solve( int i ,int j, String s, String t, int memo[][]){
        if( j == t.length() ) return 1;
        if( i >= s.length() ) return 0;
        if( memo[i][j] != -1 ) return memo[i][j];
        int take = 0;
        if( s.charAt(i)== t.charAt(j) ){
            take += solve( i+1, j+1, s,t, memo);
        }
        int skip = solve( i+1,j, s,t,memo);
        memo[i][j] = take + skip;
        return memo[i][j]; 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna