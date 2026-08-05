class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for( int i = 0; i < n ; i++) adjList.add(new ArrayList<>());
        int degree[] = new int[n];
        for( int arr[] : invocations){
            int u = arr[0];
            int v = arr[1];
            adjList.get(u).add(v);
            degree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean suspicious[] = new boolean[n];
        suspicious[k] = true;

        
        q.add(k);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nbr : adjList.get(curr)){
                if(!suspicious[nbr]){
                    q.add(nbr);
                    suspicious[nbr] = true;
                }
                
            }
        }

        for( int arr[] : invocations){
            int u = arr[0], v = arr[1];
            if(!suspicious[u] && suspicious[v]){
                List<Integer> ans = new ArrayList<>();
                for(int i = 0; i <n; i++ ){
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for( int i = 0; i< n; i++){
            if(!suspicious[i]) ans.add(i);
        }

        return ans;


    }
}