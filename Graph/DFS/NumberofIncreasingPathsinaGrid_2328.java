class Solution {
    static int mod=1000000007;
    static int rr[]=new int[]{-1,0,1,0};
    static int cc[]=new int[]{0,1,0,-1};
    public int countPaths(int[][] grid) {
        int maxm=Integer.MIN_VALUE;
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int a[]: dp) Arrays.fill(a,-1);
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               total=(total+dfs(i,j,grid,dp))%mod;
            }
        }
        return total;
    }
    static int dfs(int r,int c,int [][]grid,int dp[][]){

        if(dp[r][c]!=-1) return dp[r][c];
        int path=1;
        for(int i=0;i<4;i++){
            int nr=r+rr[i];
            int nc=c+cc[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[r][c]<grid[nr][nc]){
                path=(path+dfs(nr,nc,grid,dp))%mod;
            }
        }
        dp[r][c]=path;
        return dp[r][c];
    }
}