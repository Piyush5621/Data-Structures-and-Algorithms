class Pair{
    int r;
    int c;
    int dif;
    Pair(int a,int b,int dif){
        this.r=a;
        this.c=b;
        this.dif=dif;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int diff[][]=new int[n][m];
        for(int arr[]: diff){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        diff[0][0]=0;
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.dif-b.dif);
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int or=p.r;
            int oc=p.c;
            int d=p.dif;
            if(or==n-1 && oc==m-1){
                return d;
            }
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m ){
                    int ad=Math.abs(heights[or][oc]-heights[nr][nc]);
                    int maxm=Math.max(ad,d);
                    if(maxm<diff[nr][nc]){
                        diff[nr][nc]=maxm;
                        pq.add(new Pair(nr,nc,maxm));
                    } 
                }
            }
        }

        return -1;


    }
}