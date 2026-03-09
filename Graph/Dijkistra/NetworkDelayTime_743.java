class Pair{
    int node;
    int dist;
    Pair(int a,int b){
        node=a;
        dist=b;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adjList.get(times[i][0]-1).add(new Pair(times[i][1]-1,times[i][2]));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
        pq.add(new Pair(k-1,0));
        dist[k-1]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int nod=p.node;
            int dis=p.dist;
            for(Pair pp: adjList.get(nod)){
                int newNode=pp.node;
                if(dist[newNode]>pp.dist+dis){
                    dist[newNode]=pp.dist+dis;
                    pq.add(new Pair(newNode,dist[newNode]));
                }
            }
        }
        int maxm=0;
        for(int x:dist) maxm=Math.max(maxm,x);
        return (maxm==Integer.MAX_VALUE)? -1 : maxm;

    }
}