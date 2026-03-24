class Solution {
    int par[];
    int rank[];
    boolean exist=true;
    class Union{
        Union(int n){
            par=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) par[i]=i;
        }

        int find(int x){
            if(par[x]==x) return x;
            return find(par[x]);
        }

        void union(int a,int b){
            int x_ref=find(a);
            int y_ref=find(b);

            if(rank[x_ref]<rank[y_ref]){
                if(par[x_ref]==y_ref){
                    exist=false;
                }
                par[x_ref]=y_ref;
            }
            else if(rank[x_ref]> rank[y_ref]){
                if(par[y_ref]==x_ref){
                    exist=false;
                }
                par[y_ref]=x_ref;
            }
            else{
                if(par[y_ref]==x_ref){
                    exist=false;
                }
                par[y_ref]=x_ref;
                rank[y_ref]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Union u=new Union(n+1);
        for(int i=0;i<n;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            u.union(a,b);
            if(!exist){
                return new int[]{a,b};
            }
        }

        return new int[]{};
    }
}