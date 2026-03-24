
// One more solution with Dijkstra but With bfs only it is more optimized

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                adj.get(i).add(new int[]{manager[i],informTime[i]});
                adj.get(manager[i]).add(new int[]{i,informTime[i]});
            }
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[headID]=informTime[headID];
        Queue<Integer> q=new ArrayDeque<>();
        q.add(headID);
        while(!q.isEmpty()){
            int curr=q.poll();
            int ot=dist[curr];
            for(int[] p: adj.get(curr)){
                int nbr=p[0];
                int time=p[1];
                if(ot+time<dist[nbr]){
                    dist[nbr]=ot+time;
                    q.offer(nbr);
                }
            }
        }
        int maxm=-1;
        for(int x: dist) System.out.println(x);
        for(int i=0;i<n;i++) maxm=Math.max(maxm,dist[i]);
        return (maxm==Integer.MAX_VALUE)?  informTime[headID] : maxm;
        
    }
}