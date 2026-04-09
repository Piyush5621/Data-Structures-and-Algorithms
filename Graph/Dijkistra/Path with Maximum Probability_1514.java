class pair{
    int d;
    double p;
    pair(int a,double b){
        d=a;
        p=b;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int i=0;
        for(int arr[] : edges){
            int u=arr[0];
            int v=arr[1];
            double prob=succProb[i++];
            adj.get(u).add(new pair(v,prob));
            adj.get(v).add(new pair(u,prob));
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a, b) -> Double.compare(b.p, a.p));
        pq.add(new pair(start_node,1.0));
        double dist[]=new double[n];
        Arrays.fill(dist,Double.MIN_VALUE);
        dist[start_node]=1.0;
        while(!pq.isEmpty()){
            pair p= pq.poll();
            int curr=p.d;
            double cp=p.p;
            if(curr==end_node){
                return cp;
            }
            for(pair nbr : adj.get(curr)){
                int next=nbr.d;
                double np=nbr.p;
                if(dist[next]<cp*np){
                    pq.add(new pair(next,cp*np));
                    dist[next]=cp*np;
                }
            }
        }
        return 0;
    }
}