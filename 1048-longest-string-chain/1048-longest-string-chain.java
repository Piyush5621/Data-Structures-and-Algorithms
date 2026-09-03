class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b) -> Integer.compare(a.length(),b.length()));
        int dp[] = new int[n+1];
        Arrays.fill(dp, 1);
        int ans = -1;
        for( int i = 0; i < n ; i++ ){
            for( int j =i-1; j >= 0; j--){
                if(checkPredecessor(words[j],words[i])){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
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