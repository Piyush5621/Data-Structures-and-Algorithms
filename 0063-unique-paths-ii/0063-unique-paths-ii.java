class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int memo[][] = new int[m][n];
        for( int arr[] : memo ) Arrays.fill(arr, -1);
        return solve(0,0,obstacleGrid,memo);
    }
    private int solve(int i , int j, int arr[][], int memo[][]){
        if(i >= arr.length || j>= arr[0].length || arr[i][j]==1 ){
            return 0;
        }

        if(i ==arr.length-1 && j == arr[0].length-1) return 1;

        if(memo[i][j] != -1) return memo[i][j];

        memo[i][j] = solve(i+1,j , arr,memo)+solve(i,j+1,arr,memo);

        return memo[i][j];
    }
}