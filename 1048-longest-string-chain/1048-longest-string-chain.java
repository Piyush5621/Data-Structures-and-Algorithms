class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int memo[][] = new int[n+1][n+1];
        Arrays.sort(words,(a,b) -> Integer.compare(a.length(),b.length()));
        for( int arr[] : memo ) Arrays.fill(arr, -1);
        return solve(0, words, memo, -1);
    }

    private int solve( int i , String[] words, int memo[][], int prev ){
        if( i >= words.length ) return 0;

        if( memo[i][prev+1] != -1) return memo[i][prev+1];

        int take = 0 ;

        if(prev ==-1 || checkPredecessor(words[prev],words[i])){
            take = 1 + solve(i+1, words, memo, i);
        }

        int skip = solve(i + 1, words, memo, prev);

        memo[i][prev+1] = Math.max(take, skip);
        return memo[i][prev+1]; 
    }
    private boolean checkPredecessor(String a,String b){
        if(a.length()+1 != b.length()) return false;
        int i = 0; 
        int j = 0;
        while(i < a.length() && j < b.length()){
            if(a.charAt(i) ==b.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i == a.length();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna