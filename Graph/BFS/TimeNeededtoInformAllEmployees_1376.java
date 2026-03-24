
// One more solution with Dijkstra but With bfs only it is more optimized

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                adj.get(manager[i]).add(i);
            }
        }
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{headID,informTime[headID]});
        int maxm=informTime[headID];
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int t=curr[1];
            maxm=Math.max(maxm,t);
            for(int nbr: adj.get(curr[0])){
                q.offer(new int[]{nbr,t+informTime[nbr]}); 
            }
        }
        return maxm;
        
    }
}