class Solution {
    int memo[];
    public int maxPalindromes(String s, int k) {
        int n = s.length(); 
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solve(0, s, k);
    }
    private int solve(int idx, String s, int k){
        if(idx >= s.length()) return 0;

        if(memo[idx] != -1 ) return memo[idx];

        int ans = solve(idx+1, s, k);
        for( int i = idx+k-1  ; i < s.length(); i++){
            if(checkPalindrome(idx, i, s)){
                ans = Math.max(ans, 1+ solve(i+1,s,k));
                return memo[idx] = ans;
            }
        }
        return memo[idx]=ans;

    }
    private boolean checkPalindrome(int st, int end, String str){
        while( st < end ){
            if( str.charAt(st) != str.charAt(end) ){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna