class Solution { 
    boolean vis[][];
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis=  new boolean[n][m];
        int ans = 0;
        for( int i = 0; i < n ; i++ ){
            for( int j = 0; j < m ; j++ ){
                if(!vis[i][j] && grid[i][j] == 1){
                    ans += solve(i,j,grid);
                }
            }
        }
        return ans;
    }
    private int solve( int i , int j , int grid[][]){
        if( i >= grid.length|| j>= grid[0].length || i<0 || j<0 ){
            return 1;
        }
        if(vis[i][j]) return 0;

        if(grid[i][j] == 0) return 1;

        vis[i][j]= true;

        return solve(i+1,j,grid)+ solve(i,j+1,grid)+ solve(i-1,j,grid)+ solve(i,j-1,grid);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna