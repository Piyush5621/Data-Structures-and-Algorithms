class Pair{
    int child;
    int color;    // 0-> red and 1-> blue
    int dist;
    Pair(int child,int color,int dist){
        this.child = child;
        this.color = color;
        this.dist=dist;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int arr[] : redEdges){
            adj.get(arr[0]).add(new Pair(arr[1],0,0));
        }
        for(int arr[] : blueEdges){
            adj.get(arr[0]).add(new Pair(arr[1],1,0));
        }
        Queue<Pair> q = new ArrayDeque<>();
        int answer[] = new int[n];
        Arrays.fill(answer,Integer.MAX_VALUE);
        q.offer(new Pair(0,0,0));
        q.offer(new Pair(0,1,0));
        boolean visited[][] = new boolean[n][2];
        visited[0][0]=true;
        visited[0][1]=true;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int curr= p.child;
            int currc=p.color;
            int dist=p.dist;
            for( Pair x : adj.get(curr) ){
                    if(x.color!=currc && !visited[x.child][x.color] ){
                        visited[x.child][x.color]=true;
                        if(answer[x.child]==Integer.MAX_VALUE){
                            answer[x.child]=dist+1;
                        }
                        q.offer(new Pair(x.child,x.color,dist+1));
                    }
            }  
        }
        answer[0]=0;
        for(int i=1;i<n;i++){
            if(answer[i]==Integer.MAX_VALUE) answer[i]=-1;
        } 
        return answer;  
    }
}