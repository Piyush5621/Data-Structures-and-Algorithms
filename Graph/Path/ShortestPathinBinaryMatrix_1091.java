class Triple{
    int first;
    int second;
    int third;
    Triple(int a,int b,int c){
        first=a;
        second=b;
        third=c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int dis[][]=new int[n][n];
        Queue<Triple> q=new LinkedList<>();
        for(int i=0;i<n;i++) Arrays.fill(dis[i],Integer.MAX_VALUE);
        q.add(new Triple(0,0,0));
        dis[0][0]=0;
        int r[]=new int[]{-1,-1,0,1,1,1,0,-1};
        int c[]=new int[]{0,1,1,1,0,-1,-1,-1};
        if(grid[0][0]!=0){
            return -1;
        }
        int ans=0;
        while(!q.isEmpty()){
            Triple t=q.poll();
            int or=t.first;
            int oc=t.second;
            int od=t.third;
            for(int i=0;i<8;i++){
                int nr=r[i]+or;
                int nc=c[i]+oc;
                if(nr >=0 && nr<n && nc<n && nc >=0 && grid[nr][nc]==0 && od+1<dis[nr][nc] ){
                    int nd=od+1;
                    dis[nr][nc]=nd;
                    if(nr==n-1 && nc==n-1){
                        return dis[nr][nc]+1;
                    }
                    q.add(new Triple(nr,nc,nd));
                }
            }
        } 

        return dis[n-1][n-1]==Integer.MAX_VALUE ? -1: 1;

    }
}

// 📌 Complexity

// Time: O(n²)

// Space: O(n²)