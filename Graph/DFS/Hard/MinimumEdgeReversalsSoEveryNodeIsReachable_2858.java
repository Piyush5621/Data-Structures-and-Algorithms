class Pair{
    int dest;
    int cost;
    Pair(int first,int second){
        dest=first;
        cost=second;
    }
}
class Solution {
    int tcc=0;
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(new Pair(v,0));
            adj.get(v).add(new Pair(u,1));
        }

        int depth[]=new int[n];
        boolean vist[]=new boolean[n];
        int edgesrev[]=new int[n];
        int revAns[]=new int[n];

        dfs(0,adj,edgesrev,depth,0,vist);
        revAns[0]=tcc;
        for(int i=1;i<n;i++){
            int v1=depth[i]-edgesrev[i];
            int v2=tcc-edgesrev[i];
            revAns[i]=v1+v2;
        }

        return revAns;

    }

    void dfs(int curr,List<List<Pair>>adj,int []edgesrev,int depth[],int d,boolean vist[]){
        vist[curr]=true;
        depth[curr]=d;

        for(Pair p: adj.get(curr)){
            int nbr=p.dest;
            int cost=p.cost;

            if(!vist[nbr]){
                edgesrev[nbr]=edgesrev[curr]+cost;
                tcc+=cost;
                dfs(nbr,adj,edgesrev,depth,d+1,vist);
            }

        }
    }
}