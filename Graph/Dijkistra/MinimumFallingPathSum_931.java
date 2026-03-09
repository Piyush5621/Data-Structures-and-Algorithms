class Pair{
    int a;
    int b;
    int d;
    Pair(int a,int b,int d){
        this.a=a;
        this.b=b;
        this.d=d;
    }
}
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rr[]=new int[]{1,1,1};
        int cc[]=new int[]{-1,0,1};
        int n=matrix.length;
        int m=matrix[0].length;
        int dist[][]=new int[n][m];
        for(int arr[]: dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            dist[0][i]=matrix[0][i];
            q.add(new Pair(0,i,matrix[0][i]));
            while(!q.isEmpty()){
                Pair p=q.poll();
                int r=p.a;
                int c=p.b;
                int dis=p.d;
                for(int j=0;j<3;j++){
                    int nr=r+rr[j];
                    int nc=c+cc[j];

                    if(nr>=0 && nr<n&& nc>=0 && nc<m && dis+matrix[nr][nc]<dist[nr][nc]){
                        dist[nr][nc]=dis+matrix[nr][nc];
                        q.add(new Pair(nr,nc,dis+matrix[nr][nc]));
                    }
                }      
            }
        }

        int minm=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minm=Math.min(minm,dist[n-1][i]);
        }
        return minm;
    }
}