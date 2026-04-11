class Solution {
    int rr[] = new int[]{-1,0,1,0};
    int cc[] = new int[]{0,1,0,-1};
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int noz = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 || grid[i][j]==1 || grid[i][j]==2){
                    noz++;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    return rec(i,j,grid,visited,noz ,0);
                }
            }
        }
        return -1;
    }
    int rec(int r, int c, int grid[][], boolean visited[][], int noz,int cnt){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || visited[r][c] || grid[r][c]==-1 ){
            return 0;
        }

        if(grid[r][c] == 2 ){
            if(cnt==noz-1){
                return 1;
            }
            return 0;
        }
        int count = 0;
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + rr[i];
            int nc = c + cc[i];
            count+=rec(nr,nc,grid,visited ,noz,cnt+1);
        }
        visited[r][c] = false;
        return count;
    }
}