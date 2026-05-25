class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        int maxm=0;
        for(int i=0;i<n;i++){
            maxm=Math.max(maxm,solve(i,arr,d,dp));
        }
        return maxm;

    }
    int solve(int idx,int arr[],int d, int dp[]){
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=1;
        for(int i=idx+1;i<arr.length && i<=idx+d;i++){
            if(arr[i]>=arr[idx]) break;
            ans = Math.max(ans,1+solve(i,arr,d,dp));
        }
        for(int i=idx-1;i>=0 &&idx-d<=i;i--){
            if(arr[i]>=arr[idx]) break;
            ans = Math.max(ans,1+solve(i,arr,d,dp));
        }
        dp[idx]=ans;
        return dp[idx];
    }
}