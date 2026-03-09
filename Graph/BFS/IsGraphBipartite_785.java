package BFS;
class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q=new LinkedList<>();
        int col[]=new int[graph.length];
        Arrays.fill(col,-1);
        col[0]=1;
        for(int i=0;i<graph.length;i++){
            q.add(i);
            while(!q.isEmpty()){
                int curr=q.poll();
                for(int nbr: graph[curr]){
                    if(col[nbr]==-1){
                        col[nbr]=1-col[curr];
                        q.add(nbr);
                    } 
                    if(col[nbr]==col[curr]){
                        return false;
                    }  
                }
            }   
        }
        return true;
    }
}