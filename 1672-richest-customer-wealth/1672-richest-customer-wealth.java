class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        int n = accounts.length;
        int m = accounts[0].length;
        for(int i=0; i<n; i++){
            int curr = 0;
            for(int j=0; j<m; j++){
                curr+=accounts[i][j];
            }
            ans=Math.max(ans,curr);
        }

        return ans;
    }
}