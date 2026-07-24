class Solution {
    int par[];
    int rank[];
    int ans;
    class DSU{
        DSU(int n ){
            par = new int[n];
            rank = new int[n];
            for(int i = 0; i < n ; i++){
                par[i] = i;
            }
            ans = n;
        }

        int find(int x){
            if(par[x] == x){
                return x;
            }
            return par[x] = find(par[x]); 
        }

        void union(int a, int b){
            int par_a = find(a);
            int par_b = find(b);

            if(par_a == par_b){
                return ;
            }

            if(rank[par_a] < rank[par_b]){
                par[par_a] = par_b;
            }
            else if(rank[par_a] > rank[par_b]){
                par[par_b] = par_a;
            }
            else{
                par[par_b] = par_a;
                rank[par_a]++;
            }
        }


    }
    public int countCompleteComponents(int n, int[][] edges) {
        DSU d = new DSU(n);
        int count = 0;
        int Nedges[] = new int[n];
        int nodes[] = new int[n];
        for(int arr[] :  edges){
            d.union(arr[0],arr[1]);
        }
        for (int i = 0; i < n; i++) {
            nodes[d.find(i)]++;
        }

        for(int arr[] : edges){
            Nedges[d.find(arr[0])]++;
        }

        for(int i=0; i< n ;i++){
            int node = nodes[i];
            if (node == 0) continue; 
            if(Nedges[i] == node*(node-1)/2){
                count++;
            }
        }

        return count;
    }
}