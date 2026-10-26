class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < m; j++ ){
                if( grid[i][j] != 0 ){
                    ans += ((dfs( i, j, grid)%k == 0) ? 1 : 0);
                } 
            }
        }
        return ans;
    }


    private long dfs( int i , int j , int grid[][]){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0){
            return 0;
        }
        int x = grid[i][j];
        grid[i][j] = 0;
        long sum = x ;
        return sum +  dfs(i+1, j , grid) + dfs(i, j+1, grid) +  dfs(i-1, j,grid) + dfs(i,j-1,grid);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna