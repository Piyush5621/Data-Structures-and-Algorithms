class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int ans[][] = new int[r][c];
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c) return mat;
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = i*n+j;
                ans[idx/c][idx%c] = mat[i][j];
            }
        }
        return ans;
    }
}