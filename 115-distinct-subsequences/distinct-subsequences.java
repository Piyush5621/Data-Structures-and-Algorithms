class Solution {
    int memo[][];
    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for(int arr[] :  memo ){
            Arrays.fill(arr ,-1);
        }
        return solve(s, t, 0, 0);
    }

    public int solve(String s, String t, int i, int j) {
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }

        if(memo[i][j]!=-1) return memo[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return memo[i][j] = solve(s, t, i+1, j+1) + solve(s, t, i+1, j);
        }

        return memo[i][j]=solve(s, t, i+1, j);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna