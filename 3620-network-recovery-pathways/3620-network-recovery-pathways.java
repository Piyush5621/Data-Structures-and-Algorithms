class Solution {
    class Pair{
        int node;
        long weight;
        Pair(int a, long b){
            node = a;
            weight = b;
        }
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        List<List<Pair>> adjList = new ArrayList<>();
        if (!online[0] || !online[online.length - 1]) return -1;
        int n = online.length;
        for(int i=0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int arr[] : edges){
            int u = arr[0];
            int v = arr[1];
            long w = arr[2];
            adjList.get(u).add(new Pair(v, w));
        }

        int low = 0;
        int high = 0;

        for(int arr[] :  edges){
            high = Math.max(arr[2],high);
        }
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;

            if(check(adjList,online,mid,k)){
                ans = mid;
                low = mid+1;
            }
            else{
                high= mid-1;
            }
        }

        return ans;


    }

    boolean check(List<List<Pair>> adjList,boolean online[], int mid, long k){
        int n = online.length;
        long dist[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.weight, b.weight));
        dist[0]= 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            int node = t.node;
            long wght = t.weight;
            if (wght > dist[node]) continue;
            if (node == n - 1) return wght <= k;
            for(Pair p : adjList.get(node)){
                if(!online[p.node]) continue;
                if(p.weight < mid) continue;
                if( wght+p.weight < dist[p.node]){
                    dist[p.node] = wght+p.weight;
                    pq.add(new Pair(p.node,dist[p.node]));
                }
            }
        }

        return dist[n-1]<=k;
    }
}