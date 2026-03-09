package DFS;
class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !vist[i][j]){
                    if(dfs(grid,vist,i,j)%k==0) count++;
                }
            }
        }
        return count;
    }

    static long dfs(int [][]grid , boolean [][]vis,int r,int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length) return 0;
        if(vis[r][c]) return 0;
        if(grid[r][c]==0) return 0; 
        vis[r][c]=true;
        return grid[r][c]+dfs(grid,vis,r+1,c)+dfs(grid,vis,r-1,c)+dfs(grid,vis,r,c+1)+dfs(grid,vis,r,c-1);

    }
}