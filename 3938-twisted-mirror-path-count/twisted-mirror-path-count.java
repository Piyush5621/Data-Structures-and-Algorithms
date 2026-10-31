class Solution {
    int mod = 1000000007;
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int memo[][][] = new int[n][m][2];

        for (int[][] arrr : memo) {
            for (int[] arr : arrr) {
                Arrays.fill(arr, -1);
            }
        }
        return solve(0,0, grid, memo, 0);
    }

    private int solve( int i, int j , int [][] grid, int [][][] memo, int right){
        if( i == grid.length - 1 && j == grid[0].length-1 ) return 1;
        if( i >= grid.length || j >=grid[0].length) return 0;
        if( memo[i][j][right] != -1 ) return memo[i][j][right];
        if( grid[i][j] == 1 ){
            int curr  = 0;
            if(right == 0) curr += solve(i,j+1,grid, memo,1);
            else curr += solve(i+1,j,grid, memo,0);
            return memo[i][j][right] = curr % mod;  
        }
        return memo[i][j][right] = (solve(i+1,j,grid, memo,0) + solve(i,j+1,grid, memo,1))%mod;
    }
}