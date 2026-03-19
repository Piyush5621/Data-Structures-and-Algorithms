class Triple{
    int r;
    int c;
    int dis;
    Triple(int r,int c,int dis){
        this.r=r;
        this.c=c;
        this.dis=dis;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<Triple>q=new ArrayDeque<>();
        int dist[][]=new int[n][n];
        for(int a[]: dist) Arrays.fill(a,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Triple(i,j,0));
                    dist[i][j]=0;
                }
            }
        }
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        int maxm=-1;
        while(!q.isEmpty()){
            Triple t=q.poll();
            int or=t.r;
            int oc=t.c;
            int od=t.dis;

            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<n && od+1<dist[nr][nc] && grid[nr][nc]==0){
                    dist[nr][nc]=od+1;
                    q.add(new Triple(nr,nc,od+1));
                    maxm=Math.max(maxm,dist[nr][nc]);
                }
            }

        }
        return maxm;
    }
}