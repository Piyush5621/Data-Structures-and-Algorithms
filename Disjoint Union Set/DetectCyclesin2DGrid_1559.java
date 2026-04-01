class Solution {
    int[] par;
    int rank[];
    class Disjoint{
        Disjoint(int n){
            par=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) par[i]=i;
        }
        int find(int x){
            if(par[x]==x) return x;
            return find(par[x]);
        }
        boolean union(int a,int b){
            int x_ref=find(a);
            int y_ref=find(b);
            if(x_ref==y_ref){
                return true;
            }
            if(rank[x_ref]<rank[y_ref]){
                par[x_ref]=y_ref;
            }
            else if(rank[x_ref]>rank[y_ref]){
                par[y_ref]=x_ref;
            }
            else{
                par[y_ref]=x_ref;
                rank[x_ref]++;
            }

            return false;
        }
    } 
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Disjoint dj=new Disjoint(n*m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char a=grid[i][j];
                if( i+1<n &&  grid[i+1][j]==a && dj.union(i*m+j,(i+1)*m+j)){
                    return true;
                }
                if(j+1<m &&  grid[i][j+1]==a && dj.union(i*m+j,i*m+(j+1))){
                    return true;
                }
            }
        }

        return false;
    }
}