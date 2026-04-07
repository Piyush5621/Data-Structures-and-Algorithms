class Edges implements Comparable <Edges>{
    int x, y,wt;
    Edges(int x,int y,int wt){
        this.x=x;
        this.y=y;
        this.wt=wt;
    }
    public int compareTo(Edges e){
        return this.wt-e.wt;
    }
}
class Solution {
    int par[];
    int rank[];
    class DSU{
        DSU(int n){
            par=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) par[i]=i;
        }

        int find(int x){
            if(par[x]==x) return par[x];
            return par[x]=find(par[x]);
        }

        void union(int a,int b){
            int ref_a=find(a);
            int ref_b=find(b);

            if(rank[ref_a]<rank[ref_b]){
                par[ref_a]=ref_b;
            }
            else if(rank[ref_a]> rank[ref_b]){
                par[ref_b]=ref_a;
            }
            else{
                par[ref_b]=ref_a;
                rank[ref_a]++;
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<Edges> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int cost =Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.add(new Edges(i,j,cost));
            }
        }
        DSU dsu=new DSU(n);
        Collections.sort(adj);
        int totalcost=0;
        for(Edges e : adj ){
            int x= e.x;
            int y=e.y;
            int wt=e.wt;

            if(dsu.find(x)!=dsu.find(y)){
                dsu.union(x,y);
                totalcost+=wt;
            }
        }
        return totalcost;

    }
}