class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int sum = 0;

        for(int i= 0; i< n ; i++){
            sum += mat[i][i];
            sum += mat[i][n-i-1];
        }
        if(n%2==1){
            return sum - mat[n/2][n/2];
        }
        return sum;
    }
}