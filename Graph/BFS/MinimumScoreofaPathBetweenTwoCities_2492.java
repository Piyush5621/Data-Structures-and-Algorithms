class Pair{
    int node;
    int distt;
    Pair(int a,int b){
        node = a;
        distt = b;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        int ans=Integer.MAX_VALUE;
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int arr[] : roads){
            int u = arr[0];
            int v = arr[1];
            int dist = arr[2];
            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }
        Queue<Pair> q = new ArrayDeque<>();
        boolean visited[] = new boolean[n+1];
        q.offer(new Pair(1,Integer.MAX_VALUE));
        visited[1]=true;
        while( !q.isEmpty() ){
            Pair p =q.poll();
            int curr = p.node;
            int dist = p.distt;
            ans = Math.min(ans,dist);
            for(Pair nbr : adj.get(curr) ){
                if(!visited[nbr.node]){
                    q.add(new Pair(nbr.node, nbr.distt));
                    visited[nbr.node]=true;
                }
                else{
                    ans = Math.min(ans, nbr.distt);
                }
            }
        }
        return ans;
    }
}