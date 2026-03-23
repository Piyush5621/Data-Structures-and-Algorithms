class Solution {
    int cnt1=0;
    int cnt2=0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt=0;
        int n=grid1.length;
        int m=grid1[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1){
                    cnt1=0;
                    cnt2=0;
                    dfs(i,j,grid1,grid2);
                    if(cnt1==cnt2){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
    void dfs(int r,int c,int grid1[][],int grid2[][]){
        if(r<0 || r>=grid1.length || c<0 || c>=grid1[0].length || grid2[r][c]!=1 ){
            return;
        }
        if(grid1[r][c]==1){
            cnt1++;
        }
        if(grid2[r][c]==1){
            cnt2++;
        }
        grid2[r][c]=2;
        dfs(r+1,c,grid1,grid2);
        dfs(r-1,c,grid1,grid2);
        dfs(r,c+1,grid1,grid2);
        dfs(r,c-1,grid1,grid2);
    }
}