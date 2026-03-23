class Pair{
    int r;
    int c;
    int time;
    Pair(int a,int b,int t){
        r=a;
        c=b;
        time=t;
    }
}
class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[1][0]>1 && grid[0][1]>1) return -1;
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.time-b.time);
        int dist[][]=new int[n][m];
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        for(int a[]: dist) Arrays.fill(a,Integer.MAX_VALUE);
        pq.offer(new Pair(0,0,0));
        dist[0][0]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int or=p.r;
            int oc=p.c;
            int ot=p.time;
            if(or==n-1 && oc==m-1) return ot;
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                if(nr>=0 && nr<n && nc<m && nc>=0){
                    int nt=Math.max(ot+1,grid[nr][nc]);
                    if((nt-(ot+1))%2!=0) nt++;
                    if(nt<dist[nr][nc]){
                        dist[nr][nc]=nt;
                        pq.offer(new Pair(nr,nc,nt));
                    }
                }
            }
        }

        return -1;

    }
}