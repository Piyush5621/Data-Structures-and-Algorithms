class Pair{
    int f;
    int s;
    Pair(int a,int b){
        f=a;
        s=b;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int maxm=Integer.MAX_VALUE;
        int ans=0;
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis,Integer.MAX_VALUE);
            int cnt=dijkistra(i,adjList,dis,distanceThreshold,n);
            if(maxm>=cnt){
                maxm=cnt;
                ans=i;
            }
        }
        return ans;
    }

    static int dijkistra(int src,List<List<Pair>> adj,int dis[],int k,int n){
        int c=0;
        dis[src]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)-> a.s-b.s);
        q.add(new Pair(src,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node =p.f;
            int dist=p.s;

            for(Pair nbr: adj.get(node)){
                if(dist+nbr.s<dis[nbr.f]){
                    dis[nbr.f]=dist+nbr.s;
                    q.add(new Pair(nbr.f,dist+nbr.s));
                }
            }
        }
        for(int i=0;i<n;i++){
            if(i!=src && dis[i]<=k){
                c++;
            }  
        }

        return c;
    }
}