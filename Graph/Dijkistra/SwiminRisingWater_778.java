class Triple{
    int r;
    int c;
    int dist;
    Triple(int a,int b,int c){
        this.r=a;
        this.c=b;
        this.dist=c;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Triple> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        boolean vist[][]=new boolean [n][m];
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        pq.add(new Triple(0,0,grid[0][0]));
        vist[0][0]=true;
        while(!pq.isEmpty()){
            Triple t=pq.poll();
            int or=t.r;
            int oc=t.c;
            int dist=t.dist;
            if(or==n-1 && oc==m-1){
                return dist;
            }
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vist[nr][nc]){
                    int newdist=Math.max(dist,grid[nr][nc]);
                    vist[nr][nc]=true;
                    pq.add(new Triple(nr,nc,newdist));
                }
            }
        }

        return 0;

    }
}