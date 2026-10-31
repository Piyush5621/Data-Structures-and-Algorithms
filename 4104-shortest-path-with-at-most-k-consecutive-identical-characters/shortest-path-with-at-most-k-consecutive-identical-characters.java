class Solution {
    class pair{
        int node;
        int d;
        int cons;
        pair(int a, int d, int cons){
            this.node = a;
            this.d = d;
            this.cons = cons;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
        List<List<int[]>> adj = new ArrayList<>(); 

        for( int i = 0; i < n; i++ ) adj.add( new ArrayList<>());

        for( int arr[] :  edges ){
            adj.get(arr[0]).add( new int[]{arr[1],arr[2]});
        }

        int dist[][] = new int[n][k+1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.d, b.d)
        );
        pq.offer(new pair( 0, 0, 1));
        dist[0][1] = 0;

        while( !pq.isEmpty() ){
            pair curr = pq.poll();

            int u = curr.node;
            int dis = curr.d;
            int cons = curr.cons;

            if (dis > dist[u][cons]) continue;

            if( u == n-1 ) return dis;

            for( int nodes[] : adj.get(u)){
                int v = nodes[0];
                int w = nodes[1];

                int newCons = 1;
                if(labels.charAt(u) == labels.charAt(v)){
                    newCons = cons + 1;
                }
                int newDist = dis + w ;
                if(newCons <= k && newDist < dist[v][newCons] ){
                    pq.offer(new pair(v,newDist, newCons));
                    dist[v][newCons] = newDist;  
                } 
            }
        }
        return -1;

    }
}