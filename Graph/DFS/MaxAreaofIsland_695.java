class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] vist=new boolean[n][m];
        int maxm=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    maxm=Math.max(maxm,dfs(i,j,grid,vist));
                }
            }
        }

        return maxm;

    }

    int dfs(int i,int j,int[][] grid ,boolean vist[][]){
        if(i<0 || j<0 || i>=grid.length|| j>=grid[0].length|| grid[i][j]==0 || vist[i][j]==true){
            return 0;
        }
        vist[i][j]=true;
        return 1+dfs(i+1,j,grid,vist)+dfs(i-1,j,grid,vist)+dfs(i,j+1,grid,vist)+dfs(i,j-1,grid,vist);
    }
}