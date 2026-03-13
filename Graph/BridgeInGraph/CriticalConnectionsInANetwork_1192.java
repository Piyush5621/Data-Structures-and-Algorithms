class Solution {
    static int timer=1;
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> connections) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<connections.size();i++){
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int disc[]=new int[V];
        int low[]=new int[V];
        boolean isAp[]=new boolean[V];
        boolean vis[]=new boolean [V];
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,-1,adj,disc,low,isAp,vis,ans);
        return ans;
    }
    
    static void dfs(int u,int parent,List<List<Integer>> adj,int disc[],int low[],boolean[]isAp,boolean [] vis,List
    <List<Integer>> ans){
        vis[u]=true;
        disc[u]=low[u]=timer++;
        for(int v: adj.get(u)){ 
            if(!vis[v]){
                dfs(v,u,adj,disc,low,isAp,vis,ans);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>disc[u]){
                    ans.add(Arrays.asList(u,v));
                } 
            }
            else if(parent!=v){
                low[u]=Math.min(low[u],disc[v]);
            }  
        }
    }
}