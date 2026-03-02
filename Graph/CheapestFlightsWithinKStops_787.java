class Pair{
    int a;
    int dist;
    Pair(int a,int b){
        this.a=a;
        this.dist=b;
    }
}
class Triple{
    int d;
    int node;
    int stops;
    Triple(int d,int node,int stops){
        this.d=d;
        this.node=node;
        this.stops=stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int f=flights[i][0];
            int s=flights[i][1];
            int t=flights[i][2];
            adjList.get(f).add(new Pair(s,t));
        }
        int distt[]=new int[n];
        Arrays.fill(distt,Integer.MAX_VALUE);
        distt[src]=0;
        Queue<Triple>pq=new LinkedList<>();
        pq.add(new Triple(0,src,0));

        while(!pq.isEmpty()){
            Triple t=pq.poll();
            int d=t.d;
            int s=t.node;
            int st=t.stops;
            for(Pair p: adjList.get(s)){
                int v=p.a;
                int dd=p.dist;
                if(st<=k && dd+d<distt[v]){
                    distt[v]=dd+d;
                    pq.add(new Triple(distt[v],v,st+1));
                }
                
            }
        }

        return distt[dst]==Integer.MAX_VALUE ? -1: distt[dst];

    }
}