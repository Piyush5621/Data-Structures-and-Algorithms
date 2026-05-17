class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean visited[] = new boolean[arr.length];
        visited[start] = true; 
        while(!q.isEmpty()){
            int curr = q.poll();
            if(arr[curr]==0){
                return true;
            }
            int a = curr + arr[curr];
            int b = curr - arr[curr];
            if(a>=0 && a<arr.length && !visited[a]){
                q.add(a);
                visited[a]=true;
            }
            if(b>=0 && b<arr.length &&!visited[b] ){
                q.add(b);
                visited[b]=true;
            }
        }
        return false;
    }
}