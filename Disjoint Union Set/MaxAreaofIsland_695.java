class Solution {
    int par[];
    int rank[];
    class DSU{
        DSU(int n){
            par=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) par[i]=i;
        }
        int find(int x){
            if(par[x]==x) return x;
            return par[x]=find(par[x]);
        }
        void union(int a,int b){
            int par_a=find(a);
            int par_b=find(b);

            if(rank[par_a]<rank[par_b]){
                par[par_a]=par_b;
            }
            else if(rank[par_a]>rank[par_b]){
                par[par_b]=par_a;
            }
            else{
                par[par_b]=par_a;
                rank[par_a]++;
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] vist=new boolean[n][m];
        DSU dj=new DSU(n*m);
        int maxm=0;
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vist[i][j]==false){
                    Queue<int[]>q=new ArrayDeque<>();
                    q.add(new int[]{i,j});
                    vist[i][j]=true;
                    while(!q.isEmpty()){
                        int a[]=q.poll();
                        int or=a[0];
                        int oc=a[1];
                        for(int k=0;k<4;k++){
                            int nr=or+rr[k];
                            int nc=oc+cc[k];
                            if(nr>=0 && nr<n && nc>=0 && nc<m && !vist[nr][nc] && grid[nr][nc]==1){
                                int indx1=or*m+oc;
                                int indx2=nr*m+nc;
                                vist[nr][nc]=true;
                                q.add(new int[]{nr,nc});
                                dj.union(indx1,indx2);
                            }
                        }
                    }
                }
            }
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int parent=dj.find(par[i*m+j]);
                    map.put(parent, map.getOrDefault(parent,0)+1);
                }
            }
        }
        for(int x: map.values()){
            maxm=Math.max(maxm,x);
        }
        return maxm;

    }
}