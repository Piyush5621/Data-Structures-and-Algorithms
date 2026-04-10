class Pair{
    int r;
    int c;
    int cost;
    Pair(int r,int c,int cost){
        this.r=r;
        this.c=c;
        this.cost=cost;
    }
}
class Solution {
    public int minCost(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);
        int dist[][] = new int[n][m];
        for(int arr[] : dist) Arrays.fill(arr, Integer.MAX_VALUE);

        pq.add(new Pair(0,0,0));
        int rr[] = new int[]{0,0,1,-1};
        int cc[] = new int[]{1,-1,0,0};
        dist[0][0]=0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int or = p.r;
            int oc = p.c;
            int ocost = p.cost;
            if(or == n-1 && oc == m-1){
                return ocost;
            }
            for(int i=1;i<=4;i++){
                int nr = or+rr[i-1];
                int nc = oc+cc[i-1];
                if(nr>=0 && nc>=0 && nr< n && nc < m){
                    int newcost= (i!=grid[or][oc]) ? ocost+1: ocost;
                    if(newcost < dist[nr][nc]){
                        dist[nr][nc]=newcost;
                        pq.add(new Pair(nr,nc,newcost));
                    }
                }

            }
        }
        return 0;
    }
}