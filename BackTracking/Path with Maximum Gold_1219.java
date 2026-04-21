class Solution {
    
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int maxm = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]!=0){
                    maxm=Math.max(maxm,rec(i,j,grid,visited));
                }
            }
        }
        return maxm;
    }

    int rec(int r, int c, int grid[][], boolean[][] visited){
        if(r<0 || c<0 || r>=grid.length || c>= grid[0].length || visited[r][c] || grid[r][c]==0 ){
            return 0;
        }
        visited[r][c] =true;
        int res = grid[r][c] + Math.max(rec(r+1,c,grid,visited),Math.max(rec(r-1,c,grid,visited),Math.max(rec(r,c+1,grid,visited), rec(r,c-1,grid,visited))));
        visited[r][c] =false;
        return res;
    }
}