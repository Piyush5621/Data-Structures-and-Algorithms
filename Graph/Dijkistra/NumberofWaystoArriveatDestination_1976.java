class Triple{
    int node;
    long d;
    Triple(int a,long di){
        node=a;
        d=di;
    }
}
class Solution {
    int mod=1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<Triple>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adjList.get(roads[i][0]).add(new Triple(roads[i][1],roads[i][2]));
            adjList.get(roads[i][1]).add(new Triple(roads[i][0],roads[i][2]));
        }
        int ways[]=new int[n];
        ways[0]=1;
        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<Triple>pq=new PriorityQueue<>((a,b)-> Long.compare(a.d,b.d));
        pq.add(new Triple(0,0));
        int cnt=1;
        while(!pq.isEmpty()){
            Triple t=pq.poll();
            int curr=t.node;
            long od=t.d;
            if(od > dist[curr]) continue;
            for(Triple p: adjList.get(curr)){
                int newnode=p.node;
                long dis=p.d;
                long newdist=dis+dist[curr];
                if(dist[newnode]>newdist){
                    ways[newnode]=ways[curr];
                    dist[newnode]=newdist;
                    pq.add(new Triple(newnode,newdist));
                }
                else if(newdist==dist[newnode]){
                    ways[newnode]=(ways[newnode]+ways[curr])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}