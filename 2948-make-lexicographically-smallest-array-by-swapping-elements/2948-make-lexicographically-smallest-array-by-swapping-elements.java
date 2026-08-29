class Solution {
    class pair{
        int idx;
        int num;
        pair(int a, int b){
            idx = a;
            num = b;
        }
    }
    int par[];
    int rank[];
    int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }

    void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(parA == parB) return;

        if(rank[parA] > rank[parB]){
            par[parB] = parA;
        }
        else if(rank[parB] > rank[parA]){
            par[parA] = parB;
        }
        else{
            par[parA] = parB;
            rank[parB]++;
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        par = new int[n];
        rank = new int[n];
        for( int i = 0; i< n ; i ++){
            par[i] = i;
        }
        pair arr[] = new pair[n];
        for( int i = 0; i < n ; i++ ){
            arr[i] = new pair(i, nums[i]);
        }
        Arrays.sort(arr,(a,b)-> a.num - b.num);
        for( int i = 1; i < n ; i++){
            if(Math.abs(arr[i].num- arr[i-1].num) <= limit){
                union(arr[i].idx,arr[i-1].idx);
            }
        }

        int res[] = new int[n];

        PriorityQueue<Integer> pq[] = new PriorityQueue[n];

        for( int i = 0; i < n; i++){
            pq[i] = new PriorityQueue<>((a,b)-> Integer.compare(nums[a],nums[b]));
        }

        for(int i=0; i < n ;i++){
            int par = find(i);
            pq[par].add(i);
        }
        for( int i = 0; i < n ; i++){
            int par = find(i);
            res[i] = nums[pq[par].poll()];
        }
        return res;
    }
}