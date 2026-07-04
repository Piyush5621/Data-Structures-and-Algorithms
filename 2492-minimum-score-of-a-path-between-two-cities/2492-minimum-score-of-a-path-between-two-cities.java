class Solution {
    class Pair{
        int node;
        int wght;
        Pair(int a,int b){
            node = a;
            wght = b;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int arr[] : roads){
            int u = arr[0]-1;
            int v = arr[1]-1;
            int w = arr[2]; 
            adjList.get(u).add(new Pair(v,w));
            adjList.get(v).add(new Pair(u,w));
        }

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(Pair nbr : adjList.get(curr)){
                int minm = Math.min(nbr.wght,dist[curr]);
                if(minm < dist[nbr.node]){
                    dist[nbr.node] = minm;
                    q.add(nbr.node);
                }
            }
        }

        return dist[n-1];

    }
}