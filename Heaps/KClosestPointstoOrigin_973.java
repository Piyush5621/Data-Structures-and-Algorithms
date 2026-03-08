class Solution {
    static class Pair{
        int r;
        int c;
        int dist;
        Pair(int a,int b){
            r=a;
            c=b;
            this.dist=r*r+c*c;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> a.dist-b.dist
        );
        for(int i=0;i<points.length;i++){
            pq.add(new Pair(points[i][0],points[i][1]));
        }
        int ans[][]=new int[k][2];
        int m=0;
        while(m<k && !pq.isEmpty()){
            Pair p=pq.poll();
            ans[m][0]=p.r;
            ans[m][1]=p.c;
            m++;
        }
        return ans;
    }
}