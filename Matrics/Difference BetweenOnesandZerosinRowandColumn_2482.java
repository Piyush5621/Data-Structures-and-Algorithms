// 1st Approach 
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int diff[][]=new int[n][m];
        for(int i=0;i<n;i++){
            int z=0;
            int o=0;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    o++;
                }
                else{
                    z++;
                }
            }
            int val=o-z;
            for(int k=0;k<m;k++){
                diff[i][k]+=val;
            }
        }
        for(int i=0;i<m;i++){
            int z=0;
            int o=0;
            for(int j=0;j<n;j++){
                if(grid[j][i]==1){
                    o++;
                }
                else{
                    z++;
                }
            }
            int val=o-z;
            for(int k=0;k<n;k++){
                diff[k][i]+=val;
            }
        }
        return diff;
    }
}


// 2nd Approach\

