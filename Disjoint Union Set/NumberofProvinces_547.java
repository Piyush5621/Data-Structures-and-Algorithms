class Solution {
        int parent[];
        int rank[];
        class Disjoint{
        Disjoint(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }

        int find(int x){
            if(parent[x]==x) return x;
            return find(parent[x]);
        }

        void union(int a,int b){
            int x_rep=find(a);
            int y_rep=find(b);

            if(rank[x_rep]<rank[y_rep]){
                parent[x_rep]=y_rep;
            }
            else if(rank[x_rep]> rank[y_rep]){
                parent[y_rep]=x_rep;
            }
            else{
                parent[y_rep]=x_rep;
                rank[y_rep]++;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        Disjoint dj=new Disjoint(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    dj.union(i,j);
                }
            }
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(dj.find(parent[i]));
        }

        return set.size();
    }
}