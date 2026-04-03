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
            int a_ref=find(a);
            int b_ref=find(b);
            if(rank[a_ref]<rank[b_ref]){
                par[a_ref]=b_ref;
            }
            else if(rank[a_ref]> rank[b_ref]){
                par[b_ref]=a_ref;
            }
            else{
                par[b_ref]=a_ref;
                rank[a_ref]++;
            }
        }
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n=row*col;
        DSU dj=new DSU(n+2);
        boolean [][] visited=new boolean[row][col];
        int rr[] = {-1, 1, 0, 0};
        int cc[] = {0, 0, -1, 1};
        int top=row*col;
        int bottom=row*col+1;
        int count=0;
        for(int i=cells.length-1 ;i>=0; i--){
            int a=cells[i][0]-1;
            int b=cells[i][1]-1;
            visited[a][b]=true;
            int node=a*col+b;
            if(a==0) dj.union(node,top);
            if(a==row-1) dj.union(node,bottom);
            for(int j=0;j<4;j++){
                int na=a+rr[j];
                int nb=b+cc[j];
                if(na>=0 && na<row && nb>=0 && nb<col &&visited[na][nb]){
                    int newnode=na*col+nb;
                    dj.union(node,newnode);
                }
            }
            if(dj.find(top)==dj.find(bottom)){
                return i;
            }

        }
        return 0;
    }
}