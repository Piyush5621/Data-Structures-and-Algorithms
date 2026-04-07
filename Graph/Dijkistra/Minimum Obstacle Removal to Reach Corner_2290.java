class Pair{
    int r;
    int c;
    int obs;
    Pair(int a,int b,int d){
        this.r=a;
        this.c=b;
        this.obs=d;
    }
}
class Solution {
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.obs-b.obs);
        visited[0][0]=true;
        pq.add(new Pair(0,0,grid[0][0]));
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int or=p.r;
            int oc=p.c;
            int os=p.obs;
            if(or==n-1 && oc==m-1){
                return os;
            }
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        pq.add(new Pair(nr,nc,os+grid[nr][nc]));
                    }
                }
            }
        }
        return -1;

    }
}