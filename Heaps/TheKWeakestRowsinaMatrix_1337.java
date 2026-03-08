class Pair{
    int a;
    int b;
    Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int ans[]=new int[k];
        int n=mat.length;
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->{
            if(x.b!=y.b) return x.b-y.b;
            return x.a-y.a; });
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<mat[0].length;j++){
                c+=(mat[i][j]==1? 1:0);
            }
            pq.add(new Pair(i,c));
        }
        int m=0;
        while(m<k){
            ans[m++]=pq.poll().a;
        }
        return ans;
    }
}