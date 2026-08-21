class Solution {
    int mod = 1000000007;
    public int countRestrictedPaths(int n, int[][] edges) {
        HashMap<Integer,List<int[]>> map =  new HashMap<>();

        for( int arr[] :  edges ){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            if(!map.containsKey(u)){
                map.put(u,new ArrayList<>());
            }
            if(!map.containsKey(v)){
                map.put(v,new ArrayList<>());
            }
            map.get(u).add(new int[]{v,w});
            map.get(v).add(new int[]{u,w});
        } 

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        dist[n] = 0;

        pq.add(new int[]{n, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node]) continue;
            for (int[] arr : map.get(node)) {
                int nbr = arr[0];
                int weight = arr[1];

                if (dist[nbr] > dist[node] + weight) {
                    dist[nbr] = dist[node] + weight;
                    pq.add(new int[]{nbr, dist[nbr]});
                }
            }
        }
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        return solve(1, n,dist,memo,map);
    }

    private int solve(int curr, int last, int dist[], int memo[],HashMap<Integer,List<int[]>> map){
        if(curr == last) return 1;

        if(memo[curr]!=-1) return memo[curr];

        long count = 0;
        for( int arr[] : map.get(curr) ){
            if(dist[arr[0]] < dist[curr]){
                count += solve(arr[0] , last, dist,memo,map);
                count = count % mod;
            }
        }
        
        return memo[curr] = (int)count;
    }
}