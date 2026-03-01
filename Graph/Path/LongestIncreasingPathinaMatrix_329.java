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

class Pair{
    int a;
    int b;
    Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int dist[][]=new int[n][m];
        List<List<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n*m;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int curr=i*m+j;
                List<Integer> ad=new ArrayList<>();
                for(int k=0;k<4;k++){
                    int nr=i+dr[k];
                    int nc=j+dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && matrix[i][j]<matrix[nr][nc] ){
                        adjList.get(curr).add(new Pair(nr,nc));
                    }
                }  
            }
        }
        int maxm=1;

        for(int i=0;i<n*m;i++){
            maxm=Math.max(maxm,dfs(i,adjList,dist,m));
        }
        return maxm;
    }

    static int dfs(int src,List<List<Pair>> adjList,int dist[][],int m){
        int r=src/m;
        int c=src%m;
        if(dist[r][c]!=0) return dist[r][c];
        int maxlen=1;
        for(Pair p: adjList.get(src)){
            int nr=p.a;
            int nc=p.b;
            int nbr=nr*m+nc;
            maxlen=Math.max(maxlen,1+dfs(nbr,adjList,dist,m));
        }
        dist[r][c]=maxlen;
        return maxlen;
    }
}