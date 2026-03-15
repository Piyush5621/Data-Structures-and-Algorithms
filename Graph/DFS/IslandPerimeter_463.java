
class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return dfs(grid,vis,i,j);
                }   
            }
        }
        return -1;
    }

    static int dfs(int grid[][],boolean [][]vis,int r,int c){
        if(r<0 || r>=grid.length|| c<0 || c>=grid[0].length){
            return 1;
        }
        if(grid[r][c]==0) return 1;
        if(vis[r][c]) return 0;

        vis[r][c]=true;
        return dfs(grid,vis,r+1,c)+dfs(grid,vis,r-1,c)+dfs(grid,vis,r,c+1)+dfs(grid,vis,r,c-1);
    }
}