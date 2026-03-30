class Solution {
    int par[];
    int rank[];
    int cnt=0;
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

            if(x_ref==y_ref){
                cnt++;
            }

            if(rank[x_ref]<rank[y_ref]){
                par[x_ref]=y_ref;
            }
            else if(rank[x_ref]> rank[y_ref]){
                par[y_ref]=x_ref;
            }
            else{
                par[y_ref]=x_ref;
                rank[y_ref]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        Union u=new Union(n);
        for(int arr[]: connections){
            u.union(arr[0],arr[1]);
        }
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(u.find(par[i]));
        }

        int nc=set.size()-1;
        if(nc>cnt){
            return -1;
        }
        return set.size()-1;
    }
}