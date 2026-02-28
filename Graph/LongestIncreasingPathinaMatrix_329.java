// 1st Solution
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=dfs(i,j,matrix,dist,n,m);
            }
        }
        int maxm=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxm=Math.max(maxm,dist[i][j]);
            }
        }

        return maxm;
    }

    static int dfs(int r,int c,int [][]matrix,int [][]dist,int n,int m){
        
        if(dist[r][c] != 0) return dist[r][c];
        int maxlen=1;
        if(r+1<n && matrix[r+1][c]>matrix[r][c]){
            maxlen=Math.max(maxlen,1+dfs(r+1,c,matrix,dist,n,m)); 
        }
        if( r-1>=0 && matrix[r-1][c]>matrix[r][c]){
            maxlen=Math.max(maxlen,1+dfs(r-1,c,matrix,dist,n,m));     
        }
        if(c+1<m&& matrix[r][c+1]>matrix[r][c]){
           maxlen=Math.max(maxlen,1+dfs(r,c+1,matrix,dist,n,m));  
        }
        if( c-1>=0 && matrix[r][c-1]>matrix[r][c]){
            maxlen=Math.max(maxlen,1+dfs(r,c-1,matrix,dist,n,m)); 
        }
        dist[r][c]=maxlen;
        return maxlen;
    }
}


// 2nd Solution