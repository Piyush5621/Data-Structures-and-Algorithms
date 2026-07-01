class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int rr[] = new int[]{-1,0,1,0};
        int cc[] = new int[]{0,1,0,-1};

        int n = grid.size();
        int dist[][] = new int[n][n];
        for(int ar[] : dist){
            Arrays.fill(ar,Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();

        for(int i =0; i<n ;i++){
            for(int j=0; j<n ;j++){
                if(grid.get(i).get(j)==1){
                    q.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int or = arr[0];
            int oc = arr[1];

            for(int i=0; i<4; i++){
                int nr = or + rr[i];
                int nc = oc + cc[i];

                if(nr>=0 && nc >=0 && nr<n && nc < n ){
                    if(dist[or][oc]+1<dist[nr][nc]){
                        dist[nr][nc] = dist[or][oc]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[2], a[2]));
        pq.add(new int[]{0,0,dist[0][0]});
        boolean visited[][] = new boolean[n][n]; 
        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int d = arr[2];
            if(r==n-1 && c==n-1){
                return d;
            }
            for(int i=0; i<4; i++){
                int nr = r + rr[i];
                int nc = c + cc[i];

                if(nr>=0 && nc >=0 && nr<n && nc < n && !visited[nr][nc] ){
                    visited[nr][nc] = true;
                    int newDist = Math.min(d,dist[nr][nc]);
                    pq.add(new int[]{nr,nc,newDist}); 
                }
            }

        }
        return -1;
    }
}