class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adjList.add(new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }  
        }
        List<List<Integer>> ans=new ArrayList<>();
        boolean vis[]=new boolean[n];
        dfs(adjList,ans,0,n,new ArrayList<>(),vis);
        return ans;
    }

    void dfs(List<List<Integer>> adjList, List<List<Integer>>ans,int i,int n,List<Integer> temp,boolean []vis){
        temp.add(i);
        vis[i]=true;
        if(i==n-1){
            ans.add(new ArrayList<>(temp));
        }
        for(int x: adjList.get(i)){
            if(!vis[x]){
                dfs(adjList,ans,x,n,temp,vis);
            }
        }
        temp.remove(temp.size()-1);
        vis[i]=false;
    }
}