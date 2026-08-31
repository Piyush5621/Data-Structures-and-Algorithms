class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)-> Integer.compare(a[1], b[1]));
        int n  = pairs.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for( int i = 1; i < n ; i++){
            for( int j = i-1;j>=0; j--){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxm = 1;
        for( int x : dp) maxm = Math.max(x, maxm);
        return maxm;
    }
}