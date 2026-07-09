class Solution {
    int par[];
    int rank[];
    public int find(int x){
        if(par[x]==x) return x;
        return par[x]=find(par[x]);
    }

    public void union(int a, int b){
        int par_a = find(a);
        int par_b = find(b);

        if(par_a == par_b) return;

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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        par = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            par[i] = i;
        } 

        for( int i =1; i < nums.length; i++ ){
            if( (nums[i] - nums[i-1]) <= maxDiff){
                union(i,i-1);
            }
        }

        boolean result[] = new boolean[queries.length];
        int i = 0;
        for(int arr[] :  queries){
            if( find(arr[0]) == find(arr[1])){
                result[i] = true;
            }
            i++;
        }

        return result;

    }
}