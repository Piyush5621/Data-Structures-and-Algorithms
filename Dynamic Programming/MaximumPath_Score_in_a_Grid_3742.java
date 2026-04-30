class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length; 
        int memo[][][] = new int[n][m][k+1];
        for(int arr[][] : memo){
            for(int ar[]: arr){
                Arrays.fill(ar,-1);
            }
        }
        int scost = (grid[0][0]==0)? 0 : 1;
        int ans=solve(0,0,scost,k,grid,memo);
        return (ans==Integer.MIN_VALUE)? -1:ans ;
    }

    int solve(int r,int c,int icost, int k,int [][]grid,int memo[][][]){
        if(r>=grid.length || c>=grid[0].length || icost>k){
            return Integer.MIN_VALUE;
        }

        if(r==grid.length-1 && c==grid[0].length-1){
            return grid[r][c];
        }

        if(memo[r][c][icost]!=-1){
            return memo[r][c][icost];
        }


        int down = (r + 1 < grid.length && grid[r + 1][c] != 0) ? 1 : 0;
        int right = (c + 1 < grid[0].length && grid[r][c + 1] != 0) ? 1 : 0;


        int score = Math.max(solve(r+1,c,icost+down,k,grid,memo),solve(r,c+1,icost+right,k,grid,memo));
        
        if(score==Integer.MIN_VALUE){
            return memo[r][c][icost]=Integer.MIN_VALUE;
        }

        memo[r][c][icost]=score+grid[r][c];
        return memo[r][c][icost];
    }

}