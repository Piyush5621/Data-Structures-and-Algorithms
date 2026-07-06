class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int i=n-1,j=0;
        int ans=0;
        while(i>=0 && j<m){
            if(grid[i][j]<0){
                ans+=(m-j);
                i--;

            }
            else{
                j++;
            }
        }
        return ans;
    }
}