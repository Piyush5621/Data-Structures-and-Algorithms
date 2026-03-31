class Solution {
    int par[];
    class Disjoint{
        Disjoint(int n){
            par=new int[n];
            for(int i=0;i<n;i++) par[i]=i;
        }
        int find(int x){
            if(par[x]==x) return x;
            return par[x]=find(par[x]);
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        Disjoint dj=new Disjoint(n+1);
        int candidate_a[]=null;
        int candidate_b[]=null;
        int parent[]=new int[n+1];
        for(int ar[]: edges){
            int p=ar[0];
            int c=ar[1];

            if(parent[c]!=0){
                candidate_b=ar;
                candidate_a=new int[]{parent[c],c};
            }
            else{
                parent[c]=p;
            }
        }
        for(int ar[]: edges){
            if (candidate_b != null && ar == candidate_b) continue;
            int a=dj.find(ar[0]);
            int b=dj.find(ar[1]);

            if(a==b){
                if (candidate_a != null) return candidate_a;
                return ar;
            }
            else{
                par[a]=b;
            }
        }

        return candidate_b;
    }
}